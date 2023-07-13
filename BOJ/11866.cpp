#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, K;
queue<int> q;
vector<int> sequence;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> N >> K;
	
	for (int i = 1; i <= N; i++) {
		q.push(i);
	}
	
	int count = 1;
	while (!q.empty()) {
		if (count % K == 0) {
			sequence.push_back(q.front());
		}
		else {
			q.push(q.front());
		}
		q.pop();
		count++;

	}
	cout << "<";
	for (int i = 0; i < sequence.size(); i++) {
		if (i == sequence.size() - 1) {
			cout << sequence[i] << ">";
		}
		else cout << sequence[i] << ", ";
	}
	return 0;
}