import java.util.*;
 
public class SCC {
	static int V,E,result;
	static boolean check[], check2[];
	static LinkedList<Integer> r1[], r2[], out[];
	static Stack<Integer> stack;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		V = input.nextInt();			//노드
		E = input.nextInt();			//간선
		check = new boolean[V+1];		//정방향 그래프 방문 노드 확인
		check2 = new boolean[V+1];		//역방향 그래프 방문 노드 확인
		
		r1 = new LinkedList[V+1];
		r2 = new LinkedList[V+1];
		out = new LinkedList[V+1];
		stack = new Stack<Integer>();		//DFS 스택 -> 정방향 DFS탐색 순서대로 넣기 위함
		for(int i=0 ; i<=V ; i++){
			r1[i] = new LinkedList<Integer>();		//정방향 그래프
			r2[i] = new LinkedList<Integer>();		//역방향 그래프
			out[i] = new LinkedList<Integer>();		//연결 요소 저장 리스트
		}
		
		for(int i=0 ; i<E ; i++){
			int x = input.nextInt();		//정, 역방향 그래프 세팅
			int y = input.nextInt();
			r1[x].add(y);  r2[y].add(x);
		}
		
		for(int i=0 ; i<V ; i++){	//정방향 그래프 먼저 DFS수행
			if(!check[i]) DFS(i);	//모든 노드에 대해서
		}

		result=-1;					//연결 묶음 개수
		while(!stack.isEmpty()){	//가장 나중에 탐색된 노드부터 역방향DFS탐색
			int x = stack.pop();
			if(!check2[x]){
				DFS2(x,++result);	//result는 연결 요소를 저장하기 위해 수행될떄마다 추가
			}
		}
				
		System.out.println(result);
		for(int i=0 ; i<result ; i++){
			Collections.sort(out[i]);
			for(int a : out[i]){
				System.out.print(a+" ");
			}
			System.out.println("-1");
		}
	}
	static void DFS(int x){			//재귀를 이용한 정방향 DFS
		check[x]=true;
		for(int a : r1[x]){
			if(!check[a]) DFS(a);
		}
		stack.push(x);				//탐색 완료 시간이 가장 짧은 노드부터 push
	}
	static void DFS2(int x,int w){	//재귀를 이용한 역방향 DFS
		check2[x]=true;
		for(int a : r2[x]){
			if(!check2[a]) DFS2(a,w);
		}
		out[w].add(x);			//연결 리스트 표현을 위한 list에 저장
	}

}

/* 

7 9
1 4
4 5
5 1
1 6
6 7
2 7
7 3
3 7
7 2

*/