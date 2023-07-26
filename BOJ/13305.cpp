#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N;
vector<int> dist, price;
long long answer = 0;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> N;

    for (int i = 0; i < N - 1; i++) {
        int d;
        cin >> d;
        dist.push_back(d);
    }
    for (int i = 0; i < N; i++) {
        int p;
        cin >> p;
        price.push_back(p);
    }
    int min = price[0];
    long long d = 0;
    for (int i = 0; i < price.size() - 1; i++) {
        if (min > price[i]) {
            answer += d * min;
            d = dist[i];
            min = price[i];
        } else {
            d += dist[i];
        }
    }
    answer += d * min;
    cout << answer;
    

    return 0;
}

