import java.util.*;

public class Topological {
	public static void main(String[] args) {
		int i,node,start,end;
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		int E = input.nextInt();
		
		LinkedList<Integer> graph[] = new LinkedList[V];
		for(i=0 ; i<V ; i++) graph[i]=new LinkedList<Integer>();
		int num_edge[] = new int[V];		//오는 간선 개수 표시
		
		for(i=0 ; i<E ; i++){
			start = input.nextInt()-1;
			end = input.nextInt()-1;
			graph[start].add(end);
			num_edge[end]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(i=0 ; i<V ; i++){			//오는 간선이 없는 노드를 모두 queue에 넣기
			if(num_edge[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()){
			node = queue.remove();
			System.out.print((node+1)+" ");
			for(int k : graph[node]){			//연결된 모든 노드를
				num_edge[k]--;					//오는 간선 수 제거
				if(num_edge[k]==0) queue.add(k);	//오는 간선이 없으면 queue에 add
			}
			
		}	
	}
}

/*

6 8
1 3
2 4
2 5
3 4
3 5
3 6
4 6
5 6

*/