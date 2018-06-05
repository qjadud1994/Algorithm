#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int gcd(int a, int b) {
	while (b != 0) {
		int temp = a % b;
		a = b;
		b = temp;
	}
	return a;
}

int main(void) {
	int A1, B1, A2, B2;
	scanf("%d %d %d %d", &A1, &B1, &A2, &B2);

	int A = A1*B2 + A2*B1;
	int B = B1*B2;
	int G = gcd(A, B);
	printf("%d %d", A / G, B / G);

	return 0;
}