import java.util.*;
 
public class Dijkstra_easy {
    public static void main(String args[]) throws Exception {
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	
        int[][] weight = new int[n][n];
      
        for(int i=0 ; i<n ; i++){
        	for(int j=0 ; j<n ; j++){
        		weight[i][j] = input.nextInt();
        	}
        }
        boolean[] visit = new boolean[n]; // 방문 여부 확인
        int[] Dist = new int[n]; // start 노드부터 n번째 노드까지 최단 거리를 저장하는 곳
        int min;
        int current = 0;
        int[] path = new int[n]; // 경로를 나타내는것
 
        for (int i = 0; i < n; i++) {
            visit[i] = false;
            Dist[i] = 9999;
        } //Dist는 모두 큰값으로 초기화
 
        Dist[current] = 0; //시작점은 0으로 (0에서 0까지는 거리가 0이므로)
 
        for (int i = 0; i < n; i++) {
            min = 9999;
            
            for (int j = 0; j < n; j++) {
                if (min > Dist[j] && visit[j] == false) {		
                    min = Dist[j];
                    current = j;
                } //Dist중 최소값을 갖는 노드(current)를 찾는다. (방문하지 않은 노드들 중에서)
            }
            visit[current] = true;
 
            for (int j = 0; j < n; j++) {
                if ((Dist[j] > Dist[current] + weight[current][j])
                        && weight[current][j] != 999) {
                	Dist[j] = Dist[current] + weight[current][j];
                    path[j] = current;
                } // Dist[j] -> start에서 j까지 한번에 가는길    과  Dist[current]+weight[current][j] -> start에서 current를 거쳐서 j까지 가는길
                	// 중에 짧은 거리로 설정. 경로 저장
            }		// 경로는 역추적으로만 가능하다. 
        }
 
        for(int i=0 ; i<path.length ; i++){
        	System.out.println(i+" -> "+path[i]);
//        	System.out.println(Dist[i]);
        }			//Dist[i]는 start에서 i까지 가는 최단 거리
       System.out.println("");
  
        int result=0;
        for (int i = 0; i < n; i++) {
            System.out.print(i + "도착  : ");
            int j = i;
            result = 0;
            System.out.print(j);
            while (j != 0) {
                System.out.print(" <- " + path[j]);
                result += weight[path[j]][j];
                j = path[j];				//path의 역추적
            }
            System.out.println("        //    Sum_of_weight : "+result);
        }
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