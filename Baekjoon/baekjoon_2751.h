#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
//using namespace std;

void quick(int arr[], int left, int right)
{
	int i = left, j = right;
	int p = arr[(left + right) / 2];
	int temp;
	do
	{
		while (arr[i] < p)
		{
			i++;
		}
		while (arr[j] > p)
		{
			j--;
		}
		if (i <= j)
		{
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	} while (i <= j);

	if (left < j)
		quick(arr, left, j);
	if (i < right)
		quick(arr, i, right);
}

int main(void) {
	int n, i;
	scanf("%d", &n);

	int arr[1000001];
	for (i = 0; i < n; i++) scanf("%d", &arr[i]);
	quick(arr, 0, n - 1);
	for (i = 0; i < n; i++) printf("%d\n", arr[i]);

	return 0;
}
