package BFS_DFS;
import java.util.*;
										//숨바꼭질 -> BFS
public class Baekjoon_1697 {			//https://www.acmicpc.net/problem/1697
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	int start = input.nextInt();
    	int target = input.nextInt();
    	
    	Queue<Integer> queue = new LinkedList<Integer>();		//너비 탐색으로 해야 최소 횟수를 찾을 수 있다. (깊이 = 탐색 수)
    	int visit[] = new int[100001];
    	int l; 
    	queue.offer(start);				//시작점을 추가
    	visit[start]=1;					//visit의 의미는 한번만 방문 그리고 이동 횟수를 나타낸다.
    	while(!queue.isEmpty()){
    		l = queue.poll();
    		if(l == target){			
    			System.out.println(visit[l]-1);
    			return;
    		}
    		if(l-1 >= 0 && visit[l-1]==0) {queue.offer(l-1); visit[l-1]=visit[l]+1;}	
    		if(l+1 <= 100000 && visit[l+1]==0) {queue.offer(l+1); visit[l+1]=visit[l]+1; }
    		if(l*2 <= 100000 && visit[l*2]==0) {queue.offer(l*2); visit[l*2]=visit[l]+1; }
    	}
	}
}




/*
 
5 17

*/
