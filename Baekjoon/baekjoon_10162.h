#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int T;
	scanf("%d", &T);

	int A, B, C;
	A = T / 300;
	T = T - A * 300;
	B = T / 60;
	T = T - B * 60;
	C = T / 10;
	T = T - C * 10;

	if (T == 0) printf("%d %d %d", A, B, C);
	else printf("-1");

	return 0;
}