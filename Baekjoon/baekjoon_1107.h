#include <iostream>
#include <cmath>
using namespace std;

//Brute force (무작정) 풀이!

bool button[10];

int Min(int a, int b) {
	if (a > b) return b;
	return a;
}

int get_len(int N) {
	int length = 0;
	if (N == 0) {
		if (button[0]) return 1;
		else return 0;
	}
	while (N > 0) {
		if (!button[N % 10]) return 0;
		length++;
		N = N / 10;
	}
	return length;
}

int main() {
	int N, M, temp, temp2;
	cin >> N >> M;
	for (int i = 0; i < 10; i++) button[i] = true;
	for (int i = 0; i < M; i++) {
		cin >> temp;
		button[temp] = false;
	}
	if (M == 10) {
		cout << abs(100 - N);
		return 0;
	}
	int up = N, down = N, result = 999900;
	int length;
	while (down >= 0 || up <= 999900) {
		length = get_len(down);
		if (down >= 0 && length > 0) {
			result = length + N - down;
			break;
		}
		length = get_len(up);
		if (up <= 999900 && length > 0) {
			result = length + up - N;
			break;
		}
		up++; down--;
	}
	cout << Min(result, abs(N - 100));

	return 0;
}