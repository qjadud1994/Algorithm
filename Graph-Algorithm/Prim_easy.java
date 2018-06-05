//prim : 모든 노드를 최단경로로 방문하는것
import java.util.*;

public class Prim_easy {
	static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws Exception {
    	Scanner input = new Scanner(System.in);
    	int V = input.nextInt();
    	int E = input.nextInt();
        int[][] weight = new int[V][V];			//그래프 표현을 위한 2차원 배열
      
        for(int i=0 ; i<V ; i++){
        	for(int j=0 ; j<V ; j++){
        		if(i!=j) weight[i][j]=INF;		//연결이 없는 곳은 큰 값을 사용
        	}
        }
        for(int i=0 ; i<E ; i++){				//연결 간선 입력
        	int s = input.nextInt()-1, e = input.nextInt()-1;
        	int w = input.nextInt();
        	weight[s][e] = w; weight[e][s] = w;	//양방향 그래프
        }

        boolean[] visit = new boolean[V]; //방문 확인
        int[] near = new int[V]; 		//가중치 저장
        
        int min, current = 0;		//탐색 시작 노드
        visit[0]=true;       	//시작 노드는 방문으로
        
        for(int i=1 ; i<V ; i++){
        	near[i] = weight[current][i];		//시작노드로부터 다른 노드들의 가중치로 초기화한다. !!
        }
        
        for (int i = 0; i < V; i++) {
            min = INF;
            for (int j = 0; j < V; j++) {
                if (min > near[j] && visit[j] == false) { 	// 최단 노드 찾기
                    min = near[j];
                    current = j;
                }
            }
            visit[current] = true;			//방문 표시
            for (int j = 0; j < V; j++) {
                if ((near[j] > weight[current][j]) && visit[j]==false) {
                	near[j] = weight[current][j];					//near 수정
                } 
            }
        }
        int result=0;
        for(int i=0 ; i<V ; i++) {
        	result+=near[i];
        }
        System.out.println(result);
    }
}

/* input

7 9
1 2 8
1 6 11
1 7 9
2 3 10
3 7 5
4 5 7
4 7 12
5 6 8
6 7 13

*/