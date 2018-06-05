package Topological;

import java.util.*;
public class Baekjoon_1005 {					//위상정렬 문제
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		for(int test=0 ; test<testcase ; test++){
			int N = input.nextInt();
			int K = input.nextInt();
			int time[] = new int[N];
			int result[] = new int[N];
			LinkedList<Integer> graph[] = new LinkedList[N];		//정방향 그래프
			LinkedList<Integer> reverse[] = new LinkedList[N];		//역방향 그래프
			for(int i=0 ; i<N ; i++){
				time[i] = input.nextInt();
				graph[i]=new LinkedList<Integer>();
				reverse[i] = new LinkedList<Integer>();
			}
			int num_edge[] = new int[N];		//오는 간선 개수 표시
			
			int s,e,node;
			for(int i=0 ; i<K ; i++){
				s = input.nextInt()-1;   e = input.nextInt()-1;
				graph[s].add(e);  reverse[e].add(s);
				num_edge[e]++;			//오는 간선 개수 표시
			}
			int end = input.nextInt()-1;

			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i=0 ; i<N ; i++) {
				if(num_edge[i]==0) queue.add(i);		//오는 간선이 없는 노드 먼저 큐에 추가
				result[i] = time[i];					//다음과 같이 초기화
			}
			
			while(!queue.isEmpty()){
				node = queue.remove();
				for(int k :graph[node]){		//연결 되어있는 모든 노드
					num_edge[k]--;				//오는 간선 개수 줄이고
					if(num_edge[k]==0) {		//오는 간선이 없으면
						for(int t : reverse[k]){		//역방향 그래프 이용
							if(result[k] < result[t] + time[k]){	//k노드 까지 가는데 걸리는 최대 시간을
								result[k] = result[t] + time[k];	//k번 노드 건설 시간+이전 노드(t)의 결과 중 큰것으로 세팅
							}
						}
						queue.add(k);		//오는 간선이 없는 것 큐에 추가
					}
				}
			}
			System.out.println(result[end]);
		}
	}
}

/*

2
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7
*/ 
