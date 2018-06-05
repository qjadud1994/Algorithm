package BFS_DFS;
import java.util.*;

public class Baekjoon_1012 {					//유기농배추 -> DFS

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		for(int test=0 ; test<testcase ; test++){
	    	int m = input.nextInt();
	    	int n = input.nextInt();
	    	int [][]table = new int[m][n];
	    	int cabbage = input.nextInt();
	    	for(int i=0 ; i<cabbage ; i++){
	    		table[input.nextInt()][input.nextInt()]=1;
	    	}
	    	
	    	boolean [][]visit = new boolean[m][n];
	    	
	    	Stack<point> stack = new Stack<point>();
	    	int count=0;
	    	
	    	for(int i=0 ; i<m ; i++){
	    		for(int j=0 ; j<n ; j++){
	    			if(table[i][j]!=1 || visit[i][j]==true) continue;
	    			count++;
					stack.push(new point(i,j));
					while(!stack.isEmpty()){
						point p = stack.pop();
						if(visit[p.x][p.y]==false){
							visit[p.x][p.y]=true;
							if(p.x>0 && table[p.x-1][p.y]==1) stack.push(new point(p.x-1,p.y));
							if(p.x<m-1 && table[p.x+1][p.y]==1) stack.push(new point(p.x+1,p.y));
							if(p.y<n-1 && table[p.x][p.y+1]==1) stack.push(new point(p.x,p.y+1));
							if(p.y>0 && table[p.x][p.y-1]==1) stack.push(new point(p.x,p.y-1));
						}
					}
	    		}
	    	}
	    	System.out.println(count);
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



