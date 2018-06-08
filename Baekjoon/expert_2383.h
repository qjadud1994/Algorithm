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

int get_distance(int p, char flag) {		// 입구와 어떤 점 사이의 거리 구하는 함수
	if (flag == 'A') return abs(entrance[0].first - point[p].first) + abs(entrance[0].second - point[p].second);
	return abs(entrance[1].first - point[p].first) + abs(entrance[1].second - point[p].second);
}

void get_time(bool check[]) {				// 어떤 조합에서 소요되는 시간 구하는 함수
											// check 배열에서 true는 A를 이용하는 사람, false는 B를 이용하는 사람
	int time_A = room[entrance[0].first][entrance[0].second];	// 입구 A의 계단 길이
	int time_B = room[entrance[1].first][entrance[1].second];	// 입구 B의 계단 길이

	vector<int> entrance1, entrance2;		// 입구 A, B를 사용하는 사람들의 거리를 저장하는 벡터
	for (int i = 0; i < N; i++) {			// check 배열을 통해 입구 A, B의 사람들을 저장
		if (check[i]) entrance1.push_back(get_distance(i, 'A') + time_A + 1);	// 거리 저장 + 계단 길이 + 입구 도착 시간(1) 
		else entrance2.push_back(get_distance(i, 'B') + time_B + 1);
	}

	sort(entrance1.begin(), entrance1.end());		// 빠른 시간 순서대로 정렬
	sort(entrance2.begin(), entrance2.end());

	int result_A = 0, result_B = 0;					// A, B 계단을 사용하는데 걸리는 시간
	int count = 0;									// 최대 허용 인원인 3명을 체크하는 변수

	for (int i = 0; i < entrance1.size(); i++) {	// 입구 A의 경우, 모든 사람들에 대해 
		while (entrance1[i] != 0) {					// i째 사람이 다 내려갈 때 까지
			for (int j = 0; i + j < entrance1.size(); j++) {		//i번째 이후의 모든 사람에 대해 
				if (j >= 3 && entrance1[i + j] == time_A) continue;	//3명 이상이 계단을 이용 중인데, i+j번째 사람이 계단 입구에 도착했을 때 -> 대기 (continue)
				entrance1[i + j]--;									//거리를 1씩 감소
			}
			result_A++;								// 시간 1 경과
		}
	}

	for (int i = 0; i < entrance2.size(); i++) {	// 입구 B의 경우 A와 같은 작업
		while (entrance2[i] != 0) {
			for (int j = 0; i + j < entrance2.size(); j++) {
				if (j >= 3 && entrance2[i + j] == time_B) continue;
				entrance2[i + j]--;
			}
			result_B++;
		}
		if (entrance2[i] != 0 && count != time_B) result_B--;
	}

	int result = result_A < result_B ? result_B : result_A;		// A와 B 둘 중 오래 걸린 시간이 이번 case의 답
	if (min_time > result) min_time = result;					// 최소 시간 업데이트
}

void solution(int count, int start, bool check[]) {		// 모든 경우의 수 고려하기
	if (count == N) {			// 모든 사람을 다 고려했다면
		get_time(check);		// 그 조합의 시간을 구하기
		return;
	}
	for (int i = start; i < N; i++) {
		check[i] = true;
		solution(count + 1, i + 1, check);	// i번째 사람이 true(A 계단) 일 때
		check[i] = false;
		solution(count + 1, i + 1, check);	// i번째 사람이 false(B 계단) 일 때
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
				if (room[i][j] == 1) point.push_back(make_pair(i, j));			// 사람을 vector에 저장
				else if (room[i][j] != 0) entrance.push_back(make_pair(i, j));	// 입구를 vector에 저장
			}
		}
		N = point.size();			// 사람의 수 = N
		solution(0, 0, check);

		printf("#%d %d\n", t, min_time);
	}
}