#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;

	int *table = new int[n + 1];
	table[1] = 1;
	table[2] = 2;

	for (int i = 3; i <= n; i++) {
		table[i] = (table[i - 1] + table[i - 2]) % 10007;
	}
	cout << table[n];

	return 0;
}