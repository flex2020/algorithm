#include <bits/stdc++.h>

using namespace std;

int T;

struct Document{
	int id;
	int priority;
};

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> T;
	for (int i = 0; i < T; i++) {
		int n, m;
		queue<Document> q;
		priority_queue<int> pq;
		cin >> n >> m;
		for (int j = 0; j < n; j++) {
			Document d;
			int p = 0;

			cin >> p;

			d.id = j;
			d.priority = p;

			q.push(d);

			pq.push(p);
		}
		int count = 0;
		while (!q.empty()) {
			int index = q.front().id;
			int p = q.front().priority;
			// 더 높은 우선순위가 존재하면 뒤로 옮김
			if (pq.top() > p) {
				q.push(q.front());
				q.pop();
			}
			// 더 높은 우선순위가 없다면 
			else {
				q.pop();
				pq.pop();
				count++;
				if (index == m) {
					cout << count << "\n";
					break;
				}
			}
		}
	}
	
	return 0;
}