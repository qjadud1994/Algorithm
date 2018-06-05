#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int N;
int A[101];
int max = -1000000000;
int min = 1000000001;

void solution(int n, int plus, int minus, int mul, int div, int result) {
	if (n >= N - 1) {
		if (result > max) max = result;
		if (result < min) min = result;
		return;
	}
	if (plus > 0) solution(n + 1, plus - 1, minus, mul, div, result + A[n + 1]);
	if (minus > 0) solution(n + 1, plus, minus - 1, mul, div, result - A[n + 1]);
	if (mul > 0) solution(n + 1, plus, minus, mul - 1, div, result * A[n + 1]);
	if (div > 0) solution(n + 1, plus, minus, mul, div - 1, result / A[n + 1]);
}

int main(void) {
	scanf("%d", &N);
	for (int i = 0; i < N; i++) scanf("%d", &A[i]);

	int plus, minus, mul, div;
	scanf("%d %d %d %d", &plus, &minus, &mul, &div);

	solution(0, plus, minus, mul, div, A[0]);
	printf("%d\n%d", max, min);

	return 0;
}