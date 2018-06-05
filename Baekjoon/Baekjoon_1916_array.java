package Dijkstra;
import java.util.*;
public class Baekjoon_1916_array {
	static int max=1000000001;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		int E = input.nextInt();
		int [][]weight = new int[V][V];

		int Dist[] = new int[V];				//최단거리 배열
		for(int i=0 ; i<V ; i++){
			Dist[i]=max;						//최대 값으로 세팅
			for(int j=0 ; j<V ; j++) if(i!=j) weight[i][j]=max;
		}
		
		for(int i=0 ; i<E ; i++){									//리스트 그래프 표현 
			int a1 = input.nextInt()-1;
			int a2 = input.nextInt()-1;
			int a3 = input.nextInt();
			if(weight[a1][a2] > a3) weight[a1][a2] = a3;
		}
		PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();			//PQ를 이용한 다익스트라
		int start = input.nextInt()-1;
		
		Dist[start]=0;
		weight[start][start]=0;
		PQ.offer(start);			//시작 노드 add -> weight=0 으로
		
		while(!PQ.isEmpty()){	//BFS와 비슷
			int vertex = PQ.poll();		//우선순위가 가장 높은 노드  -> weight가 가장 큰 노드
			for(int i=0 ; i<V ; i++){	//현재 노드에 연결된 모든 노드
				if(Dist[i] > Dist[vertex] + weight[vertex][i]){		//최단 거리 수정 -> next까지 한번에 가는것보다  
					Dist[i] = Dist[vertex] + weight[vertex][i];		//vertex를 거쳐가는게 더 빠르면 수정
					PQ.offer(i);					//거쳐가는 것이 더 빠르면
				}
			}
		}
		System.out.println(Dist[input.nextInt()-1]);
	}
	
}



/*

5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

*/