import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> el = new ArrayList<>();
        for (int i=0; i<K; i++) {
            el.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> mt = new ArrayList<>();

        for (int i=0; i<K; i++) {
            // 멀티탭이 꽉 차있지 않은 경우
            if (mt.size() < N && !mt.contains(el.get(i))) {
                mt.add(el.get(i));
                continue;
            }
            // 그리디 전략
            // 가장 나중에 사용하는 전자기기를 제거
            // 또는 사용하지 않을 전자기기를 제거
            if (mt.contains(el.get(i))) {
                continue;
            }
            int maxIndex = -1; // 현재로부터 가장 큰 거리
            int jIndex = -1; // 제거할 멀티탭의 위치
            boolean jump = false; // 건너뛰기 플래그
            // 멀티탭의 요소 중 가장 나중에 사용하는 전자기기 혹은 사용하지 않을 전자기기를 제거한다.
            for (int j=0; j<N; j++) {
                int mel = mt.get(j);
                boolean use = false;
                for (int k=i+1; k<K; k++) {
                    if (mel == el.get(k)) {
                        use = true; // 사용되므로 플래그 참
                        if (maxIndex < k) {
                            maxIndex = k;
                            jIndex = j;
                        }
                        break;
                    }
                }
                // 멀티탭의 전자기기가 다시 사용되지 않는 경우 제거
                if (!use) {
                    answer++;
                    mt.remove(j);
                    mt.add(j, el.get(i));
                    jump = true;
                    break;
                }
            }
            // 사용되지 않는 경우가 없었다면, 가장 나중에 사용하는 코드를 제거
            if (!jump) {
                answer++;
                mt.remove(jIndex);
                mt.add(jIndex, el.get(i));
            }
        }
        System.out.println(answer);
    }
}