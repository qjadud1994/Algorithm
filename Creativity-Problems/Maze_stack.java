
import java.util.*;
public class Maze_stack {
	private int R;
	private int [][]maze;
	private boolean [][]mark;
	private Stack<String> a;
	public Maze_stack(int [][]maze, int R,boolean [][]mark){
		this.maze = maze;
		this.R = R;
		a = new Stack();
		this.mark = mark;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int R = input.nextInt()+2;
		input.nextLine();
		String []in;
		int [][]maze = new int[R][R];
		boolean [][]mark = new boolean[R][R]; 
		
		for(int i=1 ; i<R-1 ; i++){					//?\89렬??Y ?\90는 N???\A3는 ?\84\EC? 같\EC? ?\91업
			in = input.nextLine().split("");
			for(int j=1 ; j<R-1 ; j++){
				maze[i][j] = Integer.parseInt(in[j-1]);
				mark[i][j]=false;
			}
		}
		
		for(int c=0 ; c<R ; c++){		//?\8C두리에??모두??0???\A3는??
			maze[R-1][c] = 0;
			maze[0][c] = 0;
			maze[c][R-1] = 0;
			maze[c][0] = 0;	
			
		}
	
		Maze_stack test = new Maze_stack(maze,R,mark);
		int i=1,j=1;

		test.search(i, j);		
	}
	
	public void search(int i, int j){

		while(!(i==R-2 && j==R-2)){
			mark[i][j] = true;
			while((!(i==1 && j==1)) && (maze[i+1][j]+maze[i-1][j]+maze[i][j-1]+maze[i][j+1])==1){
				a.pop(); 
				maze[i][j]=0;
				if(maze[i+1][j]==1) i++;
				else if(maze[i-1][j]==1) i--;
				else if(maze[i][j-1]==1) j--;
				else if(maze[i][j+1]==1) j++;
				
				System.out.println("Wrong way : "+i+" , "+j);
			}
			if(mark[i][j+1]==false && maze[i][j+1]==1) {a.push("E"); j++; System.out.println("E -> i,j = "+i+" , "+j);}
			else if(mark[i][j-1]==false && maze[i][j-1]==1) {a.push("W"); j--;System.out.println("W -> i,j = "+i+" , "+j);}
			else if(mark[i-1][j]==false && maze[i-1][j]==1) {a.push("N"); i--;System.out.println("N -> i,j = "+i+" , "+j);}
			else if(mark[i+1][j]==false && maze[i+1][j]==1) {a.push("S"); i++;System.out.println("S -> i,j = "+i+" , "+j);}
		}
		System.out.println("88출");
		
		Queue<String> u = new LinkedList();
		u.addAll(a);
		while(!u.isEmpty()){
			System.out.print(u.remove());
		}
		

	}
	
	public void print(){
		for(int i=0 ; i<R ; i++){
			for(int j=0 ; j<R ; j++){
				System.out.print(maze[i][j]);
			}
			System.out.println(" ");
		}
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