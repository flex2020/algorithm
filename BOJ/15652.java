import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static List<String> list;
    public static void backTracking(int m, String s) {
        if (m == 0) {
            list.add(s);
            return;
        }
        for (int i=1; i<=N; i++) {
            if (s.equals("") || s.charAt(s.length() - 1) - '0' <= i)
            backTracking(m - 1, s + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        backTracking(M, "");
        int size = list.size();
        for (int i=0; i<size; i++) {
            String s = list.get(i);
            for (int j=0; j<M; j++) {
                sb.append(s.charAt(j) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}