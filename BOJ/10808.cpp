#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string s;
int answer[26] = {0,};

int main() {
  cin >> s;

  for(auto it : s) {
    int cur = it - 97;
    answer[cur]++;
  }

  for(auto it : answer) cout << it << " ";

  return 0;
}