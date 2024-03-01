package boj;

import java.io.*;
import java.util.*;

public class Main17255 {
	private static String N;
	private static Set<String> set;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		set = new HashSet<>();
		recursive("", "");
		System.out.println(set.size());
	}
	
	private static void recursive(String number, String s) {
		if (number.equals(N)) {
			set.add(s);
			return;
		}
		// 현재 숫자 왼쪽, 오른쪽에 들어갈 수 있는 수를 뽑아낸다.
		List<Character> left = new ArrayList<>();
		List<Character> right = new ArrayList<>();
		for (int i=0; i<N.length() - number.length() + 1; i++) {
			// 문자열을 비교해서 같다면
			String sub = N.substring(i, i+number.length());
			if (!sub.equals(number)) continue;
			if (i - 1 >= 0) {
				left.add(N.charAt(i-1));
			}
			if (i + number.length() < N.length()) {
				right.add(N.charAt(i + number.length()));
			}
		}
		
		// 현재 수 왼쪽에 넣는다.
		for (int i=0; i<left.size(); i++) {
			String next = left.get(i) + number;
			recursive(next, s + next);
		}
		// 현재 수 오른쪽에 넣는다.
		for (int i=0; i<right.size(); i++) {
			String next = number + right.get(i);
			recursive(next, s + next);
		}
	}
}
