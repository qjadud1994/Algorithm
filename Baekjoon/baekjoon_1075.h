#include <iostream>
using namespace std;

int main() {
	long long N;				// 1021
	int F, result;				// 11
	cin >> N >> F;

	N = 100 * (N / 100);		//1021 -> 1000
	result = F - N%F;			// 11 - (1000%11 = 10) = 1
	if (N%F == 0) result = 0;

	if (result < 10) cout << 0 << result;
	else cout << result;

	return 0;
}