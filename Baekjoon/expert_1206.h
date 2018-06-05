#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
//#include <iostream>
//#include <vector>
//#include <algorithm>
//using namespace std;
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y)) 

short building[1001];
int main(void) {
	short n, i, j;
	short cut, count;
	for (i = 0; i < 10; i++) {
		count = 0;
		scanf("%hd", &n);
		for (j = 0; j < n; j++) scanf("%hd", &building[j]);

		for (j = 2; j < n - 2; j++) {
			cut = MAX(MAX(building[j - 2], building[j - 1]), MAX(building[j + 1], building[j + 2]));
			if (building[j] - cut >= 0) count += (building[j] - cut);
		}
		printf("#%hd %hd\n", i + 1, count);
	}
	return 0;
}