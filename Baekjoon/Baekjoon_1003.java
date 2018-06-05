package DP;

import java.util.*;
public class Baekjoon_1003 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int in[] = new int[n];
		int max=0;
		for(int i=0 ; i<n ; i++) {
			in[i]=input.nextInt();
			if(max < in[i]) max=in[i];
		}
		int [][]table = new int[max+1][2];
		table[0][0] = 1; 	table[0][1] = 0;
		table[1][0] = 0; 	table[1][1] = 1;
		for(int i=2 ; i<=max ; i++){
			table[i][0] = table[i-1][0]+table[i-2][0];
			table[i][1] = table[i-1][1]+table[i-2][1];
		}
		
		for(int i=0 ; i<n ; i++){
			System.out.println(table[in[i]][0]+" "+table[in[i]][1]);
		}
	}
	
}



/*

3
0
1
3

*/