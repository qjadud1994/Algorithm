#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>
#include <math.h>
int min(int a, int b) {
	if (a > b) return b;
	return a;
}

int main() {
	char room_number[20];
	scanf("%s", room_number);

	int num[10];
	for (int i = 0; i < 10; i++) num[i] = 0;

	int count = 0;
	for (int i = 0; i < strlen(room_number); i++) {
		num[room_number[i] - 48]++;
	}
	int max = num[0];
	for (int i = 1; i < 10; i++) {
		if (i == 6 || i == 9) continue;
		if (num[i] > max) max = num[i];
	}
	int overlap = 0;
	if (num[6] > num[9]) overlap = min(num[6], num[9]) + ceil(((double)num[6] - (double)num[9]) / 2);
	else overlap = min(num[6], num[9]) + ceil(((double)num[9] - (double)num[6]) / 2);

	if (max > overlap) printf("%d", max);
	else printf("%d", overlap);
}