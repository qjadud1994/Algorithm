package Greedy;

import java.util.*;
public class Baekjoon_2217 {					
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int []rope = new int[N];
		
		for(int i=0 ; i<N ; i++) rope[i] = input.nextInt();
		Arrays.sort(rope);
		
		int max=0,count=1;
		for(int i=N-1 ; i>=0 ; i--,count++){
			if(max < rope[i]*count){
				max = rope[i]*count;
			}
		}
		System.out.println(max);
	}
}

/*

2
10
15

*/ 
