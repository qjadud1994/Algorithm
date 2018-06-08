#include <stdio.h>

int D, W, K;
short film[14][21];					// 고정 film 배열
short film_val[14][21];				// 비교를 위해 변하는 film 배열
bool end;

void change_line(int d, short flag) {		// 어떤 line의 원소를 모두 flag(0 or 1)로 바꾸는 함수
	int j;
	for (j = 0; j < W; j++) film_val[d][j] = flag;
}

void reset_line(int d) {					// 어떤 line의 원소를 원래대로 복구하는 함수
	int j;
	for (j = 0; j < W; j++) film_val[d][j] = film[d][j];
}

bool is_possible() {						// 현재 film_val 이 조건을 만족하는지 확인
	int i, j, count;
	for (j = 0; j < W; j++) {
		count = 1;							// 현재 원소부터 count하므로 1부터 시작
		for (i = 1; i < D && count < K; i++) {					//연속되는 원소의 수(count)가 K 이상일 때 까지
			if (film_val[i][j] == film_val[i - 1][j]) count++;	//연속되면 count증가
			else count = 1;										//아니라면 count 처음부터
		}
		if (count != K) return false;		// count가 K가 아니라면 불연속이므로 불가능한 배열 -> return false
	}
	return true;
}

void recursive(int k, int count, int start) {	// k개 씩 모든 조합 고려하기 위한 재귀 함수
	if (end) return;							// 만족하는 조합을 찾았으면 끝낸다
	if (count == k) {							// k개의 조합이 갖춰졌으면
		if (is_possible()) end = true;			// 해당 조합이 조건을 만족하는지 확인
		return;
	}
	for (int i = start; i < D; i++) {
		change_line(i, 0);						//해당 line을 모두 0 (A)으로 바꾸기
		recursive(k, count + 1, i + 1);			//다음 조합 탐색
		reset_line(i);							//탐색 후 line의 원소를 원래대로 복구

		change_line(i, 1);						//해당 line을 모두 1 (B)으로 바꾸기
		recursive(k, count + 1, i + 1);			//다음 조합 탐색
		reset_line(i);							//탐색 후 line의 원소를 원래대로 복구
	}
}

int main()
{
	int T;
	scanf("%d", &T);
	short check[14];

	int t, i, j, max;
	for (t = 1; t <= T; t++) {
		scanf("%d %d %d", &D, &W, &K);
		for (i = 0; i < D; i++) {
			for (j = 0; j < W; j++) {
				scanf("%hd", &film[i][j]);
				film_val[i][j] = film[i][j];
			}
		}
		end = false;
		for (i = 0; i < D; i++) {		// k를 0부터 D까지 모두 확인
			recursive(i, 0, 0);
			if (end) {
				printf("#%d %d\n", t, i); break;	// 만족하면 종료
			}
		}
	}
}