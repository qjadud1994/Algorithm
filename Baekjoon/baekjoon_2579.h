#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

int Max(int a, int b) {
	if (a > b) return a;
	return b;
}

int main(void) {
	int n;
	scanf("%d", &n);

	int stair[301];
	int DP[301];
	for (int i = 1; i <= n; i++) scanf("%d", &stair[i]);

	DP[0] = 0;
	DP[1] = stair[1];
	DP[2] = stair[1] + stair[2];
	for (int i = 3; i <= n; i++) {
		DP[i] = Max(DP[i - 3] + stair[i - 1], DP[i - 2]) + stair[i];
	}

	printf("%d\n", DP[n]);
	return 0;
}
