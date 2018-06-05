#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

//   1  2   3   4   5    6   7  8   9  10   11   12
int month[13] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
char *day[7] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

int main(void) {
	int x, y, i;

	scanf("%d", &x);
	scanf("%d", &y);

	int days = 0;
	for (i = 1; i < x; i++) days += month[x - i];
	days += y;
	printf("%s\n", day[days % 7]);

	return 0;
}
