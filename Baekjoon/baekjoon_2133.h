#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

int main(void) {
	int n, i;
	scanf("%d", &n);

	long long DP[31][8];
	for (i = 0; i < 7; i++) DP[0][i] = 0;
	DP[0][7] = 1;

	for (i = 1; i <= n; i++) {
		DP[i][0] = DP[i - 1][7];
		DP[i][1] = DP[i - 1][6];
		DP[i][2] = DP[i - 1][5];
		DP[i][3] = DP[i - 1][4] + DP[i - 1][7];
		DP[i][4] = DP[i - 1][3];
		DP[i][5] = DP[i - 1][2];
		DP[i][6] = DP[i - 1][1] + DP[i - 1][7];
		DP[i][7] = DP[i - 1][0] + DP[i - 1][3] + DP[i - 1][6];
	}

	printf("%lld", DP[n][7]);
	return 0;
}
