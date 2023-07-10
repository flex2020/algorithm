import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int N, M;
    public static List<String> list;
    public static void backTracking(int m, String s, boolean[] numbers) {
        if (m == 0) {
            list.add(s);
            return;
        }
        for (int i=1; i<=N; i++) {
            if (!numbers[i]) {
                numbers[i] = true;
                backTracking(m - 1, s + i, numbers);
                numbers[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        boolean[] numbers = new boolean[N + 1];
        list = new ArrayList<>();
        backTracking(M, "", numbers);
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            for (int j=0; j<M; j++) {
                System.out.print(s.charAt(j) + " ");
            }
            System.out.println("");
        }

        sc.close();
    }
}