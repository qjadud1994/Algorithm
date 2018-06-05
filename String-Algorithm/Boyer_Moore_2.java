import java.util.*;
public class Boyer_Moore_2 {
    public static void main(String[] args){
    	String T = "abc abcdab abcdabcdabde";
		String P = "abcdabd";
        System.out.println(MisChar(T,P));
    }
    
    static void InitSkip(String P,int []skip){
    	int i,M = P.length(), NUM=26;		//NUM은 소문자 개수
    	for(i=0 ; i<NUM ; i++) skip[i] = M;
    	for(i=0 ; i<M ; i++) skip[P.charAt(i)-97]=M-i-1;		//아스키코드를 이용한 세팅
    }

    static int MisChar(String T, String P){
    	int M = P.length();
    	int N = T.length();
    	int []skip = new int[26];
    	InitSkip(P,skip);
    	
    	int i,j,k;
    	for(i=M-1 , j=M-1 ; j>=0 ; i--, j--){
    		while(T.charAt(i) != P.charAt(j)){			//다르면
    			k = T.charAt(i)>=97 ? skip[T.charAt(i)-97] : M;		//skip표에서 가져온 k값
    			
    			if(M-j > k) i=i+M-j;		//k값이 M이 아닐때
    			else i=i+k;					//k값이 M일때
    			
    			if(i>=N) return N;			//실패
    			j=M-1;
    		}
    	}						//j가 0까지 탐색을 완료했다면 성공했다는 의미 -> for문을 빠져나옴
    	return i+1;				//성공
    }
}
