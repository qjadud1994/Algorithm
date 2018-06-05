package Greedy;

import java.util.*;
public class Baekjoon_10610 {					
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String N = input.next();
		String []sp = N.split("");
		LinkedList<Integer> list = new LinkedList<Integer>();
		int len = sp.length;
		for(int i=0 ; i<len ; i++){
			list.add(Integer.parseInt(sp[i]));
		}
		Collections.sort(list, Collections.reverseOrder());
		
		if(!check(list,len)) System.out.println("-1");
		else{
			for(int i : list){
				System.out.print(i);
			}
		}
	}
	static boolean check(LinkedList<Integer> list, int len){
		if(list.get(len-1)!=0) return false;
		int sum=0;
		for(int i : list) sum+=i;
		if(sum%3 != 0) return false;
		return true;
	}
	
}

/*

30

102

2931

*/ 
