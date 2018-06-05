import java.util.Scanner;

public class Median_Three_Quicksort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for(int i=0 ; i<n ; i++) arr[i]=(int)(Math.random()*n*10+1);
		
		Median_Three_Quicksort sort = new Median_Three_Quicksort();
		double startTime = System.currentTimeMillis();
		sort.quicksort(arr, 0, n-1);
		double stopTime = System.currentTimeMillis();
        double runTime = stopTime - startTime;
//		sort.printArr(arr);
        System.out.println("array size = "+n+" -> Median of three Quick sort takes "+(runTime/1000));
	}

	private void quicksort(int []arr, int left, int right){
		if (left>=right) return;
		int size = right-left+1;			//배열 개수
		
		int m = (right+left)/2;				//가운데 index
		three_sort(arr,left,m,right);		//left middle right 먼저 정렬(size<3 도 상관없다)
											
		if(size > 3){							//4개 이상일때
			int l = left;						//left index
			int r = right-1;					//right index
			int pivot = arr[m];					//pivot은 left middle right 중 중간값 
		
			swap(arr,m,right);					//pivot을 맨 오른쪽으로
												//일반적인 quick_sort		
			while(l <= r) {						//교차될때까지
				while(l<=r && arr[l] <= pivot) l++;						//l 오른쪽으로 이동
				while(l<=r && arr[r] >= pivot) r--;						//r 왼쪽으로 이동
				
				if(l < r) swap(arr,l,r);						//r과 l을 바꾸어준다
			}
			swap(arr,l,right);						//l원소와 pivot 바꾸기
			quicksort(arr,left,l-1);				//자리잡은 l을 기준으로 왼쪽
			quicksort(arr,l+1,right);				//오른쪽
		}
	
	}

	private void three_sort(int []arr, int a, int b, int c){		//3개 (이하) 정렬 함수
		if(arr[a] > arr[b]) swap(arr,a,b);
		if(arr[b] > arr[c]) swap(arr,b,c);
		if(arr[a] > arr[b]) swap(arr,a,b);
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
		System.out.println("");
	}
}


/*

8
9 3 6 8 4 1 5 7

*/