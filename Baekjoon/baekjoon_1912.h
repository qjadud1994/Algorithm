#include <iostream>
using namespace std;

int main() {
	int num;
	cin >> num;

	int *arr = new int[num];
	for (int i = 0; i < num; i++) cin >> arr[i];

	int max = arr[0];
	for (int i = 1; i < num; i++) {
		if (arr[i - 1] > 0) {
			if (arr[i - 1] + arr[i] > 0) {
				arr[i] += arr[i - 1];
			}
		}
		if (arr[i] > max) max = arr[i];
	}
	cout << max;
}

/*
#include <stdio.h>

int main(void) {
	int n;
	scanf("%d", &n);

	int arr[100001];
	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

	int DP[100001];
	DP[0] = arr[0];

	int result = DP[0];
	for (int i = 1; i < n; i++) {
		if (DP[i - 1] < 0) {
			DP[i] = arr[i];
		}
		else DP[i] = DP[i - 1] + arr[i];
		if (DP[i] > result) result = DP[i];
	}

	printf("%d", result);
	return 0;
}

*/