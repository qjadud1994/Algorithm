package Dijkstra;

import java.util.*;
public class Baekjoon_4485 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testcase=1;
		while(true){
			int N = input.nextInt();
			if(N==0) break;
			System.out.print("Problem "+(testcase++)+": ");
			int [][]D = new int[N][N];
			for(int i=0 ; i<N ; i++){
				for(int j=0 ; j<N ; j++){
					D[i][j] = input.nextInt();	
				}
			}
			int []dx = {-1,1,0,0};
			int []dy = {0,0,-1,1};
			PriorityQueue<point> PQ = new PriorityQueue<point>();	//PQ를 이용한 BFS 
			boolean visit[][] = new boolean[N][N];					
			
			int x,y,money=0;
			PQ.add(new point(0,0,D[0][0]));
			visit[0][0]=true;
			
			while(!PQ.isEmpty()){			//BFS -> 최소 금액인 노드 순으로 탐색
				point p = PQ.remove();
				x = p.x; y = p.y; money = p.money;
				if(x==N-1 && y==N-1) break;		//발견되면 끝 -> 그게 최소 루피값
				
				for(int i=0 ; i<4 ; i++){
					int kx = x+dx[i];
					int ky = y+dy[i];
					if(kx<0 || ky<0 || kx>N-1 || ky>N-1 || visit[kx][ky]) continue;
					visit[kx][ky]=true;
					PQ.add(new point(kx,ky,money+D[kx][ky]));
				}
			}
			System.out.println(money);
		}
	}
	
	static class point implements Comparable<point>{
		int x,y,money;
		public point(int x, int y, int money){
			this.x = x;
			this.y = y;
			this.money = money;
		}
		@Override
		public int compareTo(point a){	//this가 큰게 1이면 min heap
			return this.money>a.money ? 1 : -1;
		}
	}
}

/*

3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0

*/ 
