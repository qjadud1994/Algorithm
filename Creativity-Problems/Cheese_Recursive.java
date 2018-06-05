

import java.util.Scanner;

public class Cheese_Recursive {

	private int[][]maze;
	private int R, C;
	private int[][]table;
	
	public Cheese_Recursive(int [][]maze, int R, int C){
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
		
		for(int i=0 ; i<R ; i++){					//?�렬??Y ?�는 N???�는 ?��? 같�? ?�업
			in = input.nextLine().split("");
			for(int j=0 ; j<C ; j++){
				maze[i][j] = Integer.parseInt(in[j]);
			}
		}
		
		Cheese_Recursive test = new Cheese_Recursive(maze,R,C);
		test.count(0, 0);
		System.out.println(test.get_cheese());
	}
	
	public void count(int i, int j){
		if(i==R-1 && j==C-1) return ;
		else{
			if(maze[i][j]==1) table[i][j]++;
			
			if(i<R-1 && (table[i+1][j] <= table[i][j])) {
				table[i+1][j]=table[i][j]; count(i+1,j);
			}
			
			if(j<C-1 && (table[i][j+1] <= table[i][j])){
				table[i][j+1]=table[i][j]; count(i,j+1);
			}
		}
	}
	public int get_cheese(){
		return table[R-1][C-1];
	}
}

/*
8
9
001000000
000001000
100000010
000010000
010100000
000000100
010010000
000001000
*/

/*
6
7
0000010
0010000
0000010
0010000
1000100
0000000
*/