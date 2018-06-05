package Greedy;

import java.util.*;
public class Baekjoon_11047 {					
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		
		int []coin = new int[N];
		for(int i=0 ; i<N ; i++) coin[i]=input.nextInt();
		
		int result=0;
		for(int i=N-1 ; i>=0 && K!=0; i--){
			if(coin[i] > K) continue;
			while(K >= coin[i]){
				K = K-coin[i];
				result++;
			}
		}
		System.out.println(result);
	}
}

/*

10 4200
1
5
10
50
100
500
1000
5000
10000
50000

*/ 
