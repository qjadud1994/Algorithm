import java.util.LinkedList;
import java.util.Scanner;

public class KMP {

	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		String S = "abc abcdab abcdabcdabde";
		String W = "abcdabd";

		int n = S.length();		//전체 문자
		int m = W.length();		//비교할 문자
		
		int []fail = new int[100];
		
		set_fail(fail,W);		//실패 함수 세팅
		
		LinkedList<Integer> result = new LinkedList();		//일치 지점 저장 리스트
		
		for(int i=0, j=0 ; i<n ; i++){
			while(j>0 && S.charAt(i)!=W.charAt(j)) j=fail[j-1];		//첫글자 i와 j가 불일치하면
																	//실패함수를 계속 따라간다. 
																	//i=10 / j=6 일때보면 j=fail[5]=2 로 가는데
																	//ab다음의 문자가 서로 불일치 해서 j=0으로 된다.
																	//반면 i=17 / j=6 일때 보면 j=fail[5]=2 로 가는데
																	//ab다음 문자가 서로 c로 일치해서 while문을 나가고 새로 비교한다.
			if(S.charAt(i) == W.charAt(j)){			//글자가 일치하면
				if(j == m-1){			//일치 패턴 찾음
					result.add(i-m+2);
					j = fail[j];		//또 내부 패턴에 겹칠수 있으므로 j를 실패한것 처럼 이동
				}
				else j++;				//다음 글자 비교
			}
		}
		
		System.out.println(result.size()+ " find!");
		for(int i:result){
			System.out.println("index is "+i);
		}
	}
	
	static void set_fail(int []fail, String W){
		int M = W.length();							//비교할 문자 W의 실패 함수 세팅
		for(int i=1 , j=0; i<M ; i++){				//반복되는 패턴의 최대 길이를 넣는다.
			while(j>0 && W.charAt(i) != W.charAt(j)) j=fail[j-1];
			if(W.charAt(i)==W.charAt(j)) fail[i] = ++j;
		}
	}
	
	static void print(int []fail){
		for(int i:fail){
			System.out.print(i+" ");
		}
		System.out.println("");
	}
}
