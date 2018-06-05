package Topological;

import java.util.*;
public class Baekjoon_2252 {					//줄세우기 문제
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		int E = input.nextInt();
		
		LinkedList<Integer> graph[] = new LinkedList[V];
		for(int i=0 ; i<V ; i++){
			graph[i]=new LinkedList<Integer>();
		}
		int s,e,node;
		int num_edge[] = new int[V];
		for(int i=0 ; i<E ; i++){
			s = input.nextInt()-1;   e = input.nextInt()-1;
			graph[s].add(e);
			num_edge[e]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0 ; i<V ; i++) {
			if(num_edge[i]==0) queue.add(i);		//오는 간선이 없는 노드 먼저 큐에 추가
		}
		
		while(!queue.isEmpty()){			//위상 정렬을 이용해 순서대로 출력하는게 줄세우기가 된다.
			node = queue.remove();
			System.out.print((node+1)+" ");
			for(int k :graph[node]){
				num_edge[k]--;
				if(num_edge[k]==0) {
					queue.add(k);
				}
			}
		}
	}
}

/*

3 2
1 3
2 3

4 2
4 2
3 1

*/ 
