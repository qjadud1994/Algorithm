#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int test_case;
	int k, n, i, j;

	scanf("%d", &test_case);
	int table[15][15];
	for (i = 1; i <= 14; i++) table[0][i] = i;
	for (j = 0; j <= 14; j++) table[j][1] = 1;

	for (i = 1; i <= 14; i++) {
		for (j = 2; j <= 14; j++) {
			table[i][j] = table[i][j - 1] + table[i - 1][j];
		}
	}
	for (i = 0; i < test_case; i++) {
		scanf("%d", &k);
		scanf("%d", &n);
		printf("%d\n", table[k][n]);
	}
	return 0;
}
