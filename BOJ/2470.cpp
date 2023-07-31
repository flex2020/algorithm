#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int ans1, ans2;
    int min = 10e9 + 1;
    int m2 = 0;
    int N;
    vector<int> v;

    cin >> N;
    for (int i = 0; i < N; i++) {
        int n;
        cin >> n;
        v.push_back(n);
    }
    sort(v.begin(), v.end());

    int start = 0, end = N - 1;

    while (true) {
        if (start >= end) break;
        if (v[start] + v[end] == 0) {
            cout << v[start] << " " << v[end];
            return 0;
        }
        else if (abs(v[start] + v[end]) < min) {
            min = abs(v[start] + v[end]);
            ans1 = start;
            ans2 = end;
        }
        if (v[start] + v[end] < 0) {
            start++;
        }
        else if (v[start] + v[end] > 0) {
            end--;
        }
    }

    cout << v[ans1] << " " << v[ans2];
    
    return 0;
}

