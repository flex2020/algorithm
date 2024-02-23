package boj;

import java.io.*;
import java.util.*;

public class Main17471 {
	private static int N, answer, area1, area2, total;
	private static int[] population;
	private static boolean[] visited;
	private static List<List<Integer>> graph;
	private static List<Integer> list1, list2;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		population = new int[N+1];
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		area1 = 0;
		area2 = 0;
		graph = new ArrayList<>();
		graph.add(new ArrayList<>());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			total += population[i];
		}
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			graph.add(new ArrayList<>());
			for (int j=0; j<cnt; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		powerset(0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	// 1구역 먼저 골라본다
	private static void powerset(int idx, int area1) {
		if (idx == N) {
			// 만약 한개도 고르지 않았다면 PASS
			if (list1.size() == 0 || list1.size() == N) return;
			visited = new boolean[N+1];
			list2 = new ArrayList<>();
			// 2구역을 구한다.
			for (int i=1; i<=N; i++) {
				if (list1.contains(i)) continue;
				list2.add(i);
			}
			
			// 1구역, 2구역이 전부 연결되었는지 확인한다.
			dfs(list1.get(0), list1);
			dfs(list2.get(0), list2);
			for (int i=1; i<=N; i++) {
				if (!visited[i]) return;
			}
			
			// 둘다 연결되어있다면 인구수의 차이를 구한다
			int area2 = total - area1;
			answer = Math.min(answer, Math.abs(area2 - area1));
			
			return;
		}
		
		// 고른다.
		list1.add(idx+1);
		powerset(idx + 1, area1 + population[idx + 1]);
		
		list1.remove((Integer) (idx + 1));
		powerset(idx + 1, area1);
		
	}
	
	private static void dfs(int current, List<Integer> list) {
		visited[current] = true;
		
		for (int next : graph.get(current)) {
			if (list.contains(next) && !visited[next]) {
				dfs(next, list);
			}
		}
	}
		
}
