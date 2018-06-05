package BFS_DFS;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_11403 {					//경로 찾기 -> DFS

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	LinkedList<Integer> list[] = new LinkedList[n];
    	
    	for(int i=0 ; i<n ; i++){
    		list[i] = new LinkedList<Integer>();
    		for(int j=0 ; j<n ; j++){
    			int a = input.nextInt();
    			if(a==1) list[i].add(j);
    		}
    	}
    	
    	int [][]result = new int[n][n];
    	boolean []visit = new boolean[n];
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	int pop;
    	for(int i=0 ; i<n ; i++){
    		visit = new boolean[n];
    		for(Iterator<Integer> k=list[i].iterator() ; k.hasNext() ; ){
				stack.push(k.next());
			}
    		
			while(!stack.isEmpty()){
				pop = stack.pop();
				if(visit[pop]==false){
					visit[pop]=true;
					result[i][pop]=1;
					for(Iterator<Integer> k=list[pop].iterator() ; k.hasNext() ; ){
						stack.push(k.next());
					}
				}
			}	
    	}
    	
    	for(int i=0 ; i<n ; i++){
    		for(int j=0 ; j<n ; j++){
    			System.out.print(result[i][j]+" ");
    		}
    		System.out.println();
    	}
	}

}

