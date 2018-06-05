#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

int main(void) {
	int n, j, i;
	scanf("%d", &n);

	int DP[1001][10];
	int sum = 0;
	for (j = 0; j < 10; j++) DP[1][j] = 1;
	for (i = 2; i <= n; i++) {
		sum = 0;
		for (j = 9; j >= 0; j--) {
			sum += DP[i - 1][j];
			DP[i][j] = sum % 10007;
		}
	}

	int result = 0;
	for (j = 0; j < 10; j++) {
		result += DP[n][j];
	}
	printf("%d", result % 10007);
	return 0;
}
