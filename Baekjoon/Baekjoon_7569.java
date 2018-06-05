package BFS_DFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_7569 {				//tomato 3Dimensions -> BFS

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int h = input.nextInt();
		int [][][]tomato = new int[m][n][h];
		
		Queue<point> queue = new LinkedList<point>();
		int result=0, total=m*n*h, count=0, New=0;
		for(int k=0 ; k<h ; k++){
			for(int i=0 ; i<m ; i++){
				for(int j=0 ; j<n ; j++){
					tomato[i][j][k] = input.nextInt();
					if(tomato[i][j][k]==1) {queue.add(new point(i,j,k)); New++; }
					else if(tomato[i][j][k]==-1) total--;
				}
			}
		}
		int x[] = {1,-1,0,0,0,0};			//if문 여섯번쓰는대신 for문으로 해결하려고
		int y[] = {0,0,1,-1,0,0};
		int z[] = {0,0,0,0,1,-1};
		if(New == total) {System.out.println("0"); return;}
		int Done = New;
		point p;
		while(!queue.isEmpty()){
			count=New; New=0;
			for(int i=0 ; i<count ; i++){
				p = queue.remove();
				for(int j=0 ; j<6 ; j++){
						if(p.x+x[j]>=m-1 || p.x+x[j]<=0 || p.y+y[j]>=n-1 || p.y+y[j]<=0 || p.z+z[j]>=h-1 || p.z+z[j]<=0) continue;
						if(tomato[p.x+x[j]][p.y+y[j]][p.z+z[j]]==0){
							queue.add(new point(p.x+x[j], p.y+y[j], p.z+z[j]));
							tomato[p.x+x[j]][p.y+y[j]][p.z+z[j]]=1;
							New++;
							Done++;
						}
				}
			}
			result++;
			if(Done==total) break;
		}
		if(Done==total) System.out.println(result);
		else System.out.println("-1");
	}
	static class point{
		int x,y,z;
		public point(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}

/*

5 3 1
0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1

*/


