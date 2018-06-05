package BFS_DFS;
import java.util.*;

public class Baekjoon_2667 {				//단지번호붙이기 -> DFS
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	int [][]house = new int[n][n];
    	for(int i=0 ; i<n ; i++){
			String a = input.next();
			String b[] = a.split("");
			for(int j=0 ; j<n ; j++){
				house[i][j] = Integer.parseInt(b[j]);
			}
    	}
    	
    	Stack<point> stack = new Stack<point>();
    	point p;
    	LinkedList<Integer> result = new LinkedList();
    	int count=0;
    	for(int i=0 ; i<n ; i++){
    		for(int j=0 ; j<n ; j++){
    			if(house[i][j]!=1) continue;
    			count=0;
    			stack.push(new point(i,j));
    			while(!stack.isEmpty()){
    				p = stack.pop();
    				if(house[p.x][p.y]!=1) continue;
    				count++;
    				house[p.x][p.y]=2;
    				if(p.x>0 && house[p.x-1][p.y]==1) stack.push(new point(p.x-1, p.y));
    				if(p.x<n-1 && house[p.x+1][p.y]==1) stack.push(new point(p.x+1, p.y));
    				if(p.y>0 && house[p.x][p.y-1]==1) stack.push(new point(p.x, p.y-1));
    				if(p.y<n-1 && house[p.x][p.y+1]==1) stack.push(new point(p.x, p.y+1));
    			}
    			result.add(count);
    		}
    	}
    	System.out.println(result.size());
    	Collections.sort(result);
    	for(Iterator<Integer> iter=result.iterator() ; iter.hasNext() ;){
    		System.out.println(iter.next());
    	}
	}
	static class point{
		int x,y;
		public point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}




/*
 
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

*/
