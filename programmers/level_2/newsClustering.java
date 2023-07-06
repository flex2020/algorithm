import java.util.*;
class Solution {
    public boolean isAlphabet(String s) {
        boolean result = true;
        for (int i=0; i<s.length(); i++) {
            if (!(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                return false;
            }
        }
        return true;
    }
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for (int i=0; i<str1.length()-1; i++) {
            StringBuilder sb = new StringBuilder("");
            sb.append(Character.toUpperCase(str1.charAt(i)));
            sb.append(Character.toUpperCase(str1.charAt(i+1)));
            if (isAlphabet(sb.toString())) list1.add(sb.toString());
        }
        for (int i=0; i<str2.length()-1; i++) {
            StringBuilder sb = new StringBuilder("");
            sb.append(Character.toUpperCase(str2.charAt(i)));
            sb.append(Character.toUpperCase(str2.charAt(i+1)));
            if (isAlphabet(sb.toString())) list2.add(sb.toString());
        }
        
        // 교집합, 합집합
        for (int i=0; i<list1.size(); i++) {
            String s1 = list1.get(i);
            // list1에서 s1의 수를 구하고
            // list2에도 해당 원소의 수를 구함
            int count1 = Collections.frequency(list1, s1);
            int count2 = Collections.frequency(list2, s1);
            if (!intersection.contains(s1)) {
                for (int j=0; j<Math.min(count1, count2); j++) {
                    intersection.add(s1);
                }
            }
            if (!union.contains(s1)) {
                for (int j=0; j<Math.max(count1, count2); j++) {
                    union.add(s1);
                }
            }
        }
        // 교집합, 합집합
        for (int i=0; i<list2.size(); i++) {
            String s2 = list2.get(i);
            // list1에서 s1의 수를 구하고
            // list2에도 해당 원소의 수를 구함
            int count1 = Collections.frequency(list1, s2);
            int count2 = Collections.frequency(list2, s2);
            if (!intersection.contains(s2)) {
                for (int j=0; j<Math.min(count1, count2); j++) {
                    intersection.add(s2);
                }
            }
            if (!union.contains(s2)) {
                for (int j=0; j<Math.max(count1, count2); j++) {
                    union.add(s2);
                }
            }
        }

        int size1 = intersection.size();
        int size2 = union.size();
        if (size1 == 0 && size2 == 0) return 65536;
        double jacard = (double) size1 / size2;
        answer = (int) (jacard * 65536);
        
        return answer;
    }
}