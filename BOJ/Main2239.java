package boj;

import java.io.*;
import java.util.*;

public class Main2239 {
	private static int[][] sudoku = new int[9][9];
	private static int[][] answer = new int[9][9];
	private static boolean complete = false;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0; i<9; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j=0; j<9; j++) {
				sudoku[i][j] = temp[j] - '0';
			}
		}
		
		fillSudoku();
		display(answer);
	}
	
	private static void fillSudoku() {	
		// 스도쿠에 빈칸이 있는지 확인
		int x = -1, y = -1;
		L: for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (sudoku[i][j] == 0) {
					x = i;
					y = j;
					break L;
				}
			}
		}
		// 빈칸이 없으면 스도쿠가 완성된 것
		if (x == -1 && y == -1) {
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					answer[i][j] = sudoku[i][j];
				}
			}
			complete = true;
			return;
		}
		
		// 빈 칸에 1~9까지 들어갈 수 있는 것들을 넣어본다
		for (int i=1; i<=9; i++) {
			sudoku[x][y] = i;
			// x,y 자리에 해당 숫자가 들어갈 수 있다면 이어서 스도쿠 맞추기 진행
			if (check(x, y)) {
				fillSudoku();
				if (complete) return;
			}
			sudoku[x][y] = 0;
		}
	}
	
	private static boolean check(int x, int y) {
		// 1. 가로 확인
		int[] checkList = new int[10];
		
		for (int j=0; j<9; j++) {
			checkList[sudoku[x][j]] += 1;
		}
		
		for (int i=1; i<10; i++) {
			if (checkList[i] > 1) return false;
		}
		
		// 2. 세로 확인
		checkList = new int[10];
		
		for (int i=0; i<9; i++) {
			checkList[sudoku[i][y]] += 1;
		}
		
		for (int i=1; i<10; i++) {
			if (checkList[i] > 1) return false;
		}
		
		// 3. 박스 확인
		checkList = new int[10];
		int startX = x / 3 * 3;
		int startY = y / 3 * 3;
		for (int dx=0; dx<3; dx++) {
			for (int dy=0; dy<3; dy++) {
				checkList[sudoku[startX+dx][startY+dy]] += 1;
			}
		}
		for (int i=1; i<10; i++) {
			if (checkList[i] > 1) return false;
		}
		
		return true;
	}
	
	private static void display(int[][] board) {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
