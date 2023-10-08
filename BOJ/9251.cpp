#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int DP[1000][1000];
string x = "", y = "";

int LCS(int x_index, int y_index) {
  if(x_index == -1 || y_index == -1) return 0;
  if(DP[x_index][y_index] != -1) return DP[x_index][y_index];

  if(x[x_index] == y[y_index]) {
    DP[x_index][y_index] = LCS(x_index - 1, y_index - 1) + 1;
    return DP[x_index][y_index];
  }


  DP[x_index][y_index] = max(LCS(x_index - 1, y_index), LCS(x_index, y_index - 1));
  return DP[x_index][y_index];
}

void init() {
  for(int i=0; i<1000; i++) {
    for(int j=0; j<1000; j++) DP[i][j] = -1;
  }
}


int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  cin >> x >> y;

  init();
  cout << LCS(x.length() - 1, y.length() - 1);


  return 0;
}