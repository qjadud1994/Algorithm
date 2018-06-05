package Greedy;

import java.util.*;
public class Baekjoon_1931 {					
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int result=0,end=0;
		LinkedList<ref> table = new LinkedList<ref>();
		for(int i=0 ; i<n ; i++) {
			table.add(new ref(input.nextInt(), input.nextInt()));
		}
		Collections.sort(table);		//늦게 끝나는 시간 순서대로 정렬하고
		for(ref k : table){				//하나씩 시간에 맞춰 개수를 세면 그것이 답이다.
			if(end <= k.s){
				result++;
				end = k.e;
			}
		}
		System.out.println(result);
	}
	static class ref implements Comparable<ref>{
		int s,e;
		public ref(int s, int e){
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(ref a){
			if(this.e==a.e) return this.s>a.s ? 1 : -1;
			return this.e>a.e ? 1 : -1;
		}
	}
}

/*

11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

*/ 
