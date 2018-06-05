import java.util.*;

public class quick_sort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] intArr = new int[n];
		for(int i=0 ; i<n ; i++) intArr[i]=input.nextInt();
		
		quick_sort sort = new quick_sort();
		sort.quickSort(intArr, 0, intArr.length-1);
		sort.printArr(intArr);
	}

	private void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if(left < index -1) {
			quickSort(arr, left, index-1);
		}
		if(index < right) {
			quickSort(arr, index, right);
		}

	}

	private int partition(int[] arr, int left, int right) {
		int i = left, j= right;
		int tmp;
		int pivot = arr[(left + right)/2];

		while( i<= j) {
			while(arr[i] < pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
			if(i<= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
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