#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

#define MAX 10000 + 1

using namespace std;

int N;
int input[MAX] = {0,};
int arr[MAX] = {0,};

int main() {

  int sum = 0;

  cin >> N;
  for(int i=0; i<N; i++) {
    cin >> input[i];
  }

  for(int i=0; i<N; i++) {
    cout << "현재 수: " << input[i] << endl;
    if(arr[100-input[i]]) {
      cout << "존재";
      return 0;
    }
    arr[input[i]] = 1;
  }

  return 0;
}