package BFS_DFS;

import java.util.*;
public class Baekjoon_7562 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testcase = input.nextInt();
		int chess[][] = new int[2][2];
		for(int i=0 ; i<testcase ; i++){
			int n = input.nextInt();
			for(int j=0 ; j<2 ; j++){
				chess[j][0]=input.nextInt();
				chess[j][1]=input.nextInt();
			}
			System.out.println(solution(n,chess));
		}
	}
	static int dx[] = {-2,-1,1,2,2,1,-1,-2};
	static int dy[] = {1,2,2,1,-1,-2,-2,-1};
	static int solution(int n, int [][]chess){
		boolean visit[][] = new boolean[n][n];
		Queue<point> queue = new LinkedList<point>();
		queue.add(new point(chess[0][0], chess[0][1],0));
		while(!queue.isEmpty()){
			point p = queue.remove();
			if(p.x==chess[1][0] && p.y==chess[1][1]) return p.c;
			if(!visit[p.x][p.y]){
				visit[p.x][p.y]=true;
				for(int i=0 ; i<8 ; i++){
					int kx=p.x+dx[i];   int ky=p.y+dy[i];
					if(kx<0 || ky<0 || kx>n-1 || ky>n-1) continue;
					if(!visit[kx][ky]) queue.add(new point(kx,ky,p.c+1));
				}
			}
		}
		return 0;
	}
	static class point{
		int x,y,c;
		public point(int x, int y,int c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}

/*

3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1

*/