

import java.util.Scanner;

public class Cheese_Trap_Recursive {

	private int[][]maze;
	private int R, C;
	private int[][]table;
	
	public Cheese_Trap_Recursive(int [][]maze, int R, int C){
		this.maze = maze;
		this.R = R;
		this.C = C;
		table = new int[R][C];
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int R = input.nextInt();	//row
		int C = input.nextInt();	//col
		
		input.nextLine();
		String []in;
		int [][]maze = new int[R][C];
		
		for(int i=0 ; i<R ; i++){					//?\89렬??Y ?\90는 N???\A3는 ?\84\EC? 같\EC? ?\91업
			in = input.nextLine().split("");
			for(int j=0 ; j<C ; j++){
				maze[i][j] = Integer.parseInt(in[j]);
			}
		}
		
		Cheese_Trap_Recursive test = new Cheese_Trap_Recursive(maze,R,C);
		test.count(0, 0);
		System.out.println(test.get_cheese());
	}
	
	public void count(int i, int j){
		if(i==R-1 && j==C-1) return ;
		if(maze[i][j]==2) {table[i][j]=0; return ;}
		if(maze[i][j]==1) table[i][j]++;
		
		if(i<R-1 && (table[i+1][j] <= table[i][j])) {
			table[i+1][j]=table[i][j]; count(i+1,j);
		}
			
		if(j<C-1 && (table[i][j+1] <= table[i][j])){
			table[i][j+1]=table[i][j]; count(i,j+1);
		}
		
	}

	public int get_cheese(){
		return table[R-1][C-1];
	}
}

/*
6
7
1000000
1120000
0210000
0011000
0002000
0001110
*/