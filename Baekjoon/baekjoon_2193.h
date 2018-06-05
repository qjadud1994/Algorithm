#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;

	long long *table = new long long[n + 1];
	table[1] = 1;
	table[2] = 1;

	for (int i = 3; i <= n; i++) {
		table[i] = table[i - 1] + table[i - 2];
	}
	cout << table[n];

	return 0;
}

/*
int main(void) {
int n, i;
scanf("%d", &n);

long long DP[91][2];

DP[1][0] = 1; DP[1][1] = 1;
for (i = 2; i <= n; i++) {
DP[i][1] = DP[i - 1][0];
DP[i][0] = DP[i - 1][1] + DP[i-1][0];
}

printf("%lld", DP[n][1]);
return 0;
}
*/