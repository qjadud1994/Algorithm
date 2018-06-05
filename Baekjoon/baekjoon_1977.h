#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int M, N;
	cin >> M; cin >> N;

	int start = ceil(sqrt(M)), end = sqrt(N);
	long long result = 0;
	for (int i = start; i <= end; i++) {
		result += pow(i, 2);
	}
	if (result == 0) cout << -1;
	else cout << result << endl << pow(start, 2);
}