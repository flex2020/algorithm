#include <iostream>
#include <vector>

using namespace std;

int N, K;
int answer = 0;
vector<string> words;

// 읽을 수 있는 알파벳을 선택함.
void backTracking(int depth, int index, bool alphabet[]) {
    // 읽을 수 있는 알파벳을 모두 선택한 경우
    // 해당 알파벳들로 읽을 수 있는 단어의 수를 센다.
    if (depth == K) {
        int count = N;

        for (auto word : words) {
            for (auto c : word) {
                if (!alphabet[c - 97]) {
                    count--;
                    break;
                }
            }
        }

        answer = max(answer, count);
        return;
    }
    
    for (int i = index; i < 26; i++) {
        // i번째 알파벳을 읽을 수 있다고 선택
        if (!alphabet[i]) {
            alphabet[i] = true;
            backTracking(depth + 1, i + 1, alphabet);
            alphabet[i] = false;
        }

    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    bool alphabet[26] = {false,};

    cin >> N >> K;

    for (int i = 0; i < N; i++) {
        string word;
        cin >> word;
        words.push_back(word);
    }

    // K가 5보다 작으면 a, n, t, i, c를 배울 수 없기 때문에 0을 출력
    if (K < 5) {
        cout << 0;
        return 0;
    }

    // a, n, t, i, c 는 무조건 배워야함
    alphabet['a' - 97] = true;
    alphabet['n' - 97] = true;
    alphabet['t' - 97] = true;
    alphabet['i' - 97] = true;
    alphabet['c' - 97] = true;
    K -= 5; // 배울 수 있는 글자 수를 줄임

    for (int i = 0; i < 26; i++) {
        backTracking(0, i, alphabet);
    }

    cout << answer;

    return 0;
}

