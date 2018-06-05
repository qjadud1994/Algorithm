#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

int main(void) {
	int n, k, i;
	scanf("%d", &n);
	scanf("%d", &k);

	int coin[11];
	for (i = 0; i < n; i++) {
		scanf("%d", &coin[i]);
	}

	int result = 0;
	for (i = n - 1; i >= 0 && k != 0; i--) {
		if (coin[i] <= k) {
			result += (k / coin[i]);
			k = k % coin[i];
		}
	}
	printf("%d", result);
	return 0;
}
