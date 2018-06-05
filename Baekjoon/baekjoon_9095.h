#include <iostream>
using namespace std;

int main() {
	int T, i;
	cin >> T;
	int *Case = new int[T];
	int max = 4;
	for (i = 0; i < T; i++) {
		cin >> Case[i];
		if (Case[i] > max) max = Case[i];
	}

	int *DP = new int[max+1];
	DP[1] = 1; DP[2] = 2; DP[3] = 4;
	for (i = 4; i <= max; i++) DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3];

	for (i = 0; i < T; i++) {
		cout << DP[Case[i]] << endl;
	}
	return 0;
}