package Greedy;

import java.util.*;
public class Baekjoon_11399 {					
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int people[] = new int[n];
		for(int i=0 ; i<n ; i++) people[i]=input.nextInt();
		
		Arrays.sort(people);
		int result=people[0];
		for(int i=1 ; i<n ; i++){
			people[i] = people[i] + people[i-1];
			result+=people[i];
		}
		System.out.println(result);
	}
}

/*

5
3 1 4 3 2

*/ 
