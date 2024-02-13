package boj;

import java.io.*;
import java.util.*;

public class Main1922 {
	private static int N, M;
	private static int[] parent;
	private static List<Edge> edges;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		edges = new ArrayList<>();
		
		for (int i=1; i<=N; i++) parent[i] = i;
		
		for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, c));
		}
		// 간선의 비용을 기준으로 오름차순 정렬
		Collections.sort(edges);
		int answer = 0;
		for (int i=0; i<M; i++) {
			Edge e = edges.get(i);
			if (find(e.a) != find(e.b)) {
				union(e.a, e.b);
				answer += e.c;
			}
		}
		System.out.println(answer);
	}
	private static int find(int a) {
		if (parent[a] != a) parent[a] = find(parent[a]);
		return parent[a];
	}
	
	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pb > pa) parent[pb] = pa;
		else parent[pa] = pb;
	}
}

class Edge implements Comparable<Edge> {
	int a, b, c;
	
	Edge(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public int compareTo(Edge o) {
		return c - o.c;
	}

	@Override
	public String toString() {
		return "Edge [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
}

