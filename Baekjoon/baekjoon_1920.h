#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <algorithm>
using namespace std;

int arr[100001];

int Binary_search(int left, int right, int data) {		//Àç±Í
	int mid = (left + right) / 2;

	if (left > right) return 0;
	if (data == arr[mid]) return 1;
	if (data > arr[mid]) return Binary_search(mid + 1, right, data);
	if (data < arr[mid]) return Binary_search(left, mid - 1, data);
}

int Solution(int n, int key) {		// while
	int start = 0;
	int end = n - 1;
	int mid;

	while (end - start >= 0) {
		mid = (start + end) / 2;

		if (arr[mid] == key) return 1;
		else if (arr[mid] > key) end = mid - 1;
		else start = mid + 1;
	}
	return 0;
}

int main(void) {
	int N, M, temp;

	scanf("%d", &N);

	for (int i = 0; i<N; i++) scanf("%d", &arr[i]);

	sort(arr, arr + N);

	scanf("%d", &M);
	for (int i = 0; i < M; i++) {
		scanf("%d", &temp);
		printf("%d\n", Solution(N, temp));
		//printf("%d\n", Binary_search(0, N, temp));
	}
	return 0;
}
