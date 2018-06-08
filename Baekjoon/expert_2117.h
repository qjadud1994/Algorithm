#include <iostream>
using std::cin;
using std::cout;

bool city[21][21];

int get_cost(int k) {               // ��� ���ϴ� �Լ�
	return k*k + (k - 1)*(k - 1);
}

int solution(int N, int M) {
	int K, i, j, c, b;
	int Max = -999999;
	int row, count, cost;

	for (K = 1; K <= N + 2; K++) {        // K�� ũ�⸦ 1���� ū ����ŭ
		cost = get_cost(K);
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {       // (i, j) = ������ �߰� ��ǥ
				count = 0;                      // ���񽺸� �޴� ���� ��
				row = i - K + 1;                // �������� �� �� ���� ��

				for (c = 0; c < K - 1; c++, row++) {    // ������ �� ������ �߰� ������ �۾�
					if (row < 0) continue;
					for (b = -c; b <= c; b++) {         // -1~1 3�� / -2~2 5�� / -3~3 7�� ...
						if (j + b >= 0 && j + b < N && city[row][j + b]) count++; //���� �޴� ���̸� count ����
					}
				}

				for (b = -K + 1; b <= K - 1; b++) {     // ������ �߰� row �۾�
					if (j + b >= 0 && j + b < N && city[i][j + b]) count++;
				}
				row++;          // �߰� ������ �̵�

				for (c = K - 2; c >= 0; c--, row++) {   // ������ �߰� �غ��� �� �Ʒ����� �۾�
					if (row >= N) continue;
					for (b = -c; b <= c; b++) {         // -3~3 7�� / -2~2 5�� / -1~1 3��
						if (j + b >= 0 && j + b < N && city[row][j + b]) count++; //���� �޴� ���̸� count ����
					}
				}

				if (M * count - cost >= 0 && Max < count) Max = count;    //���� ���� ���� ��, Max�� ������Ʈ
			}
		}
	}
	return Max;
}

int main()
{
	std::ios::sync_with_stdio(false);
	int T, N, M;
	cin >> T;

	int t, i, j, max;
	for (t = 1; t <= T; t++) {
		cin >> N >> M;
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) cin >> city[i][j];
		}

		cout << "#" << t << " " << solution(N, M) << "\n";
	}
}