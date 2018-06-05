package Dijkstra;

import java.util.*;
public class Baekjoon_1238 {			//최대 왕복 거리인 노드 찾기
	static int max=1000001;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int X = input.nextInt()-1;
		
		int [][]D = new int[N][N];
		for(int i=0 ; i<N ; i++){
			for(int j=0 ; j<N ; j++){
				if(i!=j) D[i][j]=max;
			}
		}
		for(int i=0 ; i<M ; i++){
			D[input.nextInt()-1][input.nextInt()-1] = input.nextInt();
		}
		
		for(int k=0 ; k<N ; k++){
			for(int i=0 ; i<N ; i++){
				for(int j=0 ; j<N ; j++){
					if(D[i][k]==max || D[k][j]==max) continue;
					if(D[i][j] > D[i][k] + D[k][j]){
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		int result=-1;
		for(int i=0 ; i<N ; i++){
			if(D[i][X]==max || D[X][i]==max || X==i) continue;
			if(result < D[i][X]+D[X][i]) result = D[i][X]+D[X][i];
		}
		System.out.println(result);
	}

}

/*

4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

*/ 
