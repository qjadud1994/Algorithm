import java.util.Scanner;

public class quick_sort2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) arr[i]=(int)(Math.random()*n+1);
		quick_sort2 sort = new quick_sort2();
		
		double startTime = System.currentTimeMillis();
		sort.quicksort(arr, 0, n-1);
		double stopTime = System.currentTimeMillis();
        double runTime = stopTime - startTime;
		sort.printArr(arr);
        System.out.println("array size = "+n+" -> Quick sort takes "+(runTime/1000));
	}

	private void quicksort(int []arr, int left, int right){
		if (left>=right) return;
		
		int pivot = arr[right];					//pivot 설정
		int l = left;							//left index
		int r = right-1;						//right index
		
		while( l<= r) {						//교차될때까지
			while(l<=r && arr[l] <= pivot) {
				l++;						//l 오른쪽으로 이동 (l > pivot 일때까지)
			}
			while(l<=r && arr[r] >= pivot) {
				r--;						//r 왼쪽으로 이동  (r < pivot 일때까지)
			}
			if(l< r) {						//r과 l을 바꾸어준다.
				swap(arr,l,r);
			}
		}
		swap(arr,l,right);						//pivot과 정해진 l 원소 바꾸기
		quicksort(arr,left,l-1);				//자리잡은 l을 기준으로 왼쪽
		quicksort(arr,l+1,right);				//오른쪽
	}

	private void swap(int []arr, int a, int b){
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

	private void printArr(int[] arr) {
		for(int i :arr) {
			System.out.print(i+" ");
		}

	}
}


/*

8
9 3 6 8 4 1 5 7

*/