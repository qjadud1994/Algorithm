#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	int minus, plus;
	int cur = 0, max = 0;
	for (int i = 0; i < 4; i++) {
		scanf("%d", &minus);
		scanf("%d", &plus);
		cur += plus - minus;
		if (cur > max) max = cur;
	}
	printf("%d\n", max);

	return 0;
}
