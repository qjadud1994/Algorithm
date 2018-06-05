
import java.util.*;
public class Map_coloring {
	private int N,Color;
	private int []color_map;
	private boolean [][]mark;
	public Map_coloring(int N, int Color, boolean [][]mark){
		this.N = N;
		this.Color = Color;
		this.mark = mark;
		color_map = new int[N];
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int Color = input.nextInt();
		input.nextLine();
		String []in;
		
		boolean [][]mark = new boolean[N][N]; 
		
		for(int i=0 ; i<N ; i++){			
			in = input.nextLine().split("");
			for(int j=0 ; j<N ; j++){
				if(Integer.parseInt(in[j]) == 1) mark[i][j] = true;
			}
		}
		Map_coloring test = new Map_coloring(N,Color,mark);
		test.search(0);
		System.out.println(test.ispossible());
	}
	
	public void search(int node){		//using recursive
		for(int color = 1 ; color<=Color ; color++){	
			if(node < N && vaild(node,color)){
				color_map[node] = color; 
				System.out.println(node+" 's color is : "+color);
				search(++node);
				break;
			}
		}
	}	
	
	/*		using While
	
	public void search(int node){
		while(node < N){
			for(int color = 1 ; color<=Color ; color++){	
				if(vaild(node,color)){
					color_map[node] = color; 
					System.out.println(node+" 's color is : "+color);
					break;
				}
			}
			node++;
		}
	}	
	*/
	public boolean vaild(int node, int color){
		for(int a= 0 ; a<N ; a++){
			if(mark[node][a]==true && color_map[a]==color) return false;
		}
		return true;
	}
	
	public boolean ispossible(){
		for(int i=0 ; i<N ; i++){
			if(color_map[i]==0) return false;
		}
		return true;
	}

}

/*
4
3
0111
1010
1101
1010
*/

/*
5
3
01110
10101
11011
10101
01110
*/