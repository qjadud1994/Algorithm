import java.util.*;
public class pattern_matching {

	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		Queue<Character> memory = new LinkedList<Character>();
		
		String t = "CDAABCAAABDDACDABDCAAAABDD";		//여기에서 pattern을 matching한다.
		
		//패턴 매칭 장치 표현 배열
		char []ch = {' ','A',' ','B',' ',' ','A','C','D',' '};
		int []next1 = {5,2,3,4,8,6,7,8,9,0};
		int []next2 = {5,2,1,4,8,2,7,8,9,0};
		
		int index = 0;
		int scan=-1;
		char current = t.charAt(index);		//비교할 인덱스
		
		int n = t.length();
		
		deque.add(scan);
		deque.addFirst(next1[0]);		//초기 deque 세팅
		
		while(!deque.isEmpty() && index < n){
//			print(deque);
			int pop = deque.peekFirst();		//첫번째 원소 peek (삭제x)
			
			if(pop == scan && deque.size() != 1){			//-1을 만났을 때( 데크에 -1만 있는게 아닐때)
				for(int k=1 ; k<deque.size() ; k++){		//한 글자 매칭 성공 (scan 뒤집기)
					deque.addFirst(deque.removeLast());		//뒷 원소를 앞으로 이동
				}
				System.out.println("matching -> "+current);
				memory.add(current);						//매칭된 글자 저장
				if(index!=n-1) current = t.charAt(++index);	//t의 비교할 인덱스를 다음으로 옮긴다.
				continue;
			}
			else if(pop == scan && deque.size()==1){		//데크에 -1만 있을때 -> 매치 실패
				System.out.println("only scan "+current);
				if(index==n-1) break;				//다음 인덱스가 없으면 매치 실패로 끝낸다.
				current = t.charAt(++index);		//다음 인덱스로
				deque.addFirst(next1[0]);			//새로운 시작
				removeall(memory);					//memory도 초기화
				continue;
			}
			else if(pop == 0){							//0을 만났을때 -> 매치 성공
				System.out.println("Success Match");
				printmatching(memory);					//matching된 패턴을 출력한다.
				if(index==n-1) break;					//마지막 인덱스라면 종료
				while(deque.size()!=1){		
					deque.removeFirst();				//scan을 남기고 모두 지운다
				}							
				deque.addFirst(next1[0]);				//새로운 시작
				continue;
			}

//검사 끝------------------------------------------------------------------------------			
			
			pop = deque.removeFirst();		//위에서 검사가 끝났으므로, 앞의 원소를 제거한다.
			
			if(ch[pop]==' '){				//null character
				deque.addFirst(next1[pop]);
				if(next1[pop]!=next2[pop]) deque.addFirst(next2[pop]);	//같으면 하나만
			}
			else if(ch[pop]==current){				//matching
				deque.addLast(next1[pop]);			
			}										
		}											//불일치면 아무것도 안함
		
//------------------whlie문 종료-----------------------------------------------------
		System.out.println("End Matching");
	}
	
	static void print(Deque<Integer> deque){
		for(Iterator<Integer> iter = deque.iterator() ; iter.hasNext() ;){
			System.out.print(iter.next()+" ");
		}
		System.out.println("");
	}
	
	static void printmatching(Queue<Character> memory){
		while(!memory.isEmpty()){
			System.out.print(memory.poll());
		}
		System.out.println("");
	}
	
	static void removeall(Queue<Character> memory){
		while(!memory.isEmpty()){
			memory.poll();
		}
	}

}
