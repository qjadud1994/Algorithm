package BFS_DFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_7576 {				//tomato 2Dimensions -> BFS

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int [][]table = new int[m][n];
		
		Queue<point> queue = new LinkedList<point>();
		int result=0, total=m*n, count=0, New=0;		//total은 전체 토마토수
		for(int i=0 ; i<m ; i++){
			for(int j=0 ; j<n ; j++){
				table[i][j] = input.nextInt();
				if(table[i][j]==1) {queue.add(new point(i,j)); New++; }	//익은 토마토면 queue에 넣기
				else if(table[i][j]==-1) total--;			//빈 상자이면 전체 토마토수에서 빼주기
			}
		}
		if(New == total) {System.out.println("0"); return;}		//New는 최근에 익은 토마토 수
		int Done = New;
		point p;
		while(!queue.isEmpty()){
			count=New; New=0;					
			for(int i=0 ; i<count ; i++){		//최근에 익은 토마토 수만큼 이를 반복한다.
				p = queue.remove();
				if(p.x<m-1 && table[p.x+1][p.y]==0) { queue.add(new point(p.x+1,p.y)); table[p.x+1][p.y]=1; New++; Done++; }
				if(p.x>0 && table[p.x-1][p.y]==0) { queue.add(new point(p.x-1,p.y)); table[p.x-1][p.y]=1; New++; Done++; }
				if(p.y<n-1 && table[p.x][p.y+1]==0) { queue.add(new point(p.x,p.y+1)); table[p.x][p.y+1]=1; New++; Done++; }
				if(p.y>0 && table[p.x][p.y-1]==0) { queue.add(new point(p.x,p.y-1)); table[p.x][p.y-1]=1; New++; Done++; }
			}
			result++;							//하루가 지남
			if(Done==total) break;
		}
		if(Done==total) System.out.println(result);
		else System.out.println("-1");
	}
	static class point{
		int x,y;
		public point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

/*

6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

*/


