#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <queue>
using namespace std;

short reception[10], repair[10];
short visitor[1001];

typedef struct person {
	int rec = 0, rep = 0;
}Person;

int solution(int N, int M, int K, int A, int B) {
	int i, j, k, wait_first;
	short rec[10], rep[10];
	short rec_visit[10], rep_visit[10];
	for (i = 1; i < 10; i++) {
		rec[i] = rep[i] = 0;
	}

	queue<int> wait;
	bool rec_full = false, rep_full = false;
	short time = visitor[1];
	int person = 1;
	Person *p = new Person[K + 1];

	int result = 0, num = 0;

	while (K > num) {
		//printf("\ntime : %d\n", time);
		for (k = 1; k <= M; k++) {		//정비 창구에 대해
			if (rep[k] != 0) {
				rep[k]--;
			}
		}

		k = 1;
		while (!wait.empty()) {			// 정비 창구 기다리는 사람들
			wait_first = wait.front();
			rep_full = true;
			j = k;
			for (k = j; k <= M; k++) {			// 가능한 정비 창구 탐색
				if (rep[k] == 0) {
					rep[k] = repair[k];			// 정비 창구 count 시작
					rep_visit[k] = wait_first;	// 정비 창구 방문자 업데이트
					p[wait_first].rep = k;
					//printf("repair %d <- reception %d <- visitor %d\n", k, p[wait_first].rec, wait_first);
					rep_full = false;
					wait.pop();
					num++;				// 정비 끝난 고객 수 증가
					break;
				}
			}
			if (rep_full) break;
		}

		rep_full = false;
		k = 1;
		for (j = 1; j <= N; j++) {					// 접수 창구에 대해 
			if (rec[j] != 0) {						// 접수 중인 창구라면
				rec[j]--;							// 접수 count 감소
				if (rec[j] == 0) {						// 접수가 끝났으면
					if (rep_full) {						// 이미 다 찼으면 대기 명단에 추가
						wait.push(rec_visit[j]);
						continue;
					}
					rep_full = true;
					i = k;
					for (k = i; k <= M; k++) {		// 정비 창구로 이동
						if (rep[k] == 0) {			// 정비 창구가 비었다면
							rep[k] = repair[k];			// 정비 창구 count 시작
							rep_visit[k] = rec_visit[j];	// 정비 창구 방문자 업데이트
							p[rec_visit[j]].rep = k;
							//printf("repair %d <- reception %d <- visitor %d\n", k, j, rec_visit[j]);
							rep_full = false;
							num++;				// 정비 끝난 고객 수 증가
							break;
						}
					}
					if (rep_full) wait.push(rec_visit[j]);		//다 찼으면 대기 명단에 추가
				}
			}
		}

		j = 1;
		for (i = person; i <= K; i++) {			// 모든 사람 접수 창구 접수하기
			rec_full = true;
			if (visitor[i] > time) break;		// 현재시각 손님 없을 때
			k = j;
			for (j = k; j <= N; j++) {			// 접수 창구 scan
				if (rec[j] == 0) {				// 비어있다면
					rec[j] = reception[j];	// 접수 시간 count 시작
					p[i].rec = j;
					rec_visit[j] = i;			// 접수대의 손님 번호 저장
												//printf("recption %d <- visitor %d\n", j, i);
					rec_full = false;
					break;
				}
			}
			if (rec_full) break;		// 다 찼으면 그만
		}

		person = i;
		time++;
	}
	for (i = 1; i <= K; i++) {
		if (p[i].rec == A && p[i].rep == B) {	// 지갑 고객인지 확인
			result += i;
		}
	}
	return result == 0 ? -1 : result;
}

int main() {
	int T, N, M, K, A, B;
	int t, j;

	scanf("%d", &T);

	for (t = 1; t <= T; t++) {
		scanf("%d %d %d %d %d", &N, &M, &K, &A, &B);
		for (j = 1; j <= N; j++) scanf("%hd", &reception[j]);
		for (j = 1; j <= M; j++) scanf("%hd", &repair[j]);
		for (j = 1; j <= K; j++) scanf("%hd", &visitor[j]);

		printf("#%d %d\n", t, solution(N, M, K, A, B));
	}
}