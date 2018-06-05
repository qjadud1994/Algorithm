package Dijkstra;

import java.util.*;
public class Baekjoon_1261 {					//최소로 벽 부수고 미로 탈출
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		
		int [][]D = new int[M][N];
		for(int i=0 ; i<M ; i++){
			String a = input.next();
			String b[] = a.split("");
			for(int j=0 ; j<N ; j++){
				D[i][j] = Integer.parseInt(b[j]);	
			}
		}
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		PriorityQueue<point> PQ = new PriorityQueue<point>();	//PQ를 이용해 벽을 부수는 횟수가 
		boolean visit[][] = new boolean[M][N];					//적은 쪽으로만 이동
		
		int x,y,count=0;
		PQ.add(new point(0,0,0));
		visit[0][0]=true;
		
		while(!PQ.isEmpty()){			//BFS -> count가 적은 곳 우선으로 탐색 -> 출구가 발견되면 그게 답
			point p = PQ.remove();
			x = p.x; y = p.y; count = p.count;
			if(x==M-1 && y==N-1) break;
			
			for(int i=0 ; i<4 ; i++){
				int kx = x+dx[i];
				int ky = y+dy[i];
				if(kx<0 || ky<0 || kx>M-1 || ky>N-1 || visit[kx][ky]) continue;
				visit[kx][ky]=true;
				if(D[kx][ky]==0) PQ.add(new point(kx,ky,count));	//길이 있을때
				else PQ.add(new point(kx,ky,count+1));			//막혀 있을 때 -> count추가
			}
		}
		System.out.println(count);
	}
	
	static class point implements Comparable<point>{
		int x,y,count;
		public point(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
		@Override
		public int compareTo(point a){	//this가 큰게 1이면 min heap
			return this.count>a.count ? 1 : -1;
		}
	}
}

/*

3 3
011
111
110

6 6
001111
010000
001111
110001
011010
100010

*/ 
