#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

short magnet[4][8];
short move[21][2];
short check[4];

void reset_check() {
	check[0] = check[1] = check[2] = check[3] = 0;
}

void forward_move(int index) {
	int i, temp;
	temp = magnet[index][7];
	for (i = 7; i > 0; i--) {
		magnet[index][i] = magnet[index][i - 1];
	}
	magnet[index][0] = temp;
}

void backward_move(int index) {
	int i, temp;
	temp = magnet[index][0];
	for (i = 0; i < 7; i++) {
		magnet[index][i] = magnet[index][i + 1];
	}
	magnet[index][7] = temp;
}

int main() {
	int T, K;
	int t, i, j, k, sum, score, count;

	scanf("%d", &T);

	for (t = 1; t <= T; t++) {
		scanf("%d", &K);

		for (i = 0; i < 4; i++) {
			for (j = 0; j < 8; j++) scanf("%d", &magnet[i][j]);
		}

		for (k = 0; k < K; k++) {
			scanf("%d %d", &move[k][0], &move[k][1]);
		}

		for (k = 0; k < K; k++) {
			i = move[k][0] - 1;
			reset_check();
			check[i] = move[k][1];

			for (j = i, count = check[i]; j < 3; j++, count *= -1) {	//현재에서 오른쪽 부분 확인
				if (magnet[j][2] != magnet[j + 1][6]) {					//반대 극이면
					if (count == 1) check[j + 1] = -1;
					else if (count == -1) check[j + 1] = 1;
				}
				else break;
			}
			for (j = i, count = check[i]; j >= 1; j--, count *= -1) {	//현재에서 왼쪽 부분 확인
				if (magnet[j][6] != magnet[j - 1][2]) {					//반대 극이면
					if (count == 1) check[j - 1] = -1;
					else if (count == -1) check[j - 1] = 1;
				}
				else break;
			}

			for (j = 0; j < 4; j++) {						//한번에 이동
				if (check[j] == 1) forward_move(j);
				else if (check[j] == -1) backward_move(j);
			}
		}
		for (j = 0, score = 1, sum = 0; j < 4; j++, score *= 2) {
			sum += magnet[j][0] * score;
		}
		printf("#%d %d\n", t, sum);
	}
}