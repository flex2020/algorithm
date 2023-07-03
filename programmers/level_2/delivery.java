class Solution {
    public static int[][] graph;
    public static int[] d;
    public static boolean[] visit;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        

        
        // road 배열을 탐색하며 그래프 설정
        graph = new int[N + 1][N + 1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (i != j) graph[i][j] = 987654321;
            }
        }
        for (int i=0; i<road.length; i++) {
            int vill1 = road[i][0];
            int vill2 = road[i][1];
            int weight = road[i][2];
            // 기존 가중치가 0인 경우와
            // 기존 가중치가 더 큰 경우 더 작은 가중치로 바꿔줌
            if (graph[vill1][vill2] > weight) {
                graph[vill1][vill2] = weight;
                graph[vill2][vill1] = weight;
            }
        }
        
        // 다익스트라 배열 초기화
        d = new int[N + 1];
        for (int i=2; i<=N; i++) {
            d[i] = d[i] == 0 ? 987654321 : graph[1][i];
        }
        
        // 방문 체크 배열 초기화
        visit = new boolean[N + 1];
        visit[1] = true;
        
        // 다익스트라 알고리즘
        for (int i=1; i<=N-1; i++) {
            int minWeight = 987654321;
            int minNodeIndex = 1;
            for (int j=2; j<=N; j++) {
                // i와 인접한 가장 가까운 노드를 찾음
                if (!visit[j] && minWeight > d[j]) {
                    minWeight = d[j];
                    minNodeIndex = j;
                }
            }
            visit[minNodeIndex] = true; // 가장 가까운 노드에 방문
            
            // 방문한 노드와 인접한 노드의 1 -> j 거리 갱신
            for (int j=2; j<=N; j++) {
                if (d[j] > d[minNodeIndex] + graph[minNodeIndex][j]) {
                    d[j] = d[minNodeIndex] + graph[minNodeIndex][j];
                }
            }
        }

        // 최단거리가 K 이하인 마을의 수 확인
        for (int i=1; i<=N; i++) {
            if (d[i] <= K) answer++;
        }
        return answer;
    }
}