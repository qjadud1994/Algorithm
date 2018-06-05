#include <iostream>
using namespace std;

int Two_or_Five(int two_or_five, long long n, long long m) {
	long long i, count = 0;
	for (i = two_or_five; i <= n; i *= two_or_five) {
		count += n / i;
	}
	for (i = two_or_five; i <= n - m; i *= two_or_five) {
		count -= (n - m) / i;
	}
	for (i = two_or_five; i <= m; i *= two_or_five) {
		count -= m / i;
	}
	return count;
}

int main() {
	long long n, m;
	cin >> n >> m;

	int two = Two_or_Five(2, n, m);
	int five = Two_or_Five(5, n, m);
	cout << (two > five ? five : two);
}