
import java.util.*;

public class Ford_Fulkerson_Stack {

	public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int line = input.nextInt();
    	int n = input.nextInt();
    	int [][]flow = new int[n][n];
    	for(int i=0 ; i<line ; i++){
    		flow[input.nextInt()-1][input.nextInt()-1]=input.nextInt();
    	}

    	int S = 0, E = n-1;
    	int node,max_flow=0,min=99999;
    	int p,k;
//    	Queue<Integer> queue = new LinkedList();
    	Stack<Integer> stack = new Stack();

    	int []path = new int[n];			//寃쎈줈 異붿쟻
    	stack.push(S);						//S 遺??E源뚯? ?먯깋
    										// ?좊웾?꾨Ц??visit? ?섎?媛 ?녿떎
    	while (!stack.isEmpty()){
    		node = stack.pop();
    		if (node==E){					//E 源뚯? ?붿쑝硫?
    			k = E;
    			while(k!=S){				// ?ы깭 吏?섏삩 ?좊웾以?理쒖냼媛믪쓣 李얜뒗??-> min
    				if(min>flow[path[k]][k]) min=flow[path[k]][k];
    				k = path[k];
    			}
    			System.out.println(min);
    			k = E;
    			while(k!=S){				// ?ы깭 吏?섏삩 ?좊웾 紐⑤몢?먮떎 理쒖냼媛믪쓣 類??
    				flow[path[k]][k]-=min;
//    				flow[k][path[k]]+=min;
    				k = path[k];
    			}

    			max_flow += min;			// 理쒕? ?먮쫫??min留뚰겮 ?뷀븳??
    			min=99999;					// min?ㅼ떆 ?명똿
    			continue;					// E源뚯? 媛???ㅻⅨ湲?怨꾩냽 ?먯깋
    		}

			for(int i=0 ; i<n ; i++){
				if(flow[node][i]!=0) {		// ?좊웾??0???꾨땲硫?
					path[i]=node;			// 寃쎈줈 ???
					stack.push(i);			// 異붽?
				}

    		}
    	}

    	System.out.println("max = "+max_flow);

	}

}

/*

11 8
1 2 90
1 3 45
1 4 75
2 5 60
2 7 50
3 5 85
4 6 40
4 7 40
5 8 30
6 8 45
7 8 30


*/