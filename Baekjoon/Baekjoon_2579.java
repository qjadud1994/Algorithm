package DP;
import java.util.Scanner;
public class Baekjoon_2579 {
	public static void main(String[] args) {			//계단오르기 문제
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int stair[] = new int[n+1];
		for(int i=1 ; i<=n ; i++) stair[i] = input.nextInt();
		int D[] = new int[n+1];
		
		D[0] = 0;
		D[1] = stair[1];
		D[2] = D[1]+stair[2];
		
		for(int i=3 ; i<=n ; i++){
			D[i] = Math.max(D[i-3]+stair[i-1], D[i-2]) + stair[i];
		}
		System.out.println(D[n]);
	}
}

/*

6
10
20
15
25
10
20

*/