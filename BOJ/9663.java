import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int answer = 0;

    public static boolean check(int col, int[] cols, int row) {
        // col: 현재 놓으려는 열
        for (int i=1; i<row; i++) {
            // 다른 행에서 현재 놓으려는 열에 이미 놓은 경우
            if (cols[i] == col) return false;
            if ((i - row) % (cols[i] - col) == 0 && Math.abs((i - row) / (cols[i] - col)) == 1) return false;
        }
        return true;
    }

    public static void backTracking(int row, int[] cols) {
        // 마지막 까지 배치했다면 그 경우를 센다.
        if (row == N + 1) {
            answer++;
            return;
        }

        // 현재 행에 모든 열에 놓을 수 있는지 확인해보고 놓는다.
        // 퀸을 놓을 곳이 없으면 그만 둔다.
        for (int i=1; i<=N; i++) {
            if (check(i, cols, row)) {
                cols[row] = i;
                backTracking(row + 1, cols);
                cols[row] = -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] cols = new int[N + 1]; // 각 행에 놓을 수 있는 열을 나타냄
        Arrays.fill(cols, -1);
        backTracking(1, cols);

        System.out.println(answer);
    }
}