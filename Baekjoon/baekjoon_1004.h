#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int is_in(int a, int b, int r) {
	if (a*a + b*b < r*r) return 1;
	return 0;
}

int main(void) {
	int test_case;
	int x1, y1, x2, y2, n, result, cx, cy, r;

	scanf("%d", &test_case);
	for (int i = 0; i < test_case; i++) {
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
		scanf("%d", &n);
		result = 0;
		for (int j = 0; j < n; j++) {
			scanf("%d %d %d", &cx, &cy, &r);
			if (is_in(x1 - cx, y1 - cy, r) == 1 && is_in(x2 - cx, y2 - cy, r) == 1) continue;
			if (is_in(x1 - cx, y1 - cy, r) == 1 || is_in(x2 - cx, y2 - cy, r) == 1) result++;
		}
		printf("%d\n", result);
	}

	return 0;
}
