package BFS_DFS;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_1987 {				//알파벳 문제 -> 재귀 이해하자!
	static boolean visit[];
	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};
	static int board[][];
	static int R, C, max=0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		R = input.nextInt();
		C = input.nextInt();
	
		board = new int[R][C];
		for(int i=0 ; i<R ; i++){
			String in = input.next();
			for(int j=0 ; j<C ; j++){
				board[i][j] = in.charAt(j);		//아스키코드 값으로 세팅
			}
		}
		visit = new boolean[26];				//대문자만 있으므로 26개
		DFS(0,0,1);

		System.out.println(max);
	}
	static void DFS(int x, int y, int c){
		max = Math.max(max, c);				//최대값 세팅
		if(max>=26) return;					//대문자 이므로 최대 26번이다.
		visit[board[x][y]-65]=true;			//현재 있는 곳 방문 표시
		for(int i=0 ; i<4 ; i++){
			int kx = x+dx[i];  int ky = y+dy[i];
			if (kx < 0 || ky < 0 || kx>R-1 || ky>C-1) continue;
			if(!visit[board[kx][ky]-65]) DFS(kx,ky,c+1);	//미방문이면 재귀 -> 깊이 탐색
		}
		visit[board[x][y]-65]=false;		//요게 중요!!
											//이전에 잘못된 경로에서 표시했던 visit들을 무효화 시킬수 있다.
											//maze에서 잘못된 길 탐색 되돌아가는 것을 이것으로 할 수 있다.
	}
}

/*

2 4
CAAB
ADCB

3 6
HFDFFB
AJHGDH
DGAGEH
*/


