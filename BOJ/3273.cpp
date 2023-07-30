#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    vector<int> v;
    int N, X;
    int answer = 0;

    cin >> N;
    for (int i = 0; i < N; i++) {
        int n;
        cin >> n;
        v.push_back(n);
    }
    sort(v.begin(), v.end());

    cin >> X;

    int p1 = 0, p2 = N-1;
    while (true) {
        if (p1 >= p2) break;
        if (v[p1] + v[p2] == X) {
            answer++;
            p1++;
            p2--;
        }
        else if (v[p1] + v[p2] < X) {
            p1++;
        }
        else if (v[p1] + v[p2] > X) {
            p2--;
        }
    }
    cout << answer;
    return 0;
}

