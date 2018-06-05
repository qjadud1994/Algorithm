
import java.util.*;
								//https://www.acmicpc.net/problem/3116
public class Bio {
	private int [][]board;
	
	public Bio(){
		
		board = new int[30][30];
		for(int i=0 ; i<30;i++){
			for(int j=0 ; j<30 ; j++){
				board[i][j]=0;
			}
		}
	}
	
	public void setFirst(int []x){
		x[0] += 15;
		x[1] += 15;
		board[x[0]][x[1]] = 1;
	}
	
	public void move(int []x, int d){
		//x += 15; y+=15;
		--board[x[0]][x[1]];
		if(d==1){  ++board[--x[0]][++x[1]];}
		else if(d==2){  ++board[x[0]][++x[1]]; }
		else if(d==3){  ++board[++x[0]][++x[1]]; }
		else if(d==4){  ++board[++x[0]][x[1]]; }
		else if(d==5){  ++board[++x[0]][--x[1]]; }
		else if(d==6){  ++board[x[0]][--x[1]]; }
		else if(d==7){  ++board[--x[0]][--x[1]]; }
		else if(d==8){  ++board[--x[0]][x[1]]; }
	}
	
	public int findmax(){
		int max=board[0][0];
		for(int i=0 ; i<30;i++){
			for(int j=0 ; j<30 ; j++){
				if(board[i][j] >= max) max = board[i][j];
			}
		}
		return max;
	}
	
	public int getData(int x, int y){
		return board[x][y];
	}
	
	public void swap(int x, int y){
		--x; --y;
	}

	public void test(){
		int []a = new int[]{1,1};
		int []b = new int[]{-6,0};
		int []c = new int[]{-2,0};
		int []d = new int[]{1,7};
		int []e = new int[]{-6,4};
	
		setFirst(a);
		setFirst(b);
		setFirst(c);
		setFirst(d);
		setFirst(e);
		
		for(int i=1 ; i<5 ; i++){
			move(a,1);
			move(b,3);
			move(c,2);
			move(d,7);
			move(e,4);
			System.out.println("time : "+i);
			System.out.println(" / "+a[0]+", "+a[1]+"  "+getData(a[0],a[1]));
			System.out.println(" / "+b[0]+", "+b[1]+"  "+getData(b[0],b[1]));
			System.out.println(" / "+c[0]+", "+c[1]+"  "+getData(c[0],c[1]));
			System.out.println(" / "+d[0]+", "+d[1]+"  "+getData(d[0],d[1]));
			System.out.println(" / "+e[0]+", "+e[1]+"  "+getData(e[0],e[1]));
		}
		
	}
	
	
	public static void main(String []args){
		Bio bac = new Bio();
		bac.test();
		
	}
}