#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int N;
    int answer = 0;
    vector<int> primes;

    cin >> N;

    // 1 ~ N 까지 소수 담기
    for (int i = 2; i <= N; i++) {
        bool flag = false;
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) primes.push_back(i);
    }

    int start = 0, end = 0;
    int size = primes.size();
    while (true) {
        if (start > end || end >= size) break;
        int sum = 0;
        // 소수들의 합과 N을 비교
        for (int i = start; i <= end; i++) {
            sum += primes[i];
        }
        if (sum == N) {
            answer++;
            start++;
        }
        // 소수들의 합이 N보다 작다면
        else if (sum < N) {
            end++;
        }
        // 소수 들의 합이 N보다 크다면
        else {
            start++;
        }
    }
    
    cout << answer;
    
    return 0;
}

