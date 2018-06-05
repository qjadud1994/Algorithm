import java.util.Scanner;
 
public class Floyd {
    public static void main(String args[]) throws Exception {
    	Scanner input = new Scanner(System.in);
    	int V = input.nextInt();
    	int E = input.nextInt();
    	
        int[][] D = new int[V][V];
        int INF = 9999;
        for (int i = 0; i < V; i++){
    		for (int j = 0; j < V; j++){
    			if (i == j) D[i][j] = 0;
    			else D[i][j] = INF;
    		}
    	}

        for(int i=0 ; i<E ; i++){
        	D[input.nextInt()-1][input.nextInt()-1] = input.nextInt();
        }
        int [][]p = new int[V][V];		//경로 저장
        
        for(int k=0 ; k<V ; k++){				//경유 노드
        	for(int i=0 ; i<V ; i++){			//출발 노드
        		for(int j=0 ; j<V ; j++){		//도착 노드
        			if(D[i][k]==INF || D[k][j]==INF) continue;
        			if(D[i][j] > D[i][k]+D[k][j]){				//갱신
        				 D[i][j] = D[i][k]+D[k][j];
        				 p[i][j] = k;
        			}
        		}
        	}
        }
        path(p,4,2);		//경로 추적
        
        for(int i=0 ; i<V ; i++){
        	for(int j=0 ; j<V ; j++){
        		System.out.print(D[i][j]+" ");
        	}
        	System.out.println();
        }
    }
    static void path(int p[][], int q, int r){
    	if(p[q][r] != 0){
    		path(p,q,p[q][r]);
    		System.out.print("v"+p[q][r]+" ");
    		path(p,p[q][r],r);
    	}
    }
}

/* input

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