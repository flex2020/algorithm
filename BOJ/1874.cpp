#include <bits/stdc++.h>

using namespace std;

int N;
int numbers[100000];
stack<int> s;
stack<int> temp;
vector<string> ans;
vector<int> sequence;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> numbers[i];
	}
	for (int i = N; i >= 1; i--) {
		temp.push(i);
	}
	int max = 0;
	for (int i = 0; i < N; i++) {
		if (numbers[i] > max) {
			max = numbers[i];
			while (!temp.empty() && temp.top() <= max) {
				s.push(temp.top());
				temp.pop();
				ans.push_back("+");
			}
		}
		if (max >= numbers[i]) {
			while (!s.empty() && s.top() >= numbers[i]) {
				sequence.push_back(s.top());
				s.pop();
				ans.push_back("-");
			}
		}
	
	}
	
	for (int i = 0; i < N; i++) {
		if (sequence[i] != numbers[i]) {
			cout << "NO";
			return 0;
		}
	}
	for (auto it : ans) cout << it << "\n";
	return 0;
}