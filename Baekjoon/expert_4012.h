#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
using namespace std;

int N, Min;
short food[17][17];

void solution(bool check[]) {
	int sum_A = 0, sum_B = 0;
	vector<int> A, B;
	for (int i = 0; i < N; i++) {
		if (check[i]) A.push_back(i);
		else B.push_back(i);
	}
	for (int i = 0; i < A.size(); i++) {
		for (int j = i; j < A.size(); j++) {
			sum_A += food[A[i]][A[j]] + food[A[j]][A[i]];
			sum_B += food[B[i]][B[j]] + food[B[j]][B[i]];
		}
	}
	int result = sum_A > sum_B ? sum_A - sum_B : sum_B - sum_A;
	if (Min > result) Min = result;
}

void recursive(int level, int start, bool check[]) {
	if (level == N / 2) {
		solution(check);
		return;
	}
	for (int i = start; i < N; i++) {
		if (!check[i]) {
			check[i] = true;
			recursive(level + 1, i, check);
			check[i] = false;
		}
	}
}

int main() {
	int T;
	int t, i, j;
	bool check[17];
	scanf("%d", &T);

	for (t = 1; t <= T; t++) {
		Min = 99999999;
		scanf("%d", &N);

		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) scanf("%hd", &food[i][j]);
			check[i] = false;
		}
		recursive(0, 0, check);
		printf("#%d %d\n", t, Min);
	}
}