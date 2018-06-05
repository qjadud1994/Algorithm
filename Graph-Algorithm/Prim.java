//prim : 모든 노드를 최단경로로 방문하는것
import java.util.*;
 
public class Prim {
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
        int[] near = new int[n]; 		//가중치 저장
        
        int min=9999;
        int current = 0;		//탐색 시작 노드
 
        visit[0]=true;       	//시작 노드는 방문으로
        for(int i=1 ; i<n ; i++){
        	near[i] = weight[current][i];		//시작노드로부터 다른 노드들의 가중치로 초기화한다. !! 
        }
 
        int v = 0;								//시작노드의 다른 매개변수
        for (int i = 0; i < n; i++) {			//모든 노드
            min = 9999;
           
            for (int j = 0; j < n; j++) {					//prim_easy와 다르게 최소값을 갖는 노드를 탐색하면서 가중치 배열을 바꾼다.
            	if(current != j && visit[j]==false){			
            		if (near[j] > weight[current][j]) {
                        near[j]= weight[current][j];		//최단 경로부터 바꾸어준다.
                    }
                    if (min >= near[j]){					//최소값을 갖는 노드를  v에 저장한다.
                    	min = near[j];
                    	v = j;
                    }
            	}
                
            }
            System.out.print(current+" -> ");
            visit[current] = true;					//current는 방문으로
            current = v;							//current를 최소노드 v로 바꾼다.
        }
        System.out.println("");
        System.out.println(print(near));
    }
    static int print(int []near){
    	int sum=0;
    	int n= near.length;
    	for(int i=0 ; i<n ; i++){
    		System.out.print(near[i]+" , ");
    		sum += near[i];
    	}
    	System.out.println("");
    	return sum;
    }
}

/* input

5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0


*/