package Dijkstra;
import java.util.*;
public class Baekjoon_1753 {					//다익스트라 -> 우선순위큐로 구현
	static int max=99999;
	public static void main(String[] args) {	//이 문제 배열로 풀면 에러남
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		int E = input.nextInt();
		int start = input.nextInt()-1;
		LinkedList<node> graph[] = new LinkedList[V];
		for(int i=0 ; i<V ; i++) graph[i]=new LinkedList<node>();
		
		for(int i=0 ; i<E ; i++){
			graph[input.nextInt()-1].add(new node(input.nextInt()-1, input.nextInt()));
		}
		for(int i=0 ; i<V ; i++){
			for(int j=0 ; j<V ; j++){
				if(graph[i].size()==0 && i!=j) graph[i].add(new node(j,1));
			}
		}
		
		int Dist[] = new int[V];
		for(int i=0 ; i<V ; i++) Dist[i]=max;
		Dist[start]=0;
		
		PriorityQueue<node> queue = new PriorityQueue<node>();
		queue.add(new node(start,0));
		while(!queue.isEmpty()){
			node cur = queue.remove();
			for(Iterator<node> i=graph[cur.v].iterator() ; i.hasNext() ;){
				node n = i.next();
				if(Dist[n.v] > Dist[cur.v] + n.w){
					Dist[n.v] = Dist[cur.v] + n.w;
					queue.add(n);
				}
			}
		}
		
		for(int i=0 ; i<V ; i++){
			if(Dist[i]==max) System.out.println("INF");
			else System.out.println(Dist[i]);
		}
	}
	
}

class node implements Comparable<node>{
	int v,w;
	public node(int v, int w){
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(node a){
		return this.w < a.w ? 1 : -1;
	}
}


/*

5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

*/
