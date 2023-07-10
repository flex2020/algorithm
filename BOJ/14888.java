import java.util.Scanner;

public class Main {
    public static int max = -2147483648;
    public static int min = 2147483647;
    public static int N = 0;
    public static int[] numbers;
    public static void getSolution(int depth, int currentResult, int[] operators) {
        //
        if (depth == N) {
            max = Math.max(max, currentResult);
            min = Math.min(min, currentResult);
            return;
        }
        for (int i=0; i<4; i++) {
            int result = currentResult;
            if (operators[i] > 0) {
                if (i == 0) {
                    result += numbers[depth];
                } else if (i == 1) {
                    result -= numbers[depth];
                } else if (i == 2) {
                    result *= numbers[depth];
                } else if (i == 3) {
                    result /= numbers[depth];
                }
                operators[i]--;
                getSolution(depth + 1, result, operators);
                operators[i]++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = sc.nextInt();
        }

        int[] operators = new int[4];
        for (int i=0; i<4; i++) {
            operators[i] = sc.nextInt();
        }

        getSolution(1, numbers[0], operators);

        System.out.println(max);
        System.out.println(min);
        sc.close();
    }
}