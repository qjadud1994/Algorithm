// [모의 SW 역량테스트] 등산로 조성
#include<iostream>
#include<memory.h>

using::std::scanf;
using::std::printf;

int map[8][8];
bool visit[8][8];
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
int N, K;
int ans;

void dfs(int x, int y, int dist, int cnt) {
	if (ans < dist)
		ans = dist;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && visit[nx][ny] == false) {
			if (map[nx][ny] < map[x][y]) {
				visit[nx][ny] = true;
				dfs(nx, ny, dist + 1, cnt);
				visit[nx][ny] = false;
			}
			else {
				if (cnt == 0 && (map[nx][ny] - K < map[x][y])) {
					visit[nx][ny] = true;
					int num = map[nx][ny];
					map[nx][ny] = map[x][y] - 1;
					dfs(nx, ny, dist + 1, cnt + 1);
					map[nx][ny] = num;
					visit[nx][ny] = false;
				}
			}
		}
	}
	return;
}

int main() {
	int t;
	scanf("%d", &t);

	for (int T = 1; T <= t; T++) {
		memset(map, 0, sizeof(map));
		memset(visit, false, sizeof(visit));

		scanf("%d", &N);
		scanf("%d", &K);

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				scanf("%d", &map[i][j]);

				if (map[i][j]>max)
					max = map[i][j];
			}
		}

		ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == max) {
					visit[i][j] = true;
					dfs(i, j, 1, 0);
					visit[i][j] = false;
				}
			}
		}

		printf("#%d %d\n", T, ans);
	}

	return 0;
}