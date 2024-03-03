package swea;

import java.io.*;
import java.util.*;

public class Solution5672 {
	private static int N;
	private static String answer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			answer = "";
			String origin = "";
			for (int i=0; i<N; i++) {
				origin += br.readLine().trim();
			}
			
			for (int i=0; i<N-1; i++) {
				String temp1 = answer + origin.charAt(0);
				String temp2 = answer + origin.charAt(origin.length()-1);
				
				if (temp1.compareTo(temp2) < 0) {
					origin = origin.substring(1, origin.length());
					answer = temp1;
				} else if (temp1.compareTo(temp2) > 0) {
					origin = origin.substring(0, origin.length()-1);
					answer = temp2;
				} else {
					int start = 1;
					int end = origin.length() - 2;
					while (start <= end) {
						if (origin.charAt(start) != origin.charAt(end)) break;
						start += 1;
						end -= 1;
					}
					// 앞에꺼 선택
					if (origin.charAt(start) < origin.charAt(end)) origin = origin.substring(1, origin.length());
					// 뒤에꺼 선택
					else origin = origin.substring(0, origin.length()-1);
					answer = temp1;
				}
			}
			answer += origin;
			System.out.println("#" + tc + " " + answer);
		}
	}
	
}

