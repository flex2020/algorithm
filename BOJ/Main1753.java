package boj;

import java.io.*;
import java.util.*;

public class Main1753 {
	private static int V, E, K;
	private static int[] shortestPath;
	private static List<List<Node>> graph;
	private static StringBuilder answer;
	
	static class Node implements Comparable<Node> {
		int node, cost;

		public Node(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		shortestPath = new int[V+1];
		Arrays.fill(shortestPath, Integer.MAX_VALUE);
		graph = new ArrayList<>();
		answer = new StringBuilder();
		for (int i=0; i<=V; i++) graph.add(new ArrayList<>());
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
		}
		dijkstra();
		for (int i=1; i<=V; i++) {
			answer.append(shortestPath[i] == Integer.MAX_VALUE ? "INF\n" : shortestPath[i] + "\n");
		}
		System.out.print(answer.toString());
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, 0));
		shortestPath[K] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (shortestPath[cur.node] < cur.cost) continue;
			
			for (Node next : graph.get(cur.node)) {
				int cost = cur.cost + next.cost;
				if (cost < shortestPath[next.node]) {
					shortestPath[next.node] = cost;
					pq.offer(new Node(next.node, cost));
				}
			}
		}
	}
}
