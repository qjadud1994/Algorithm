#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

int main(void) {
	int n, j, i;
	scanf("%d", &n);

	int arr[1001];
	int DP[1001];
	for (i = 1; i <= n; i++) scanf("%d", &arr[i]);

	int max = 0;
	DP[0] = 0;
	for (i = 1; i <= n; i++) {
		max = 0;
		for (j = 1; j <= i; j++) {
			if (DP[i - j] + arr[j] >= max) max = DP[i - j] + arr[j];
		}
		DP[i] = max;
	}
	printf("%d\n", DP[n]);

	return 0;
}
