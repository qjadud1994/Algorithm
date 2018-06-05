import java.util.*;

public class oddeven_sort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] intArr = new int[n];
		for(int i=0 ; i<n ; i++) intArr[i]=input.nextInt();
		
		oddeven_sort sort = new oddeven_sort();
		sort.quickSort(intArr);
		sort.printArr(intArr);
	}

	private void quickSort(int[] arr) {
		int n = arr.length;

		for(int i=0 ; i<n ; i++){
			if(i%2==0){							//even
				for(int j=0 ; j<n-1 ; j+=2){
					if(arr[j]>arr[j+1]) swap(arr,j,j+1);
				}
			}
			else{								//odd
				for(int j=1 ; j<n-1 ; j+=2){
					if(arr[j]>arr[j+1]) swap(arr,j,j+1);
				}
			}
		}
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