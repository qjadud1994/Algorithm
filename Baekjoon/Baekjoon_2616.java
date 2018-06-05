package DP;
import java.util.Scanner;
public class Baekjoon_2616 {					//기관차 문제
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int train[] = new int[n + 1];
		for(int i=1 ; i<=n ; i++){
			train[i] = train[i-1]+input.nextInt();
		}
		int c = input.nextInt();
		
		int D[][] = new int[4][n+1];
		for(int i=1 ; i<=3 ; i++){
			for(int j=c*i ; j<=n ; j++){
				D[i][j] = Math.max(D[i][j-1], train[j]-train[j-c]+D[i-1][j-c]);
			}
		}
		System.out.println(D[3][n]);
	}
}

/*

7
35 40 50 10 30 45 60
2

*/