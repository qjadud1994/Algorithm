#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int A, i, j;
	int arr[1001];
	int DP[1001];
	int result = 0, max = 0;
	scanf("%d", &A);
	for (i = 0; i < A; i++) {
		scanf("%d", &arr[i]);
	}

	for (i = 0; i < A; i++) {
		max = 0;
		for (j = 0; j < i; j++) {
			if (arr[i] > arr[j] && DP[j] >= max) {
				max = DP[j];
			}
		}
		DP[i] = max + 1;
		if (DP[i] > result) result = DP[i];
	}
	printf("%d\n", result);
	return 0;
}

/*
6
10 20 10 30 20 50
*/