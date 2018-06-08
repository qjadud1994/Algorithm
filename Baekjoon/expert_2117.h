#include <iostream>
using std::cin;
using std::cout;

bool city[21][21];

int get_cost(int k) {               // 비용 구하는 함수
	return k*k + (k - 1)*(k - 1);
}

int solution(int N, int M) {
	int K, i, j, c, b;
	int Max = -999999;
	int row, count, cost;

	for (K = 1; K <= N + 2; K++) {        // K의 크기를 1부터 큰 수만큼
		cost = get_cost(K);
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {       // (i, j) = 마름도 중간 좌표
				count = 0;                      // 서비스를 받는 집의 수
				row = i - K + 1;                // 마름모의 맨 위 행의 값

				for (c = 0; c < K - 1; c++, row++) {    // 마름모 맨 위부터 중간 전까지 작업
					if (row < 0) continue;
					for (b = -c; b <= c; b++) {         // -1~1 3개 / -2~2 5개 / -3~3 7개 ...
						if (j + b >= 0 && j + b < N && city[row][j + b]) count++; //서비스 받는 집이면 count 증가
					}
				}

				for (b = -K + 1; b <= K - 1; b++) {     // 마름모 중간 row 작업
					if (j + b >= 0 && j + b < N && city[i][j + b]) count++;
				}
				row++;          // 중간 밑으로 이동

				for (c = K - 2; c >= 0; c--, row++) {   // 마름모 중간 밑부터 맨 아래까지 작업
					if (row >= N) continue;
					for (b = -c; b <= c; b++) {         // -3~3 7개 / -2~2 5개 / -1~1 3개
						if (j + b >= 0 && j + b < N && city[row][j + b]) count++; //서비스 받는 집이면 count 증가
					}
				}

				if (M * count - cost >= 0 && Max < count) Max = count;    //손해 보지 않을 때, Max값 업데이트
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