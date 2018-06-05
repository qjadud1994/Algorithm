#include <iostream>
using namespace std;

int Max(int a, int b) {
	return a > b ? a : b;
}

int main(void) {
	int n, m, i, j;
	cin >> n >> m;

	int **maze = new int*[n];
	for (i = 0; i < n; i++) maze[i] = new int[m];

	for (i = 0; i<n; i++) {
		for (j = 0; j<m; j++) {
			cin >> maze[i][j];
		}
	}

	for (i = 1; i<n; i++) {
		maze[i][0] += maze[i - 1][0];
	}
	for (i = 1; i<m; i++) {
		maze[0][i] += maze[0][i - 1];
	}
	for (i = 1; i<n; i++) {
		for (j = 1; j<m; j++) {
			maze[i][j] += Max(maze[i - 1][j], Max(maze[i][j - 1], maze[i - 1][j - 1]));
		}
	}
	cout << maze[n - 1][m - 1];

	return 0;
}
