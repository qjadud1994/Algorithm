#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int N, K, Max;
int mountain[9][9];
bool visit[9][9];
int dx[4] = { -1 ,1 ,0 ,0 };
int dy[4] = { 0,0,-1,1 };

void solution(int count, int row, int col, int pre, bool cut) {
	visit[row][col] = true;
	if (Max < count) Max = count;
	int i, x, y;
	for (i = 0; i < 4; i++) {
		x = row + dx[i]; y = col + dy[i];
		if (visit[x][y]) continue;
		if (x >= 0 && y >= 0 && x < N && y < N) {
			if (!cut) {
				if (!cut && mountain[row][col] > mountain[x][y]) {
					solution(count + 1, x, y, 0, cut);	// 통과 가능
				}
				else if (mountain[row][col] > mountain[x][y] - K) {
					solution(count + 1, x, y, mountain[row][col] - 1, true);	// 깎기
				}
			}
			else if (pre > mountain[x][y]) {
				solution(count + 1, x, y, mountain[x][y], cut);	// 통과 가능
			}
		}
	}
	visit[row][col] = false;
}

int main()
{
	int T;
	scanf("%d", &T);

	int t, i, j, max;
	for (t = 1; t <= T; t++) {
		max = -1;
		Max = -1;
		scanf("%d %d", &N, &K);

		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				visit[i][j] = false;
				scanf("%d", &mountain[i][j]);
				if (mountain[i][j] > max) max = mountain[i][j];
			}
		}
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				if (mountain[i][j] == max) {
					visit[i][j] = true;
					solution(1, i, j, 20, false);
					visit[i][j] = false;
				}
			}
		}
		printf("#%d %d\n", t, Max);
	}
}