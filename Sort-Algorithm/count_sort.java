import java.util.Arrays;
public class count_sort {
 
    public int[] sort(int[] A) {
        int[] Result = new int[A.length + 1];
        int[] Count = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) Count[A[i]]++;		//arr의 숫자들이 몇개 있는지 count배열로 나타냄

        for (int i = 1; i < Count.length; i++) {		//교차(?) 합을 구한다. -> 사이트 그림 참고
            Count[i] = Count[i] + Count[i - 1];
        }

        for (int i = A.length - 1; i >= 0; i--) {		//arr 끝에서 부터 시작해서 각각의 자리를 result라는 배열에서 잡아준다.		
            Result[ Count[A[i]]-- ] = A[i];				
        }
        
        return Result; 
        						//http://nhs0912.tistory.com/57 참고
    }
 
    public static void main(String[] args) {
        int input[] = { 2, 1, 4, 5, 7, 1, 1, 8, 9, 10, 11, 14, 15, 3, 2, 4 };
        
        System.out.println("Orginal Array " + Arrays.toString(input));
        count_sort c = new count_sort();
        int[] B = c.sort(input);
        System.out.println("Sorted Array : " + Arrays.toString(B));
 
    }
 
}
