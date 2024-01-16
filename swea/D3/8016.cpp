#include <iostream>

using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  unsigned long long left = 1, right = 1;
  int T;
  cin >> T;
  for (int i = 1; i <= T; i++) {
    unsigned long long F;
    cin >> F;
    if (F != 1) {
      unsigned long long temp = F * (F - 1);
      left = temp - F + 2;
      right = temp + F;
      left = 2 * left - 1;
      right = 2 * right - 1;
    }
    cout << "#" << i << " " << left << " " << right << "\n";
  }
  return 0;
}