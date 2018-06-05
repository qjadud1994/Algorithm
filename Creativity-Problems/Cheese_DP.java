

import java.util.*;

public class Cheese_DP {

	private int[][]maze;
	private int R, C;
	
	
	public Cheese_DP(int [][]maze, int R, int C){
		this.maze = maze;
		this.R = R;
		this.C = C;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int R = input.nextInt();	//row
		int C = input.nextInt();	//col
		
		input.nextLine();
		String []in;
		int [][]maze = new int[R][C];
		
		for(int i=0 ; i<R ; i++){					
			in = input.nextLine().split("");
			for(int j=0 ; j<C ; j++){
				maze[i][j] = Integer.parseInt(in[j]);
			}
		}
		
		Cheese_DP test = new Cheese_DP(maze,R,C);
		test.count();
		System.out.println(test.get_cheese());
	}
	
	public void count(){
		for(int i=1 ; i<C ; i++){			
			maze[0][i] += maze[0][i-1];
			maze[i][0] += maze[i-1][0];
		}
		
		for(int i=1 ; i<R ; i++){				
			for(int j=1 ; j<C ; j++){
				maze[i][j] += Math.max(maze[i][j-1], maze[i-1][j]);
			}
		}
	}

	public int get_cheese(){
		return maze[R-1][C-1];
	}
}

/*
8
8
00100000
00000100
10000001
00001000
01010000
00000010
01001000
00000100
*/