import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        
        for (String id: id_list) {
            List<String> emptyList = new ArrayList<>();
            map.put(id, emptyList);
            countMap.put(id, 0);
        }
        
        for (String r: report) {
            String reporter = r.split(" ")[0];
            String reported = r.split(" ")[1];
            List<String> reporterList = map.get(reported);
            if (!reporterList.contains(reporter)) {
                reporterList.add(reporter);
            }
        }
        
        
        for (String id: id_list) {
            List<String> reporterList = map.get(id);
            // id를 가진 유저가 정지인 경우
            if (k <= reporterList.size()) {
                for (String reporter: reporterList) {
                    int count = countMap.get(reporter);
                    countMap.put(reporter, count + 1);
                }
            }
        }
        for (int i=0; i<id_list.length; i++) {
            answer[i] = countMap.get(id_list[i]);
        }
        return answer;
    }
}