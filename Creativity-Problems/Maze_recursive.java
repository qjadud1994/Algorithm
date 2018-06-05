
import java.util.*;
public class Maze_recursive {
	private int R;
	private int [][]maze;
	private boolean [][]mark;
	private Stack<String> a;
	public Maze_recursive(int [][]maze, int R,boolean [][]mark){
		this.maze = maze;
		this.R = R;
		this.mark = mark;
		a = new Stack();
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
		 
		Maze_recursive test = new Maze_recursive(maze,R,mark);
		int i=1,j=1;		
		test.search(i, j);
		System.out.println("\n");
		test.print();
	}
	
	public void search(int i, int j){
		if(i==R-2 && j==R-2) return;

		mark[i][j] = true;
		if(mark[i][j+1]==false && maze[i][j+1]==1) { 
			a.add("E");
			System.out.println("E -> i,j = "+i+" , "+j);
			search(i,j+1);
		}
		if(mark[i][j-1]==false && maze[i][j-1]==1) { 
			a.add("W");
			System.out.println("W -> i,j = "+i+" , "+j);
			search(i,j-1);
		}
		if(mark[i-1][j]==false && maze[i-1][j]==1) { 
			a.add("N");
			System.out.println("N -> i,j = "+i+" , "+j);
			search(i-1,j);
		}
		if(mark[i+1][j]==false && maze[i+1][j]==1) { 
			a.add("S");
			System.out.println("S -> i,j = "+i+" , "+j);
			search(i+1,j);
		}
		
		if ((!(i==1 && j==1)) && (maze[i+1][j]+maze[i-1][j]+maze[i][j-1]+maze[i][j+1])==1){	//back
			maze[i][j]=0;
			System.out.println("Wrong way : "+i+" , "+j);
			a.pop();
		}
	}
	
	public void print(){
		Queue<String> d = new LinkedList();
		d.addAll(a);
		while(!d.isEmpty()){
			System.out.print(d.remove());
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