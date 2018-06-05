
import java.util.*;

public class DFS {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int V = input.nextInt();
		int E = input.nextInt();
		int [][]matrix = new int[V][V];
		int start,end;
		for(int i=0 ; i<E ; i++){					
			start = input.nextInt()-1;
			end = input.nextInt()-1;
			matrix[start][end]=1;
			matrix[end][start]=1;
		}
		
		boolean []visited = new boolean[V];
		for(int i=0 ; i<V ; i++) visited[i] = false;	//모두 미방문으로
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);						//0번 노드부터 시작
		while(!stack.isEmpty()){
			int N = stack.pop();
			if(visited[N]==false){		//미방문 노드이면 -> 방문
				System.out.print((N+1)+"->");
				visited[N]=true;		//방문 표시
				for(int i=0 ; i<V ; i++){	//이 노드와 연결되어 있는 노드 모두를 push
					if(matrix[N][i]==1){
						stack.push(i);
					}
				}	
			}
		}
		
	}
}


/*
 
8 11
1 2
1 6
1 8
2 3
2 5
2 6
3 4
3 5
4 5
6 7
6 8
  
*/ 
