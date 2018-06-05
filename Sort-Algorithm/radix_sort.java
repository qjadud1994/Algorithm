import java.util.*;

public class radix_sort
{
    public static void main(String[] args) 
    {
        int []data = {35,81,12,67,93,46,23,26};
        PrintResult(data);
        RadixSort(data, data.length, 2);			//2는 최대 자리수
        PrintResult(data);
    }
    
    static void RadixSort(int data[], int num, int maxLen) //maxLen = 정렬대상중 가장 긴 데이터의 길이 정보
    {
        int divfac = 1;
        int n = data.length;						
        
        Queue<Integer> queue[] = new LinkedList[10];

        for(int i =0; i<10; i++)					//radix이므로 0부터 9까지 열개
            queue[i] = new LinkedList<Integer>();

        for(int pos = 0; pos < maxLen; pos++)		//자리수가 가장 큰 것 만큼
        {
            for(int di = 0; di < n; di++)			//array 탐색
            {  
                int radix = (data[di] /divfac) %10;		//자리수 추출          
                queue[radix].add(data[di]);				//해당 자리수 queue에 추가
            }
            
            for(int bi =0, di = 0; bi<10; bi++)			//기수 정렬 한 10개의 queue 데이터들을 
            {											//array로 다시 넣어준다.
                while(!queue[bi].isEmpty())
                    data[di++] = queue[bi].remove();
            }

            //N번째 자리의 숫자 추출을 위한 피제수의 증가
            divfac *= 10;
        }
    }

    static void PrintResult(int data[]){
        for(int i = 0; i<data.length; i++)
            System.out.printf(data[i]+ " ");
        System.out.println();
    }
}
