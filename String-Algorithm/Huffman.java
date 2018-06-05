import java.util.*;

public class Huffman {
	static PriorityQueue<Node> queue;
	
	public static void main(String[] args) {
		HashMap<Character,Integer> dic = new HashMap<Character, Integer>();
		String text = "VISION QUESTION ONION CAPTION GRADUATION EDUCATION";
		
		for(int i=0 ; i<text.length() ; i++){		//빈도수 측정
			char temp = text.charAt(i);
			if(dic.containsKey(temp))			//겹치면
				dic.put(temp, dic.get(temp)+1);		//개수만 증가
			else{								//안겹치면
				dic.put(temp, 1);					//문자와 개수를 증가
			}
		}
		
								//priorityQueue(int 용량, comparator -> 정렬 기준) 
		queue = new PriorityQueue<Node>(100,new FrequencyComparator());
		int number=0;
		
		for(Character c : dic.keySet()){		//key -> 문자들
			Node temp = new Node();			//새로운 노드를 만들고 세팅
			temp.character = c;
			temp.frequency = dic.get(c);
			queue.add(temp);				//빈도수 순으로 정렬 add
			number++;
		}
		
		Node root = huffmanCoding(number);
		traversal(root,new String());
	}
	
	static void traversal(Node n, String s){
		if(n==null) return;
		
		traversal(n.right, s+"1");		//왼쪽이면 1
		traversal(n.left, s+"0");		//오른쪽이면 0을 부여
		if(n.character !='\0'){			//탐색 노드의 char가 있으면
			System.out.println(n.character+":"+s);		//해당 이진 코드를 출력한다.
		}
	}
	
	static Node huffmanCoding(int n){		//n은 총 노드수
		for(int i=0 ; i<n-1 ; i++){
			Node z = new Node();			//합쳐질 부모 노드
			z.left = queue.poll();			//빈도수 가장 적은 노드
			z.right = queue.poll();			//그 다음으로 적은 노드
			z.frequency = z.right.frequency + z.left.frequency;
			queue.add(z);					//두 노드의 합을 새로 추가한다.
		}
		return queue.poll();				//huffman coding 트리를 만들었다. -> root노드를 리턴
	}
}

class Node{
	char character;
	int frequency;
	Node left,right;
}

class FrequencyComparator implements Comparator<Node>{
	public int compare(Node a, Node b){
		return a.frequency - b.frequency ;
	}
}