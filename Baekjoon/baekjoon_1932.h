#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int Max(int a, int b) {
	return (a > b) ? a : b;
}

int main(void) {
	int n;
	scanf("%d", &n);

	int table[501][501];

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			scanf("%d", &table[i][j]);
		}
	}

	for (int i = 2; i <= n; i++) {
		table[i][1] += table[i - 1][1];
		table[i][i] += table[i - 1][i - 1];
		for (int j = 2; j <= i - 1; j++) {
			table[i][j] += Max(table[i - 1][j - 1], table[i - 1][j]);
		}
	}

	long long result = 0;
	for (int j = 1; j <= n; j++) {
		result = Max(result, table[n][j]);
	}
	printf("%d", result);
	return 0;
}