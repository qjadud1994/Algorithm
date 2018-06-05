import java.util.LinkedList;
import java.util.Scanner;

public class KMP_2 {

	public static void main(String[] args) {
		//Scanner input = new Scanner(System.in);
		String T = "abc abcdab abcdabcdabde";
		String P = "abcdabd";
		T = "ababababcababababcaabbabababcaab";
		P = "abababca";

		System.out.println(KMP(P,T));
		
	}
	
	static int KMP(String P, String T){
		int i,j;
		int n = T.length();		//전체 문자
		int m = P.length();		//비교할 문자
		int []next = new int[m];
		initNext(next, P);		//next 함수 세팅
		print(next);
		for(i=0, j=0 ; i<n && j<m ; i++,j++){
			while(j>=0 && T.charAt(i)!=P.charAt(j)) j=next[j];		//첫글자 i와 j가 불일치하면
			//while문 벗어남 = 일치 -> 다음문자 비교 (i와 j +1)
			//P가 끝까지 도달하였으면 (j==m) for문을 벗어난다. -> 즉 찾아서 도중에 나오거나 끝까지 패턴을 못찾을 경우
		}
		
		if(j==m) return i-m;			//찾은 경우, index를 리턴
		else return i;					//못찾은 경우
	}
	
	static void initNext(int []next, String P){		//FSM
		int M = P.length();							//비교할 문자 W의 실패 함수 세팅
		next[0]=-1;
			
		for(int i=0 , j=-1; i<M ; i++,j++){				//반복되는 패턴의 최대 길이를 넣는다.
			if(j>=0 && P.charAt(i) == P.charAt(j)) next[i] = next[j];
			else next[i]=j;
			while(j>=0 && P.charAt(i) != P.charAt(j)) j=next[j];
		}
	}
	
	static void print(int []fail){
		for(int i:fail){
			System.out.print(i+" ");
		}
		System.out.println("");
	}
}
