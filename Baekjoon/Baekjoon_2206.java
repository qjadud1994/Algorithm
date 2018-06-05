package BFS_DFS;
import java.util.*;

public class Baekjoon_2206 {					//벽 부수고 이동하기
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int [][]map = new int[m][n];
		
		for(int i=0 ; i<m ; i++){
			String a = input.next();
			String b[] = a.split("");
			for(int j=0 ; j<n ; j++){
				map[i][j]=Integer.parseInt(b[j]);
			}
		}
		int kx,ky,min=9999;
		boolean visit[][][] = new boolean[m][n][2];			//부수고 가는길[0], 안부수고 가는길[1] 로 나눠서
		Queue<point> queue = new LinkedList<point>();
		queue.add(new point(0,0,1,false));
		visit[0][0][1]=true;
		while(!queue.isEmpty()){
			point p = queue.remove();
			if(p.x==m-1 && p.y==n-1){
				if(min > p.c) min=p.c;
				continue;
			}
			for(int i=0 ; i<4 ; i++){
				kx=p.x+dx[i];  ky=p.y+dy[i];
				if(kx<0 || ky<0 || kx>m-1 || ky>n-1) continue;
				
				if(!p.sw && map[kx][ky]==0 && !visit[kx][ky][1]) {		//망치가 있고 , 길이 0이고, 이제 안부술 길 ->미방문일때
					queue.add(new point(kx,ky,p.c+1,false));
					visit[kx][ky][1]=true;
				}														//아래는 한번이라도 부수는게 있는 길 visit[][][0]
				else if(!p.sw && map[kx][ky]==1 && !visit[kx][ky][0]) {	//망치가 있고, 길이 1이고, 부술 길 ->미방문일때
					queue.add(new point(kx,ky,p.c+1,true));
					visit[kx][ky][0]=true;
				}
				else if(p.sw && map[kx][ky]==0 && !visit[kx][ky][0]) {	//망치가 없고, 길이 0이고, 부술길 ->미방문일때
					queue.add(new point(kx,ky,p.c+1,true));
					visit[kx][ky][0]=true;
				}
			}
		}
		if(min!=9999) System.out.println(min);
		else System.out.println("-1");
	}
	
	static class point{
		int x,y,c;
		boolean sw;
		public point(int x, int y,int c,boolean sw){
			this.x = x;
			this.y = y;
			this.c = c;
			this.sw = sw;
		}
	}
}

/*

6 4
0100
1110
1000
0000
0111
0000

*/