#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int k, vector<vector<int>> dungeons) {
    int max = 0;
    int count = 0;
    int current_k = k;
    int len = dungeons.size();
    vector<int> vec;
    for (int i=0; i<len; i++) vec.push_back(i);
    // 브루트포스 시작
    do {
        count = 0;
        current_k = k;
        // 여기서 순서 정해서 피로도 계산
        for (auto it = vec.begin(); it != vec.end(); it++) {
            int index = *it;
            // 최소 피로도보다 많아야 입장
            if (current_k >= dungeons[index][0]) {
                count++; // 입장한 던전 추가
                current_k -= dungeons[index][1]; // 피로도 사용
            } else {
                if (max <= count) max = count;
            }
        }
        if (count == len) return len;
    } while (next_permutation(vec.begin(), vec.end()));
    
    
    
    
    return max;
}