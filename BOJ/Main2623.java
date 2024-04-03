package boj;

import java.io.*;
import java.util.*;

public class Main2623 {
	private static int N, M, count;
	private static int[] indegree;
	private static List<Set<Integer>> graph;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N+1];
		graph = new ArrayList<>();
		for (int i=0; i<=N; i++) graph.add(new TreeSet<>());
		for (int i=0; i<M; i++) {
			String[] input = br.readLine().split(" ");
			for (int j=1; j<input.length-1; j++) {
				int a = Integer.parseInt(input[j]);
				int b = Integer.parseInt(input[j+1]);
				if (a == b) continue;
				if (!graph.get(a).contains(b)) indegree[b] += 1;
				graph.get(a).add(b);
				
			}
		}
		sb = new StringBuilder();
		topologySort();
		if (count == N) System.out.println(sb.toString());
		else System.out.println(0);
	}
	
	private static void topologySort() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=1; i<=N; i++) {
			if (indegree[i] == 0) q.offer(i);
		}
		count = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			count += 1;
			sb.append(cur + " ");
			
			for (int next : graph.get(cur)) {
				indegree[next] -= 1;
				
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
	}
}
