import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        String[] numbers = s.split("-");
        int answer = 0;
        for (int i=0; i< numbers.length; i++) {
            String[] numbers2 = numbers[i].split("\\+");
            int sum = 0;
            for (int j=0; j< numbers2.length; j++) {
                sum += Integer.parseInt(numbers2[j]);
            }
            if (i == 0) answer += sum;
            else answer -= sum;
        }
        System.out.println(answer);
    }
}