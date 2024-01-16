package swea_d2;

import java.util.*;

public class P1974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			int answer = 0;
			int[][] sudoku = new int[9][9];
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			if (checkSudoku(sudoku)) {
				answer = 1;
			}
			System.out.println("#" + tc + " " + answer);
			
		}
		sc.close();
		
	}
	private static boolean checkSudoku(int[][] sudoku) {
		// 가로 확인
		for (int i=0; i<9; i++) {
			boolean[] checkList = new boolean[9];
			for (int j=0; j<9; j++) {
				checkList[sudoku[i][j]-1] = true;
			}
			for (boolean r : checkList) {
				if (!r) return false;
			}
		}
		// 세로 확인
		for (int j=0; j<9; j++) {
			boolean[] checkList = new boolean[9];
			for (int i=0; i<9; i++) {
				checkList[sudoku[i][j]-1] = true;
			}
			for (boolean r : checkList) {
				if (!r) return false;
			}
		}
		// 9개의 사각형 확인
		for (int i=0; i<9; i+=3) {
			for (int j=0; j<9; j+=3) {
				boolean[] checkList = new boolean[9];
				for (int k=0; k<3; k++) {
					for (int l=0; l<3; l++) {
						checkList[sudoku[i+k][j+l]-1] = true;
					}
				}
				for (boolean r : checkList) {
					if (!r) return false;
				}
			}
		}
		
		return true;
	}
}
