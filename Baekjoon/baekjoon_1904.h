#include <iostream>
using namespace std;

#include <iostream>
using namespace std;

int main() {
	int N;
	cin >> N;

	int a = 1, b = 2, c = 0;

	for (int i = 0; i < N - 2; i++) {
		c = (a + b) % 15746;
		a = b % 15746;
		b = c % 15746;
	}
	if (N == 1) cout << 1;
	else if (N == 2) cout << 2;
	else cout << c;

	return 0;
}

int main() {
	int N;
	cin >> N;

	int *pibo = new int[N + 1];

	pibo[1] = 1; pibo[2] = 2;
	for (int i = 3; i <= N; i++) {
		pibo[i] = pibo[i - 1] + pibo[i - 2];
		pibo[i] = pibo[i] % 15746;
	}
	cout << pibo[N];

	return 0;
}