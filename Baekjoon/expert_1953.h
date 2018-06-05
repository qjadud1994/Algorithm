#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <queue>
using namespace std;

int N, M;
int arr[51][51];
bool visit[51][51];

class ternel {
public:
	int x, y, count;
	ternel(int x1, int y1, int count1) : x(x1), y(y1), count(count1) { }
	ternel() : x(0), y(0), count(0) { }
};

void down(int x, int y, int count, queue<ternel> &s) {
	if (x < N - 1 && !visit[x + 1][y]) {
		if (arr[x + 1][y] == 2 || arr[x + 1][y] == 1 ||
			arr[x + 1][y] == 4 || arr[x + 1][y] == 7) s.push(ternel(x + 1, y, count + 1));
	}
}
void up(int x, int y, int count, queue<ternel> &s) {
	if (x > 0 && !visit[x - 1][y]) {
		if (arr[x - 1][y] == 2 || arr[x - 1][y] == 1 ||
			arr[x - 1][y] == 5 || arr[x - 1][y] == 6) s.push(ternel(x - 1, y, count + 1));
	}
}
void right(int x, int y, int count, queue<ternel> &s) {
	if (y < M - 1 && !visit[x][y + 1]) {
		if (arr[x][y + 1] == 3 || arr[x][y + 1] == 1 ||
			arr[x][y + 1] == 6 || arr[x][y + 1] == 7) s.push(ternel(x, y + 1, count + 1));
	}
}
void left(int x, int y, int count, queue<ternel> &s) {
	if (y > 0 && !visit[x][y - 1]) {
		if (arr[x][y - 1] == 3 || arr[x][y - 1] == 1 ||
			arr[x][y - 1] == 4 || arr[x][y - 1] == 5) s.push(ternel(x, y - 1, count + 1));
	}
}

int solution(int R, int C, int L) {
	int x, y, count;
	queue<ternel> s;
	ternel cur(R, C, 1);
	s.push(cur);

	int result = 0;
	while (!s.empty()) {
		cur = s.front(); s.pop();
		x = cur.x; y = cur.y; count = cur.count;
		if (count <= L && !visit[x][y]) {
			visit[x][y] = true;
			result++;
			if (count == L) continue;
			if (arr[x][y] == 1) {
				up(x, y, count, s);
				down(x, y, count, s);
				right(x, y, count, s);
				left(x, y, count, s);
			}
			else if (arr[x][y] == 2) {
				up(x, y, count, s);
				down(x, y, count, s);
			}
			else if (arr[x][y] == 3) {
				right(x, y, count, s);
				left(x, y, count, s);
			}
			else if (arr[x][y] == 4) {
				up(x, y, count, s);
				right(x, y, count, s);
			}
			else if (arr[x][y] == 5) {
				down(x, y, count, s);
				right(x, y, count, s);
			}
			else if (arr[x][y] == 6) {
				left(x, y, count, s);
				down(x, y, count, s);
			}
			else if (arr[x][y] == 7) {
				left(x, y, count, s);
				up(x, y, count, s);
			}
		}
	}
	return result;
}


int main() {
	int T, R, C, L;
	int t, i, j;

	scanf("%d", &T);

	for (t = 1; t <= T; t++) {
		scanf("%d %d %d %d %d", &N, &M, &R, &C, &L);
		for (i = 0; i < N; i++) {
			for (j = 0; j < M; j++) {
				scanf("%d", &arr[i][j]);
				visit[i][j] = false;
			}
		}
		printf("#%d %d\n", t, solution(R, C, L));
	}
}