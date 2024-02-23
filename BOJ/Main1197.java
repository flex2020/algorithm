package boj;

import java.io.*;
import java.util.*;

public class Main1197 {
	private static int V, E;
	private static long answer;
	private static List<List<Node>> graph;
	
	static class Node implements Comparable<Node> {
		int index, weight;

		public Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		prim();
		
		System.out.println(answer);
	}
	
	private static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		boolean[] visited = new boolean[V+1];
		
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			int cur = n.index;
			int cost = n.weight;
			
			if (visited[cur]) continue;
			visited[cur] = true;
			answer += cost;
			
			for (Node next : graph.get(cur)) {
				if (!visited[next.index]) {
					pq.offer(next);
				}
			}
		}
		
	}
}
