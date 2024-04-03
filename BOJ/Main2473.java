package boj;

import java.io.*;
import java.util.*;

public class Main2473 {
	private static int N;
	private static long answer1, answer2, answer3;
	private static List<Long> liquid;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		liquid = new ArrayList<>();
		for (int i=0; i<N; i++) liquid.add(Long.parseLong(st.nextToken()));
		Collections.sort(liquid);
		long min = Long.MAX_VALUE;
		L: for (int start=0; start<N-2; start++) {
			int mid = start + 1;
			int end = N - 1;
			
			while (true) {
				if (mid >= end) break;
				long sum = liquid.get(start) + liquid.get(mid) + liquid.get(end);
				long abssum = Math.abs(sum);
				// 0인 경우 답 출력 후 종료
				if (sum == 0) {
					answer1 = liquid.get(start);
					answer2 = liquid.get(mid);
					answer3 = liquid.get(end);
					break L;
				}
				// 최솟값이 갱신되면 답 갱신
				if (abssum < min) {
					min = abssum;
					answer1 = liquid.get(start);
					answer2 = liquid.get(mid);
					answer3 = liquid.get(end);
				}
				// 두 용액의 합이 0보다 작은 경우
				if (sum < 0) {
					mid += 1;
				}
				// 세 용액의 합이 0보다 큰 경우
				else {
					end -= 1;
				}
			}
		}
		
		System.out.println(answer1 + " " + answer2 + " " + answer3);
	}

}
