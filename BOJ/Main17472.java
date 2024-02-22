package boj;

import java.io.*;
import java.util.*;

public class Main17472 {
	private static int N, M, number, answer;
	private static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	private static int[][] map, graph;
	private static int[] parent;
	private static List<Edge> edgeList;
	
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(end, start, weight);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			return end == other.end && start == other.start && weight == other.weight || start == other.end && end == other.start && weight == other.weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		graph = new int[10][10];
		parent = new int[10];
		edgeList = new ArrayList<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				graph[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// 섬에 번호 붙이기
		number = 2;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] != 1) continue;
				dfs(i, j);
				number += 1;
			}
		}
		
		// 각 나라로부터 모든 나라까지 다리 놓기
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] != 0) {
					// 현재나라에서부터 k까지 최소 다리 놓기
					buildBridge(i, j);
				}
			}
		}
		
//		display();
//		System.out.println();
//		displayGraph();
		
		// 인접행렬 -> 간선리스트
		// 모든 섬 연결이 가능한지도 체크
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (graph[i][j] != Integer.MAX_VALUE) {
					Edge e = new Edge(i, j, graph[i][j]);
					if (!edgeList.contains(e)) edgeList.add(e);
				}
			}
		}
		
		// 가중치 순으로 정렬
		Collections.sort(edgeList);
		
		makeSet();
		// 크루스칼 알고리즘으로 MST 구하기
		for (Edge e : edgeList) {
			if (find(e.start) != find(e.end)) {
				union(e.start, e.end);
				answer += e.weight;
			}
		}
		
		// 만든 MST가 전부 연결되어 있는지 확인하기
		boolean allLink = check();
		
		System.out.println(answer == 0 || !allLink ? -1 : answer);
	}
	
	private static void makeSet() {
		parent = new int[10];
		for (int i=0; i<10; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		if (parent[a] != a) {
			parent[a] = find(parent[a]);
		}
		return parent[a];
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pb > pa) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
	}
	
	private static boolean check() {
		for (int i=2; i<number-1; i++) {
			if (find(i) != find(i+1)) return false;
		}
		return true;
	}

	private static void dfs(int x, int y) {
		map[x][y] = number;
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 1) continue;	
			dfs(nx, ny);
		}
	}
	private static void buildBridge(int x, int y) {
		// 4방향으로  나올때까지 ㄱㄱ
		int start = map[x][y];
		L: for (int i=0; i<4; i++) {
			int nx = x;
			int ny = y;
			int len = 0;
			int end = 0;
			while (true) {
				nx += dx[i];
				ny += dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == map[x][y]) continue L;
				if (map[nx][ny] != 0) {
					end = map[nx][ny];
					break;
				}
				len += 1;
			}
			if (end != 0 && len > 1) {
				graph[start][end] = Math.min(graph[start][end], len);
			}
		}
	}
}
