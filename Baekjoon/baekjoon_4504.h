#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int n, temp;
	scanf("%d", &n);

	while (true) {
		scanf("%d", &temp);
		if (temp == 0) break;
		if (temp % n == 0) printf("%d is a multiple of %d.\n", temp, n);
		else printf("%d is NOT a multiple of %d.\n", temp, n);
	}

	return 0;
}