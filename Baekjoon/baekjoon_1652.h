#include <iostream>
using namespace std;

int main() {
	int N, i, j;
	cin >> N;

	bool **room = new bool*[N];
	for (i = 0; i < N; i++) room[i] = new bool[N];

	char input[128];
	for (i = 0; i < N; i++) {
		cin >> input;
		for (j = 0; j < N; j++) {
			if (input[j] == 'X') room[i][j] = false;
			else room[i][j] = true;
		}
	}

	int count_row = 0, count_col = 0;
	int row = 0, col = 0;

	for (i = 0; i < N; i++) {
		count_row = 0;
		count_col = 0;
		for (j = 0; j < N; j++) {
			//row
			if (room[i][j] == true) count_row++;
			else if (room[i][j] == false && count_row >= 2) {
				count_row = 0; row++;
			}
			else count_row = 0;

			//col
			if (room[j][i] == true) count_col++;
			else if (room[j][i] == false && count_col >= 2) {
				count_col = 0; col++;
			}
			else count_col = 0;
		}
		if (count_row >= 2) row++;
		if (count_col >= 2) col++;
	}
	cout << row << " " << col;

	return 0;
}