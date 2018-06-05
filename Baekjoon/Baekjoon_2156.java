package DP;
import java.util.*;
public class Baekjoon_2156 {					//와인 많이 마시기
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int []wine = new int[n+1];
		for(int i=1 ; i<=n ; i++) wine[i] = input.nextInt();
		
		if(n==1) {
			System.out.println(wine[1]);
			return ;
		}
		int []D = new int[n+1];
		D[0] = 0;
		D[1] = wine[1];
		D[2] = wine[2] + wine[1];
		for(int i=3 ; i<=n ; i++){
			D[i] = Math.max(D[i-2], D[i-3]+wine[i-1]) + wine[i];
			D[i] = Math.max(D[i], D[i-1]);					//두번 연속 건너 뛸 때
		}
		int max=D[n];
		if(max < D[n-1]) max = D[n-1];
		if(max < D[n-2]) max = D[n-2];
		System.out.println(max);

	}
}

/*

6
6
10
13
9
8
1

*/
