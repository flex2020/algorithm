import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[][] answer;
    public static int count = 0;
    public static boolean check(int[][] sudoku, int row, int col, int number) {
        // 현재 상황에서 (row, col) 위치에 스도쿠가 들어갈 수 있는지 확인
        for (int i=0; i<9; i++) {
            // 같은 row 행이나 col 열에 사용된 적이 있는 숫자면 사용 불가
            if (number == sudoku[row][i]) return false;
            if (number == sudoku[i][col]) return false;
        }

        // 같은 블럭 내에서 사용된 숫자인지 확인
        for (int i=row/3*3; i<row/3*3+3; i++) {
            for (int j=col/3*3; j<col/3*3+3; j++) {
                if (number == sudoku[i][j]) return false;
            }
        }

        return true;
    }
    public static void backTracking(int[][] sudoku, int row, int col) {
        // 이미 완성된 스도쿠가 존재하면 하지 않음
        if (count == 1) return;
        if (sudoku[row][col] == 0) {
            for (int number=1; number<=9; number++) {
                // (row, col) 의 위치에 number 를 채울 수 있는지 확인
                // 채울 수 있다면 채워넣고 다음 빈칸으로 이동하여 백트래킹 진행
                if (check(sudoku, row, col, number)) {
                    sudoku[row][col] = number;
                    int startRow = -1;
                    int startCol = -1;
                    for (int i=0; i<9; i++) {
                        for (int j=0; j<9; j++) {
                            if (sudoku[i][j] == 0 && startRow == -1 && startCol == -1) {
                                startRow = i;
                                startCol = j;
                                break;
                            }
                        }
                        if (startRow != -1 && startCol != -1) {
                            break;
                        }
                    }
                    // 다음 빈칸이 있다면 빈칸에서 백트래킹 진행
                    if (startRow != -1 && startCol != -1) {
                        backTracking(sudoku, startRow, startCol);
                    } else {
                        for (int i=0; i<9; i++) {
                            for (int j=0; j<9; j++) {
                                answer[i][j] = sudoku[i][j];
                            }
                        }
                        count = 1;
                        return;
                    }
                    sudoku[row][col] = 0;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        answer = new int[9][9];
        int startRow = -1;
        int startCol = -1;
        // 스도쿠 입력 받기
        for (int i=0; i<9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<9; j++) {
                sudoku[i][j] = Integer.parseInt(line[j]);
                if (sudoku[i][j] == 0 && startRow == -1 && startCol == -1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        // 백트래킹을 통해 스도쿠 완성
        backTracking(sudoku, startRow, startCol);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}