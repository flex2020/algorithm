#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
int dy[] = { 0,0,-1,1 };
int dx[] = { 1,-1,0,0 };
bool arr[501][501];
bool visited[501][501];
int area = 1;
int cnt = 0;
vector<int> v;

void DFS(int y, int x) {
	visited[y][x] = true;

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny<0 || nx<0 || ny>N || nx>M)
			continue;
		if (arr[ny][nx] && !visited[ny][nx]) {
			visited[ny][nx] = true;
			area++;
			DFS(ny, nx);
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;

	for (int i = 0; i < 501; i++) {
		for (int j = 0; j < 501; j++) {
			arr[i][j] = false;
			visited[i][j] = false;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (arr[i][j] && !visited[i][j]) {
				DFS(i, j);
				v.push_back(area);
				area = 1;
				cnt++;
			}
		}
	}
	if (!v.empty()) {
		sort(v.begin(), v.end());
		cout << cnt << " " << v.back() << endl;
	}
	else cout << cnt << " " << 0 << endl;
	return 0;
}