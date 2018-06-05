#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

int main(void) {
	int n, i, j;
	scanf("%d", &n);

	long long DP[101][11];
	DP[1][0] = 0;
	for (i = 1; i <= 9; i++) DP[1][i] = 1;

	for (i = 2; i <= n; i++) {
		DP[i][0] = DP[i - 1][1];
		DP[i][9] = DP[i - 1][8];
		for (j = 1; j <= 8; j++) {
			DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) % 1000000000;
		}
	}

	long long result = 0;
	for (int i = 0; i <= 9; i++) result += DP[n][i];

	printf("%lld\n", result % 1000000000);

	return 0;
}
