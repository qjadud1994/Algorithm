#include <iostream>
using namespace std;

int N, M;
char table[50][50];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };

bool check_2(int r, int c, int d) {
	int R, C;
	for (int i = 0; i < 4; i++) {
		R = r + dx[i]; C = c + dy[i];
		if (R >= 0 && C >= 0 && R < N && C < M) {
			if (table[R][C] == '0') return false;
		}
	}
	return true;
}

int main() {
	int i, j;
	cin >> N >> M;

	int r, c, d;
	cin >> r >> c >> d;

	for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			cin >> table[i][j];
		}
	}
	table[r][c] = '2';
	int result = 1;
	int R, C;
	while (true) {
		if (check_2(r, c, d)) {
			if (table[r - dx[d]][c - dy[d]] != '1') {
				r = r - dx[d];
				c = c - dy[d];
			}
			else break;
		}
		for (i = 0; i < 4; i++) {
			d--;
			if (d < 0) d += 4;
			R = r + dx[d]; C = c + dy[d];
			if (table[R][C] == '0') {		//2_1
				table[R][C] = '2';
				r = R; c = C;
				result++;
				break;
			}
			if (C == -1 || table[R][C] == '1') continue;
			if (R >= 0 && C >= 0 && R < N && C < M) {
				if (table[R][C] != '2' && table[R][C] != '1') return false;
			}
		}
	}
	cout << result << endl;
	return 0;
}