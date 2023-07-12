import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static int N;
    public static int answer = 987654321;
    public static int[][] stats;

    public static int getTeamStat(int[] teamMember) {
        int stat = 0;
        for (int i=0; i<N/2-1; i++) {
            for (int j=i+1; j<N/2; j++) {
                int m1 = teamMember[i];
                int m2 = teamMember[j];
                stat += stats[m1][m2] + stats[m2][m1];
            }
        }
        return stat;
    }
    public static void backTracking(int[] startMember, int minNumber, int count) {
        // 만약 start 팀이 정해졌다면
        // start 팀과 link 팀의 점수를 구하여 점수의 차이를 구한다
        // 정답을 점수의 차이가 최소인 것으로 갱신한다.
        if (count * 2 == N) {
            List<Integer> linkList = new ArrayList<>();
            List<Integer> startList = Arrays.stream(startMember)
                    .boxed()
                    .collect(Collectors.toList());
            for (int i=0; i<N; i++) {
                if (!startList.contains(i)) {
                    linkList.add(i);
                }
            }
            int[] linkMember = new int[N/2];
            for (int i=0; i<linkList.size(); i++) {
                linkMember[i] = linkList.get(i);
            }
            int startTeamStat = getTeamStat(startMember);
            int linkTeamStat = getTeamStat(linkMember);
            int gap = Math.abs(startTeamStat - linkTeamStat);
            answer = Math.min(answer, gap);

            return;
        }
        for (int i=0; i<N/2; i++) {
            if (startMember[i] != -1) continue; // 스타트 팀의 i번째 팀원이 정해졌다면, 건너뜀.
            // 팀원이 정해지지 않았다면, 최소 숫자부터 고름
            for (int j=minNumber; j<N; j++) {
                startMember[i] = j;
                backTracking(startMember, j + 1, count + 1);
                startMember[i] = -1;
            }
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        for (int i=0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                stats[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[] startMembers = new int[N/2];
        Arrays.fill(startMembers, -1);
        backTracking(startMembers, 0, 0);
        System.out.println(answer);
    }
}