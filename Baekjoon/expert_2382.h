#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

typedef struct microbe {
	int row, col, num, direction;
}Microbe;

short check[101][101];
short check2[101][101];

int dx[] = { 0, -1,1,0,0 };	// up down left right
int dy[] = { 0, 0,0,-1,1 };	// up down left right
int opposite_direction[] = { 0, 2,1,4,3 };

void reset(int N) {
	int i, j;
	for (i = 0; i < N; i++) {
		for (j = 0; j < N; j++) check[i][j] = -1;
	}
}

int solution(Microbe *m, int N, int M, int K) {
	int i, j, row, col;

	for (j = 0; j < M; j++) {
		for (i = 0; i < K; i++) {			// move
			if (m[i].num == 0) continue;
			check[m[i].row][m[i].col] = -1;
			m[i].row += dx[m[i].direction];
			m[i].col += dy[m[i].direction];
		}
		for (i = 0; i < K; i++) {
			if (m[i].num == 0) continue;
			row = m[i].row; col = m[i].col;
			if (row == 0 || row == N - 1 || col == 0 || col == N - 1) {	//side check
				m[i].num /= 2;
				m[i].direction = opposite_direction[m[i].direction];
			}
			if (check[row][col] == -1) {
				check[row][col] = i; check2[row][col] = 0;
			}
			else {												//grouping
				if (m[i].num > m[check[row][col]].num) {
					check2[row][col] += m[check[row][col]].num;
					m[check[row][col]].num = 0;
					check[row][col] = i;
				}
				else {
					check2[row][col] += m[i].num;
					m[i].num = 0;
				}
			}
		}
		for (i = 0; i < K; i++) {
			if (m[i].num == 0) continue;
			m[i].num += check2[m[i].row][m[i].col];
		}

	}
	int result = 0;
	for (i = 0; i < K; i++) {
		result += m[i].num;
	}
	return result;
}

int main() {
	int T, N, M, K;
	int t, i;
	int row, col, n, d;

	scanf("%d", &T);

	for (t = 1; t <= T; t++) {
		scanf("%d %d %d", &N, &M, &K);
		Microbe *m = new Microbe[K]();
		reset(N);
		for (i = 0; i < K; i++) {
			scanf("%d %d %d %d", &row, &col, &n, &d);
			m[i].row = row; m[i].col = col;
			m[i].num = n; m[i].direction = d;
		}
		printf("#%d %d\n", t, solution(m, N, M, K));
	}
}