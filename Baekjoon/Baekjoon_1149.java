package DP;
import java.util.Scanner;
public class Baekjoon_1149 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int [][]table = new int[n][3];
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<3 ; j++){
				table[i][j] = input.nextInt();
			}
		}
		for(int i=1 ; i<n ; i++){
			table[i][0] += Math.min(table[i-1][1], table[i-1][2]);
			table[i][1] += Math.min(table[i-1][0], table[i-1][2]);
			table[i][2] += Math.min(table[i-1][0], table[i-1][1]);
		}
		int result=table[n-1][0];
		for(int i=1 ; i<3 ; i++){
			if(result > table[n-1][i]) result = table[n-1][i];
		}
		System.out.println(result);
	}
}

/*

3
26 40 83
49 60 57
13 89 99

*/
