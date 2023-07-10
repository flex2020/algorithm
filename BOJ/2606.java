import java.util.Scanner;

public class Main {
    public static int c = 0;
    public static int n = 0;
    public static int[][] network;
    public static int answer = 0;
    public static boolean[] visit;
    public static void dfs(int here) {
        // 더 이상 방문할 수 있는 노드가 없으면 종료
        // 다음 노드를 아직 방문하지 않았고, 연결이 되어 있다면 다음 노드 방문
        for (int i=2; i<=c; i++) {
            if (network[here][i] == 1 && !visit[i]) {
                visit[i] = true;
                answer++;
                dfs(i);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        network = new int[101][101];
        visit = new boolean[101];

        for (int i=0; i<n; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            network[c1][c2] = 1;
            network[c2][c1] = 1;
        }

        dfs(1);
        System.out.println(answer);
        sc.close();
    }
}