import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
 
public class Bellman_Ford {
    public static void main(String args[]) throws Exception {
    	Scanner input = new Scanner(System.in);
    	int V = input.nextInt();
		int E = input.nextInt();
    	LinkedList<node> graph[] = new LinkedList[V];
		for(int i=0 ; i<V ; i++) graph[i]=new LinkedList<node>();	//유향 그래프의 리스트 표현

		for(int i=0 ; i<E ; i++){									//리스트 그래프 표현
			graph[input.nextInt()-1].add(new node(input.nextInt()-1, input.nextInt()));
		}		
        
        int[] Dist = new int[V]; 		//가중치 저장
        int []path = new int[V];		//경로 저장
        int min=9999;
        int current = 0;		//탐색 시작 노드
 
        for(int i=0 ; i<V ; i++){
        	Dist[i] = min;		//시작노드로부터 다른 노드들의 가중치로 초기화한다. !!
        }
        Dist[current]=0;			
       
        boolean update = true;
        int cnt = 0;
        
        while(update && cnt!=V){
        	update = false;
        	cnt++;
        	for(int vertex=0 ; vertex<V ; vertex++){
        		for(node next : graph[vertex]){	//현재 노드에 연결된 모든 노드
        			if(Dist[next.vertex] > Dist[vertex] + next.weight){		//최단 거리 수정 -> next까지 한번에 가는것보다  
    					Dist[next.vertex] = Dist[vertex] + next.weight;		//vertex를 거쳐가는게 더 빠르면 수정
    					update = true;
    				}
    			}
        	}
        }
        
        int result=0;
        for(int i=0 ; i<V ; i++){
        	System.out.println(Dist[i]);
        	result+=Dist[i];
        }
        System.out.println("result = "+result);
    }
    static class node{							//그래프 표현을 위한 node 클래스
    	int vertex,weight;								//출발노드, 도착노드, 가중치
    	public node(int vertex, int weight){
    		this.vertex = vertex;
    		this.weight = weight;
    	} 	
    }
}

/* input

6 9
1 2 6
1 3 5
1 4 5
2 5 -1
3 2 -2
3 5 1
4 3 -3
4 6 -1
5 6 3

*/