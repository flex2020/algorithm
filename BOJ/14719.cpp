#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;

int H, W;
vector<int> blocks;
int answer = 0;

int main() {
    cin >> H >> W;

    for (int i = 0; i < W; i++) {
        int n;
        cin >> n;
        blocks.push_back(n);
    }
    
    for (int i = 1; i < W - 1; i++) {
        int left = 0, right = 0;
        for (int j = 0; j < i; j++) {
            left = max(left, blocks[j]);
        }
        for (int j = i + 1; j < W; j++) {
            right = max(right, blocks[j]);
        }
        answer += max(0, min(left, right) - blocks[i]);
    }

    cout << answer;
    return 0;
}

