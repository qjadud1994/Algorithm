#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

int main(void) {
	int n, i, temp;

	long long P[101];
	P[0] = 0;
	P[1] = P[2] = P[3] = 1;
	P[4] = P[5] = 2;
	P[6] = 3; P[7] = 4; P[8] = 5;

	for (i = 9; i <= 100; i++) {
		P[i] = P[i - 1] + P[i - 5];
	}

	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &temp);
		printf("%lld\n", P[temp]);
	}

	return 0;
}
