package Dijkstra;

import java.util.*;
public class Baekjoon_1504 {			//특수 두점은 반드시 지나는 다익스트라
	static int max=1000001;				//-> 나눠서 생각하기
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		int E = input.nextInt();
		
		LinkedList<node> graph[] = new LinkedList[V];
		int []Dist = new int[V];
		for(int i=0 ; i<V ; i++) {
			graph[i]=new LinkedList<node>();
			Dist[i] = max;
		}
		for(int i=0 ; i<E ; i++){			//양방향 그래프 세팅
			int a = input.nextInt()-1;
			int b = input.nextInt()-1;
			int c = input.nextInt();
			graph[a].add(new node(b,c));
			graph[b].add(new node(a,c));		
		}
		int A = input.nextInt()-1;
		int B = input.nextInt()-1;
		int result[] = new int[2];			//다익스트라를 여러번 하는 것이 핵심!
		int result1=0, result2=0;
		result = dijstra(0,A,B,V,graph);			
		result1+=result[0];					// 0->A
		result2+=result[1];					// 0->B
		
		result = dijstra(A,B,V-1,V,graph);
		result1+=result[0];					// (0->) A->B
		result2+=result[1];					// (0->B->) A->V
		
		result = dijstra(B,V-1,A,V,graph);
		result1+=result[0];					// (0->A->) B->V
		result2+=result[1];					// (0->) B->A (->V)
		
		if(result1>=max && result2>=max) System.out.println("-1");		//길이 없을 때
		else System.out.println(Math.min(result1, result2));
	}
	
	static int[] dijstra(int start, int A, int B, int V, LinkedList<node> graph[]){
		int []Dist = new int[V];
		for(int i=0 ; i<V ; i++) {
			Dist[i] = max;
		}
		Dist[start]=0;
		PriorityQueue<node> PQ = new PriorityQueue<node>();
		PQ.add(new node(start,0));
		while(!PQ.isEmpty()){
			int v = PQ.peek().v;
			PQ.poll();
			for(Iterator<node> iter=graph[v].iterator() ; iter.hasNext() ; ){
				node next = iter.next();
				if(Dist[next.v] > Dist[v]+next.w){
					Dist[next.v] = Dist[v]+next.w;
					PQ.add(next);
				}
			}
		}
		int ret[] = {Dist[A],Dist[B]};
		return ret;
	}
	
	static class node implements Comparable<node>{
		int v,w;
		public node(int v, int w){
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(node a){
			return this.w-a.w > 0 ? -1 : 1;
		}
	}

}

/*

4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

*/ 
