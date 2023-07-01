import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        for (String[] arr: clothes) {
            map.put(arr[1], new ArrayList<String>());
        }
        for (String[] arr: clothes) {
            List<String> list = map.get(arr[1]);
            list.add(arr[0]);
        }
        
        for (String key : map.keySet()) {
            answer *= (map.get(key).size() + 1);
        }
        
        return answer - 1;
    }
}