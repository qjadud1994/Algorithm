#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;
int Min(int a, int b) {
	if (a > b) return b;
	return a;
}

int main(void) {
	int n;
	scanf("%d", &n);

	int DP[1001][3];
	for (int i = 0; i < n; i++) {
		scanf("%d", &DP[i][0]);
		scanf("%d", &DP[i][1]);
		scanf("%d", &DP[i][2]);
	}

	for (int i = 1; i < n; i++) {
		DP[i][0] = Min(DP[i - 1][1], DP[i - 1][2]) + DP[i][0];
		DP[i][1] = Min(DP[i - 1][0], DP[i - 1][2]) + DP[i][1];
		DP[i][2] = Min(DP[i - 1][0], DP[i - 1][1]) + DP[i][2];
	}

	printf("%d\n", Min(Min(DP[n - 1][0], DP[n - 1][1]), DP[n - 1][2]));


	return 0;
}
