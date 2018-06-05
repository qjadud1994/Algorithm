#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
	char str[101];
	while (fgets(str, 100, stdin) != NULL) {
		printf("%s", str);
	}

	return 0;
}