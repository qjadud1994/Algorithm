import java.util.*;
public class Dijkstra_PQ {
	static int max=99999;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		int E = input.nextInt();
		LinkedList<node> graph[] = new LinkedList[V];
		for(int i=0 ; i<V ; i++) graph[i]=new LinkedList<node>();	//유향 그래프의 리스트 표현

		for(int i=0 ; i<E ; i++){									//리스트 그래프 표현
			graph[input.nextInt()-1].add(new node(input.nextInt()-1, input.nextInt()));
		}					
		
		PriorityQueue<node> PQ = new PriorityQueue<node>();			//PQ를 이용한 다익스트라
		int Dist[] = new int[V];				//최단거리 배열
		int path[] = new int[V];				//경로 배열
		int start = 0;							//시작 노드
		for(int i=0 ; i<V ; i++){
			Dist[i]=max;						//최대 값으로 세팅
			path[i]=0;
		}
		
		Dist[start]=0;
		PQ.add(new node(start,0));			//시작 노드 add -> weight=0 으로
		
		while(!PQ.isEmpty()){	//BFS와 비슷
			int vertex = PQ.peek().vertex;		//우선순위가 가장 높은 노드  -> weight가 가장 작은 노드
			PQ.remove();						//삭제

			for(node next : graph[vertex]){	//현재 노드에 연결된 모든 노드
				if(Dist[next.vertex] > Dist[vertex] + next.weight){		//최단 거리 수정 -> next까지 한번에 가는것보다  
					Dist[next.vertex] = Dist[vertex] + next.weight;		//vertex를 거쳐가는게 더 빠르면 수정
					PQ.add(next);					//거쳐가는 것이 더 빠르면
					path[next.vertex]=vertex;		//경로 세팅
				}
			}
		}
		
		int s = 0;
		int e = V-1;
		System.out.print(s+" -> ");
		while(s!=e){
			System.out.print(e+" -> ");
			e = path[e];
		}
		System.out.println();
		for(int i=0 ; i<V ; i++){
			System.out.print("Dist["+i+"] : ");
			if(Dist[i]==max) System.out.println("INF");
			else System.out.println(Dist[i]);
		}
	}
	static class node implements Comparable<node>{
		int vertex, weight;
		public node(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(node a){		//this가 큰게 1이면 오름차순 (min heap)
			return this.weight > a.weight ? 1 : -1;
		}
	}
}





/*

5 9
1 2 2
1 3 5
1 5 3
2 4 4
2 5 10
3 4 6
3 5 2
5 3 1
5 4 2

*/
