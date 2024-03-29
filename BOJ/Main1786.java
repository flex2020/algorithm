package boj;

import java.io.*;
import java.util.*;

public class Main1786 {
	private static int count;
	private static StringBuilder sb;
	private static String T, P;
	private static int[] table; // 접두사와 접미사가 일치하는 최대길이를 담을 배열 선언 => 실패배열
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		count = 0;
		sb = new StringBuilder();
		
		setTable();
		kmp();
		System.out.println(count);
		System.out.println(sb.toString());
	}
	
	private static void setTable() {
		table = new int[P.length()];
		
		int j = 0; // 패턴 포인터
		
		// i, j가 가리키는 값이 일치한다 -> 둘다 증가
		// 불일치한다 -> i증가 for문
		for (int i=1; i<P.length(); i++) {
			
			// 패턴문자열 내에서 i, j가 가리키는 값이 다를때
			// while 문 안에 넣는 이유 => 중간단계를 건너뛰고 최대한 점프하기 위해
			while (j > 0 && P.charAt(i) != P.charAt(j)) {
				// j의 값을 마지막 일치한 곳의 실패배열값으로 바꾼다
				j = table[j-1];
			}
			
			// 패턴문자열 내에서 i, j가 가리키는 값이 같다면
			if (P.charAt(i) == P.charAt(j)) {
				table[i] = ++j; // i번째의 최대 길이는 ++j한 값
			}
		}
	}
	
	private static void kmp() {
		int j = 0;
		for (int i=0; i<T.length(); i++) {
			while (j > 0 && T.charAt(i) != P.charAt(j)) {
				j = table[j-1];
			}
			
			// 부모와 패턴이 일치하는 경우
			if (T.charAt(i) == P.charAt(j)) {
				// j의 값이 패턴의 길이-1 이라면 찾은 것
				if (j == P.length() - 1) {
					sb.append((i - P.length() + 2) + " ");
					count += 1;
					j = table[j];
				} else {
					j += 1; // 다 찾은 것이 아니기 때문에 j증가
				}
			}
		}
	}
}
