#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int N, S;
    int answer = 987654321;
    int a[100000 + 1];

    cin >> N >> S;
    int temp = 0;
    for (int i = 1; i <= N; i++) {
        cin >> a[i];
        temp += a[i];
    }

    if (temp < S) {
        cout << 0;
        return 0;
    }

    int p1 = 1, p2 = 1;
    int sum = a[1];
    while (p1 <= p2 && p2 <= N) {
        if (sum < S) {
            sum += a[++p2];
        }
        else {
            answer = min(answer, p2 - p1 + 1);
            sum -= a[p1++];
        }
    }
    
    cout << answer;

    return 0;
}

