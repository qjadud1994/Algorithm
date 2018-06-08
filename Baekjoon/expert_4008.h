#include <stdio.h>

int N, Min, Max;
short num[13];

void calculate(short check[]) {
	int i;
	int sum = num[0];
	for (i = 0; i < N - 1; i++) {
		if (check[i] == 0) sum += num[i + 1];
		else if (check[i] == 1) sum -= num[i + 1];
		else if (check[i] == 2) sum *= num[i + 1];
		else if (check[i] == 3) sum /= num[i + 1];
	}
	if (Min > sum) Min = sum;
	if (Max < sum) Max = sum;
}

void solution(int n, short check[], short Op[]) {
	if (n == N - 1) {
		calculate(check);
		return;
	}
	int i, j;
	for (j = 0; j < 4; j++) {
		if (Op[j] != 0) {
			Op[j]--;
			check[n] = j;
			solution(n + 1, check, Op);
			Op[j]++;
		}
	}
}

int main()
{
	int T;
	scanf("%d", &T);

	int t, i;
	short check[13];
	short Operator[4];
	for (t = 1; t <= T; t++) {
		scanf("%d", &N);
		for (i = 0; i < 4; i++) scanf("%hd", &Operator[i]);
		for (i = 0; i < N; i++) {
			scanf("%hd", &num[i]);
		}
		Min = 99999999;
		Max = -99999999;
		solution(0, check, Operator);
		printf("#%d %d\n", t, Max - Min);
	}
}