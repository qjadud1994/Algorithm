#include <iostream>
using namespace std;

int main() {
	int N, temp;
	cin >> N;
	int result = 0;
	for (int i = 0; i < N - 1; i++) {
		cin >> temp;
		result += temp - 1;
	}
	cin >> temp;
	result += temp;
	cout << result;
}