import java.util.*;

public class Kruskal {
	static int set[];
    public static void main(String args[]) throws Exception {   
    	Scanner input = new Scanner(System.in);
    	int V = input.nextInt();
    	int E = input.nextInt();
    	LinkedList<node> graph = new LinkedList<node>();
    	for(int i=0 ; i<E ; i++){		//출발노드, 도착노드, 가중치의 순으로된 node객체를 리스트에 넣는다.
    		graph.add(new node(input.nextInt()-1, input.nextInt()-1, input.nextInt()));
    	}

    	Collections.sort(graph, new Compareweight());		//가중치 오름차순으로 재정렬한다.
    	int ra,rb,sum=0;									//최소 가중치 노드부터 탐색하기 위해서
    	set = new int[V];							//사이클을 확인하기 위한 배열
    	for(int i=0 ; i<V ; i++) set[i]=i;			//인덱스에 해당하는 값을 노드 자신의 값을 가리키도록함
    	
    	for(node g : graph){			//최소 간선 노드부터 탐색
    		ra = find(g.x);
    		rb = find(g.y);			//각각 시작노드와 도착노드의 사이클을 검사
    		if(ra!=rb){				//같지 않다면, 즉 사이클이 없다면
    			set[ra]=rb;			//시작 노드의 set값을 도착 노드로 세팅하고
    			sum+=g.w;			//가중치의 합을 더한다.
    		}
    	}
    	System.out.println(sum);
    	
    }
    static int find(int i){
    	if(set[i]==i) return i;		//찾고자 하는 인덱스가 같다면 그냥 return
    	return set[i]=find(set[i]);		//인덱스가 다르다면 재귀 탐색 -> 그래프 탐색과 비슷하다.
    }
    
    static class Compareweight implements Comparator<node>{
    	@Override
    	public int compare(node a, node b){		//Collections의 sort를 사용하기 위한
    		return a.w-b.w;						//Comparator을 상속받은 클래스
    	}
    }
    
    static class node{							//그래프 표현을 위한 node 클래스
    	int x,y,w;								//출발노드, 도착노드, 가중치
    	public node(int x, int y, int w){
    		this.x = x;
    		this.y = y;
    		this.w = w;
    	} 	
    }
}




/*

6 9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8

*/