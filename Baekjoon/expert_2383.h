#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <algorithm>
#include <vector>
using namespace std;

int min_time;
int room[10][10];
int N;
vector<pair<int, int>> point;
vector<pair<int, int>> entrance;

int get_distance(int p, char flag) {		// �Ա��� � �� ������ �Ÿ� ���ϴ� �Լ�
	if (flag == 'A') return abs(entrance[0].first - point[p].first) + abs(entrance[0].second - point[p].second);
	return abs(entrance[1].first - point[p].first) + abs(entrance[1].second - point[p].second);
}

void get_time(bool check[]) {				// � ���տ��� �ҿ�Ǵ� �ð� ���ϴ� �Լ�
											// check �迭���� true�� A�� �̿��ϴ� ���, false�� B�� �̿��ϴ� ���
	int time_A = room[entrance[0].first][entrance[0].second];	// �Ա� A�� ��� ����
	int time_B = room[entrance[1].first][entrance[1].second];	// �Ա� B�� ��� ����

	vector<int> entrance1, entrance2;		// �Ա� A, B�� ����ϴ� ������� �Ÿ��� �����ϴ� ����
	for (int i = 0; i < N; i++) {			// check �迭�� ���� �Ա� A, B�� ������� ����
		if (check[i]) entrance1.push_back(get_distance(i, 'A') + time_A + 1);	// �Ÿ� ���� + ��� ���� + �Ա� ���� �ð�(1) 
		else entrance2.push_back(get_distance(i, 'B') + time_B + 1);
	}

	sort(entrance1.begin(), entrance1.end());		// ���� �ð� ������� ����
	sort(entrance2.begin(), entrance2.end());

	int result_A = 0, result_B = 0;					// A, B ����� ����ϴµ� �ɸ��� �ð�
	int count = 0;									// �ִ� ��� �ο��� 3���� üũ�ϴ� ����

	for (int i = 0; i < entrance1.size(); i++) {	// �Ա� A�� ���, ��� ����鿡 ���� 
		while (entrance1[i] != 0) {					// i° ����� �� ������ �� ����
			for (int j = 0; i + j < entrance1.size(); j++) {		//i��° ������ ��� ����� ���� 
				if (j >= 3 && entrance1[i + j] == time_A) continue;	//3�� �̻��� ����� �̿� ���ε�, i+j��° ����� ��� �Ա��� �������� �� -> ��� (continue)
				entrance1[i + j]--;									//�Ÿ��� 1�� ����
			}
			result_A++;								// �ð� 1 ���
		}
	}

	for (int i = 0; i < entrance2.size(); i++) {	// �Ա� B�� ��� A�� ���� �۾�
		while (entrance2[i] != 0) {
			for (int j = 0; i + j < entrance2.size(); j++) {
				if (j >= 3 && entrance2[i + j] == time_B) continue;
				entrance2[i + j]--;
			}
			result_B++;
		}
		if (entrance2[i] != 0 && count != time_B) result_B--;
	}

	int result = result_A < result_B ? result_B : result_A;		// A�� B �� �� ���� �ɸ� �ð��� �̹� case�� ��
	if (min_time > result) min_time = result;					// �ּ� �ð� ������Ʈ
}

void solution(int count, int start, bool check[]) {		// ��� ����� �� ����ϱ�
	if (count == N) {			// ��� ����� �� ����ߴٸ�
		get_time(check);		// �� ������ �ð��� ���ϱ�
		return;
	}
	for (int i = start; i < N; i++) {
		check[i] = true;
		solution(count + 1, i + 1, check);	// i��° ����� true(A ���) �� ��
		check[i] = false;
		solution(count + 1, i + 1, check);	// i��° ����� false(B ���) �� ��
	}
}

int main() {
	int T;
	int t, i, j;

	scanf("%d", &T);
	bool check[101];
	for (t = 1; t <= T; t++) {
		point.clear();
		entrance.clear();
		min_time = 99999999;

		scanf("%d", &N);
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				scanf("%d", &room[i][j]);
				if (room[i][j] == 1) point.push_back(make_pair(i, j));			// ����� vector�� ����
				else if (room[i][j] != 0) entrance.push_back(make_pair(i, j));	// �Ա��� vector�� ����
			}
		}
		N = point.size();			// ����� �� = N
		solution(0, 0, check);

		printf("#%d %d\n", t, min_time);
	}
}