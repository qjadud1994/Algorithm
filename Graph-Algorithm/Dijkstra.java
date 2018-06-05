import java.util.*;
 
public class Dijkstra {
    public static void main(String args[]) throws Exception {
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	
        int[][] weight = new int[n][n];
      
        for(int i=0 ; i<n ; i++){
        	for(int j=0 ; j<n ; j++){
        		weight[i][j] = input.nextInt();
        	}
        }
        boolean[] visit = new boolean[n]; //방문 확인
        int[] Dist = new int[n]; 		//가중치 저장
        int []path = new int[n];		//경로 저장
        int min=9999;
        int current = 0;		//탐색 시작 노드
 
        for(int i=0 ; i<n ; i++){
        	Dist[i] = min;		//시작노드로부터 다른 노드들의 가중치로 초기화한다. !!
        	path[i]=-1;		// 경로는 모두 -1로 초기화
        }
        int start=0;
        Dist[current]=0;			
        visit[current]=true;
 
        int v = 0;								//시작노드의 다른 매개변수
        for (int i = 0; i < n; i++) {			//모든 노드
            min = 9999;
           
            for (int j = 0; j < n; j++) {									//Dijkstra_easy와 다르게 첫번째 min노드는 무조건 시작노드이기 때문에 순서를 바꾸어준다.
            	if(visit[j]==false){											// 최소값 노드 탐색을 뒤로 -> 이렇게 하면 한번의 포문으로 해결가능하다.
            		if (Dist[j] > Dist[current]+weight[current][j]) {
                        Dist[j]= Dist[current]+weight[current][j];		//최단 경로부터 바꾸어준다.
                        	path[j]=current;
                    }
                    if (min >= Dist[j]){									//최소값을 갖는 노드를  v에 저장한다.
                    	min = Dist[j];
                    	v = j;
                    }
            	}
                
            }
            visit[current] = true;								//current는 방문으로
            current = v;													//current를 최소노드 v로 바꾼다.
           
        }
        
        start = 0;
          int end = 3;
        System.out.println("Weight : "+Dist[end]);
        while( end!= start){
        	System.out.println(end+" <- ");
        	end = path[end];
        }
        System.out.println(start);
    }
}

/* input

5
0 2 5 999 3
999 0 999 4 10
999 999 0 6 2
999 999 999 0 999
999 999 1 2 0


*/