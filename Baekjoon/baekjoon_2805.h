//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>

#include <iostream>
using namespace std;

int main(void) {
	int N, i;
	cin >> N;
	long long M;
	cin >> M;

	long long *arr = new long long[N];
	long long max = 0;
	for (i = 0; i < N; i++) {
		cin >> arr[i];
		if (arr[i] > max) max = arr[i];
	}

	long long result = 0, mid, total;
	long long left = 0, right = max;

	while (left <= right) {
		total = 0;
		mid = (right + left) / 2;
		for (i = 0; i < N; i++) {
			if (mid < arr[i]) total += (arr[i] - mid);
		}

		if (total >= M) {
			if (result < mid) result = mid;
			left = mid + 1;
		}
		else right = mid - 1;
	}

	cout << result;
	return 0;
}
