package DP;
import java.util.*;
public class Baekjoon_2157_Floyd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int K = input.nextInt();
		
		int [][]D = new int[N+10][N+10];
		int [][]graph = new int[N+10][N+10];
		for(int i=0 ; i<N ; i++){
			for(int j=0 ; j<N ; j++){
				D[i][j] = -1;
				graph[i][j] = -1;
			}
		}
		for(int i=0 ; i<K ; i++){
			int x = input.nextInt();
			int y = input.nextInt();
			int w = input.nextInt();
			graph[x][y] = Math.max(graph[x][y], w);
		}
		
		D[1][0] = 0;
		for(int i=2 ; i<=N ; i++){
			for(int j=1 ; j<i ; j++){
				for(int k=1 ; k<M ; k++){
					if(graph[j][i] != -1 && D[j][k-1] != -1){
						D[i][k] = Math.max(D[i][k], D[j][k-1]+graph[j][i]);
					}
				}
			}
		}
		int result = 0;
	    for (int i = 1; i < M; i++){
	    	if(result < D[N][i]) result = D[N][i];
	    }
	    System.out.println(result);
		
		
	}

}

/*

3 3 5
1 3 10
1 2 5
2 3 3
1 3 4
3 1 100

*/
