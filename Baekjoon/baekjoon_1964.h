#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	long long N;
	scanf("%lld", &N);

	long long result = 0;
	result += ((5 * N + 5) * N) / 2;
	result -= ((2 * N + 2) * (N - 1)) / 2;
	printf("%lld\n", result % 45678);
	return 0;
}