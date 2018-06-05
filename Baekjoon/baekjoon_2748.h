#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

int main(void) {
	int n, i;

	scanf("%d", &n);

	long long pibo[91];
	pibo[0] = 0;
	pibo[1] = 1; pibo[2] = 1;
	for (i = 3; i <= n; i++) {
		pibo[i] = pibo[i - 1] + pibo[i - 2];
	}
	printf("%lld", pibo[n]);

	return 0;
}
