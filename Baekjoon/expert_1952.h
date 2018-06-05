#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define Min(X,Y) ((X) > (Y) ? (Y) : (X))
//#include <iostream>
//using namespace std;

int ticket[4];	//day, month, 3-months, year
int month[13];
int cost[13];

int solution() {
	cost[0] = 0;
	cost[1] = Min(month[1] * ticket[0], ticket[1]);
	cost[2] = Min(month[2] * ticket[0], ticket[1]) + cost[1];

	int i;
	for (i = 3; i < 11; i++) {
		cost[i] = Min(Min(ticket[1], month[i] * ticket[0]) + cost[i - 1],
			ticket[2] + cost[i - 3]);
	}
	for (i = 11; i <= 12; i++) {
		cost[i] = Min(Min(Min(ticket[1], ticket[3]), month[i] * ticket[0]) + cost[i - 1],
			ticket[2] + cost[i - 3]);
	}

	return cost[12] > ticket[3] ? ticket[3] : cost[12];
}

int main() {
	int T, N, K;

	scanf("%d", &T);

	int t, i, j;
	for (t = 1; t <= T; t++) {
		scanf("%d %d %d %d", &ticket[0], &ticket[1], &ticket[2], &ticket[3]);
		for (j = 1; j <= 12; j++) scanf("%d", &month[j]);
		printf("#%d %d\n", t, solution());
	}

	return 0;
}