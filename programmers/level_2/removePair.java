import java.util.*;
class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1) return 0;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            if (!stack.empty()) {
                Character top = stack.peek();
                if (top == s.charAt(i)) stack.pop();
                else stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty() ? 1 : 0;
    }
}