import java.util.*;
public class Boyer_Moore {
    public static void main(String[] args){
        int index;
        String text = "adndkfieiainddfdmaindlflidl";
        String P    = "main";
        
        index = BM_Search(text,P);
        System.out.println(index);
    }
    public static int BM_Search(String text, String pattern) {
        int patLen  = pattern.length(); //패턴의 길이
        int textLen = text.length();
    //텍스트와 패턴이 일치하지 않았을 때에
    //이동 범위
        int[] skip = new int[65536];  //정수 최대값
        int i;
        int j;
        
        //표 skip작성
        Arrays.fill(skip, patLen);
        for (int x = 0; x < patLen -1; x++){
            skip[pattern.charAt(x)] = patLen - x - 1;
        }
        //포인터를 초기화한다. 패턴을 뒤에서부터 비교하기 때문에
        i = patLen - 1;
        //텍스트의 가장 마지막에 도달할 때까지 반복한다
        while (i < textLen) {
            //포인터 j가 패턴의 마지막 문자를 가리키도록 한다
            j = patLen -1;
            //텍스트와 패턴이 일치하는 동안 반복한다
            while (text.charAt(i) == pattern.charAt(j)) {
                //처음 문자까지 일치했다면 탐색은 성공이다
                if (j == 0)   {return i;}
                i--; j--;
            }
            i = i + Math.max(skip[text.charAt(i)], patLen - j);
        }
        //결국 발견하지 못했을때
        return -1;
    }

}
