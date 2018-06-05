
import java.util.*;

public class Ford_Fulkerson_Queue {

	public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int line = input.nextInt();
    	int n = input.nextInt();
    	int [][]flow = new int[n][n];
    	for(int i=0 ; i<line ; i++){
    		flow[input.nextInt()-1][input.nextInt()-1]=input.nextInt();
    	}

    	int S = 0, E = n-1;			//S노드부터 E노드 까지 
    	int node, k, max_flow=0,min=99999;
    										// path 때문에 visit은 필요가 없다
    	
    	while(true){
    		Queue<Integer> queue = new LinkedList();
        	int []path = new int[n];			//경로 추적
        	for (int i=0 ; i<n ; i++) path[i]=-1;
        	
        	queue.add(S);						//시작점 S 
	    	while (!queue.isEmpty()){
	    		node = queue.remove();
				for(int i=0 ; i<n ; i++){
					if(flow[node][i]!=0 && path[i]==-1) {		// 유량이 있고 미방문이면
						path[i]=node;			// 경로에 추가
						queue.add(i);			// 다음 노드
						if(i==E) break;		//도착점까지 왔으면 벗어난다.
					}
	    		}
	    	}
			
	    	if (path[E]==-1) break;			// 도착점의 전 노드가 없다 -> 유량이 다차서 이제 못간다 -> whlie문을 벗어난다.
	    	
	    	min = 99999;
			k = E;
			while(k!=S){				// 최소 유량을 찾아내기 위한 역추적
				if(min>flow[path[k]][k]) min=flow[path[k]][k];
				k = path[k];
			}
			System.out.println("min = "+min);
			k = E;
			while(k!=S){				// 여태 지나온 길에 최소 유량을 빼고
				flow[path[k]][k]-=min;
				flow[k][path[k]]+=min;		//역가중치는 더해준다.
				k = path[k];
			}
			
			max_flow += min;			// 최대 유량에 더해준다.
		}
    	System.out.println("max = "+max_flow);
	}
}

/*

11 8
1 2 90
1 3 45
1 4 75
2 5 60
2 7 50
3 5 85
4 6 40
4 7 40
5 8 30
6 8 45
7 8 30


*/