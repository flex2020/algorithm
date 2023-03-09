#include <bits/stdc++.h>

using namespace std;


int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  while(true) {
    string a;
    getline(cin, a);
    if(a == ".") break;
    stack<char> s;
    bool isValid = true;
    for (auto c : a) {
      // 여는 괄호는 스택에 삽입
      if (c == '(' || c == '[') s.push(c);
      // 닫는 괄호는 짝이 없다면 잘못된것.
      else if (c == ')') {
        if(s.empty() || s.top() != '(') {
          isValid = false;
          break;
        }
        // 짝이 맞다면 삭제
        s.pop();
      }
      else if (c == ']') {
        if (s.empty() || s.top() != '[') {
          isValid = false;
          break;
        }
        s.pop();
      }
    }
    if (!s.empty()) isValid = false;
    string answer = (isValid) ? "yes\n" : "no\n";
    cout << answer;
  }



  return 0; 
}