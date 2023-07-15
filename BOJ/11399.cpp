#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;

int main() {
    int N;
    int answer = 0;
    cin >> N;
    vector<int> v;

    for (int i = 0; i < N; i++) {
        int p;
        cin >> p;
        v.push_back(p);
    }
    sort(v.begin(), v.end());
    for (int i = 0; i < v.size(); i++) {
        for (int j = 0; j <= i; j++) {
            answer += v[j];
        }
    }
    cout << answer;

    return 0;
}

