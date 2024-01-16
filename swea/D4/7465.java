package swea_d4;

import java.util.*;

public class P7465 {
	private static int N, M, answer;
	private static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			parent = new int[N+1];
			initParent();
			for (int i=0; i<M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				unionParent(a, b);
			}
			Set<Integer> s = new HashSet<>();
			for (int i=1; i<=N; i++) {
				findParent(i);
				s.add(parent[i]);
			}
			answer = s.size();
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void initParent() {
		for (int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
	
	private static int findParent(int a) {
		if (parent[a] != a) {
			parent[a] = findParent(parent[a]);
		}
		
		return parent[a];
	}
	
	private static void unionParent(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if (pa < pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
	}
}
