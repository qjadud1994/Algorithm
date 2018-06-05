package Dijkstra;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Baekjoon_1916_List {
	static int max = 1000000001;				//이상하게 이 값으로 해놔야 정답으로 뜬다.
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		int E = input.nextInt();
		LinkedList<node> graph[] = new LinkedList[V];
		for(int i=0 ; i<V ; i++) graph[i]=new LinkedList<node>();	//유향 그래프의 리스트 표현

		for(int i=0 ; i<E ; i++){									//리스트 그래프 표현
			graph[input.nextInt()-1].add(new node(input.nextInt()-1, input.nextInt()));
		}					
		int start = input.nextInt()-1;
		
		PriorityQueue<node> PQ = new PriorityQueue<node>();			//PQ를 이용한 다익스트라
		int Dist[] = new int[V];				//최단거리 배열
		for(int i=0 ; i<V ; i++){
			Dist[i]=max;						//최대 값으로 세팅
		}
		
		Dist[start]=0;
		PQ.add(new node(start,0));			//시작 노드 add -> weight=0 으로
		
		while(!PQ.isEmpty()){	//BFS와 비슷
			int vertex = PQ.peek().vertex;		//우선순위가 가장 높은 노드  -> weight가 가장 큰 노드
			PQ.remove();						//삭제
			for(Iterator<node> iter = graph[vertex].iterator() ; iter.hasNext() ;){	//현재 노드에 연결된 모든 노드
				node next = iter.next();		//연결된 노드
				if(Dist[next.vertex] > Dist[vertex] + next.weight){		//최단 거리 수정 -> next까지 한번에 가는것보다  
					Dist[next.vertex] = Dist[vertex] + next.weight;		//vertex를 거쳐가는게 더 빠르면 수정
					PQ.add(next);					//거쳐가는 것이 더 빠르면
				}
			}
		}
		System.out.println(Dist[input.nextInt()-1]);
	}
	static class node implements Comparable<node>{
		int vertex, weight;
		public node(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(node a){
			return this.weight > a.weight ? 1 : -1;
		}
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