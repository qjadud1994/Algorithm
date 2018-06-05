#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//#include <iostream>
#include <vector>
using namespace std;

int get_distance(pair<int, int> p1, pair<int, int> p2) {
	return (p1.first - p2.first)*(p1.first - p2.first) +
		(p1.second - p2.second) * (p1.second - p2.second);
}

int main(void) {
	int T, n;
	int t, i, j, x, y;
	vector<pair<int, int>> point;
	scanf("%d", &T);

	for (t = 0; t<T; t++) {
		scanf("%d", &n);
		for (i = 0; i < n; i++) {
			scanf("%d %d", &x, &y);
			point.push_back(make_pair(x, y));
		}

		int min = 99999999;
		bool visit[21];
		for (i = 0; i < 21; i++) visit[i] = false;
		int temp;
		visit[0] = true;
		vector<int> reg;

		for (i = 0; i < n; i++) {
			min = 99999999;
			for (j = 0; j < n; j++) {
				if (!visit[j] && min > get_distance(point[i], point[j])) {
					min = get_distance(point[i], point[j]);
					temp = j;
				}
			}
			reg.push_back(min);
			visit[temp] = true;
		}
		for (i = 0; i < reg.size(); i++) {
			printf("reg[%d] : %d\n", i, reg[i]);
		}
	}
	return 0;
}