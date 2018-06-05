#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;
int Max(int a, int b) {
	if (a > b) return a;
	return b;
}

int main(void) {
	int n, i;
	scanf("%d", &n);

	int P[10001];
	for (i = 0; i < n; i++) scanf("%d", &P[i]);

	int DP[10001];
	DP[0] = P[0];
	DP[1] = P[0] + P[1];

	for (i = 2; i < n; i++) {
		DP[i] = Max(DP[i - 2], DP[i - 3] + P[i - 1]) + P[i];
		DP[i] = Max(DP[i], DP[i - 1]);
	}

	printf("%d", DP[n - 1]);
	return 0;
}
