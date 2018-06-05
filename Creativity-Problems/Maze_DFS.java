
import java.util.*;
public class Maze_DFS {
	private int R;
	private int [][]maze;
	private boolean [][]visit;
	private Stack<point5> stack;
	public Maze_DFS(int [][]maze, int R,boolean [][]visit){
		this.maze = maze;
		this.R = R;
		stack = new Stack<point5>();
		this.visit = visit;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int R = input.nextInt()+2;
		input.nextLine();
		
		String []in;
		int [][]maze = new int[R][R];
		boolean [][]visit = new boolean[R][R]; 
		
		for(int i=1 ; i<R-1 ; i++){				
			in = input.nextLine().split("");
			for(int j=1 ; j<R-1 ; j++){
				maze[i][j] = Integer.parseInt(in[j-1]);
			}
		}

	
		Maze_DFS test = new Maze_DFS(maze,R,visit);
		int i=1,j=1;

		test.search();		
	}
	
	public void search(){
		stack.push(new point5(1,1));
		int i=0,j=0;
		while(!stack.isEmpty()){
			point5 pp = stack.pop();
			i = pp.x; j = pp.y;
			if(i==R-2 && j==R-2) break;
			if(visit[i][j]==false){
				visit[i][j]=true;
				if(visit[i][j+1]==false && maze[i][j+1]==1) stack.push(new point5(i,j+1));
				if(visit[i][j-1]==false && maze[i][j-1]==1) stack.push(new point5(i,j-1));
				if(visit[i-1][j]==false && maze[i-1][j]==1) stack.push(new point5(i-1,j));
				if(visit[i+1][j]==false && maze[i+1][j]==1) stack.push(new point5(i+1,j));
			}
		}
		
		if(i==R-2 && j==R-2){
			System.out.println("Success");
		}
		else{
			System.out.println("Fail");
		}
		

	}
	
}

class point5{
	int x,y;
	public point5(int x, int y){
		this.x = x;
		this.y = y;
		
	}
}
/*
8
10000001
11100011
10111010
10101010
00011110
00010000
01111000
00001111
*/