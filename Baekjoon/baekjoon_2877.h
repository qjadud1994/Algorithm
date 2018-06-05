#include <vector>
#include <iostream>
using namespace std;

int main(void) {
	int n;
	cin >> n;
	vector<char> result;

	n += 1;
	while (n >= 1) {
		if (n % 2 == 0) result.push_back('4');
		else result.push_back('7');
		n = n / 2;
	}

	for (int i = result.size() - 2; i >= 0; i--) {
		cout << result[i];
	}

	return 0;
}