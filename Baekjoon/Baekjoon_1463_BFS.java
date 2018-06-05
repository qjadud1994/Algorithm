package DP;

import java.util.*;
public class Baekjoon_1463_BFS {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Queue<X> queue = new LinkedList<X>();
	
		queue.add(new X(n,0));
		while(!queue.isEmpty()){
			X p = queue.remove();
			if(p.num==1){
				System.out.println(p.count);
				break;
			}
			if(p.num%3==0) queue.add(new X(p.num/3,p.count+1));
			if(p.num%2==0) queue.add(new X(p.num/2,p.count+1));
			queue.add(new X(p.num-1, p.count+1));
		}
	}
}
class X{
	int num,count;
	public X(int num, int count){
		this.num = num;
		this.count = count;
	}
}

/*

3
0
1
3

*/