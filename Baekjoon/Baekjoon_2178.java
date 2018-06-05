package BFS_DFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2178 {					//미로탐색 -> BFS	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	int m = input.nextInt();
    	int n = input.nextInt();
    	int [][]maze = new int[m][n];
    	for(int i=0 ; i<m ; i++){
			String a = input.next();
			String b[] = a.split("");
			for(int j=0 ; j<n ; j++){
				maze[i][j] = Integer.parseInt(b[j]);
			}
    	}
    	boolean visit[][] = new boolean[m][n];
    	point p;
    	Queue<point> queue = new LinkedList<point>();
    	queue.add(new point(0,0,1));
    	
    	while(!queue.isEmpty()){
    		p = queue.remove();
    		if(p.x==m-1 && p.y==n-1){
    			System.out.println(p.count);
    			break;
    		}
    		if(!visit[p.x][p.y]){
    			visit[p.x][p.y] = true;
    			if(p.x>0 && maze[p.x-1][p.y]==1) queue.add(new point(p.x-1, p.y, p.count+1));
    			if(p.x<m-1 && maze[p.x+1][p.y]==1) queue.add(new point(p.x+1, p.y, p.count+1));
    			if(p.y>0 && maze[p.x][p.y-1]==1) queue.add(new point(p.x, p.y-1, p.count+1));
    			if(p.y<n-1 && maze[p.x][p.y+1]==1) queue.add(new point(p.x, p.y+1, p.count+1));
    		}
    	}
	}
	
	static class point{
		int x,y,count;
		public point(int x, int y,int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}




/*
 
4 6
110110
110110
111111
111101

*/
