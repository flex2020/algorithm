package swea;

import java.io.*;
import java.util.*;

public class Solution5656 {
	private static int N, W, H, answer, total, brick;
	private static int[][] board, tempBoard;
	private static List<Integer> sel;
	private static int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			brick = 0;
			sel = new ArrayList<>();
			board = new int[H][W];
			tempBoard = new int[H][W];

			for (int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] > 0) brick += 1;
				}
			}
			recursive(0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	
	
	private static void boom(int x, int y) {
		total += 1;
		int dist = tempBoard[x][y] - 1;
		tempBoard[x][y] = 0;
		for (int i=1; i<=dist; i++) {
			for (int d=0; d<4; d++) {
				int nx = x + dx[d] * i;
				int ny = y + dy[d] * i;
				if (nx < 0 || nx >= H || ny < 0 || ny >= W || tempBoard[nx][ny] == 0) continue;
				boom(nx, ny);
			}
		}
	}
	
	private static void pulldown() {
		for (int j=0; j<W; j++) {
			List<Integer> list = new ArrayList<>();
			for (int i=0; i<H; i++) {
				if (tempBoard[i][j] == 0) list.add(0);
			}
			for (int i=0; i<H; i++) {
				if (tempBoard[i][j] != 0) list.add(tempBoard[i][j]);
			}
			for (int i=0; i<H; i++) {
				tempBoard[i][j] = list.get(i);
			}
		}
	}
	
	private static void simulate() {
		copyBoard();
		total = 0;
		for (int y : sel) {
			for (int x=0; x<H; x++) {
				if (tempBoard[x][y] != 0) {
					boom(x, y);
					pulldown();
					break;
				}
			}
		}
		
		answer = Math.min(answer, brick - total);
	}
	
	private static void recursive(int idx) {
		if (idx == N) {
			simulate();
			return;
		}
		
		for (int i=0; i<W; i++) {
			sel.add(i);
			recursive(idx + 1);
			sel.remove(idx);
		}
	}
	
	private static void copyBoard() {
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				tempBoard[i][j] = board[i][j];
			}
		}
	}
	
	private static void display() {
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				System.out.print(tempBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
