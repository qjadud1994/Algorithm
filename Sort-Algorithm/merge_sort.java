import java.util.*;

public class merge_sort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] intArr = new int[n];
		for(int i=0 ; i<n ; i++) intArr[i]=input.nextInt();
	
		merge_sort mergeSort = new merge_sort();
		mergeSort.mergeSort(intArr, new int[intArr.length], 0, intArr.length - 1);

		mergeSort.printArr(intArr);
	}

	private void mergeSort(int[] arr, int[] tempArr, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(arr, tempArr, start, middle);
			mergeSort(arr, tempArr, middle + 1, end);
			merge(arr, tempArr, start, middle, end);
		}
	}

	private void merge(int[] arr, int[] tempArr, int start, int middle, int end) {
		int i = start;
		int j = middle + 1;
		int k = start;

		while (i <= middle || j <= end) {
			if (i > middle ) {
				tempArr[k] = arr[j];
				j++;
			} 
			else if (j > end ) {
				tempArr[k] = arr[i];
				i++;
			} 
			else {
				if (arr[i] <= arr[j]) {
					tempArr[k] = arr[i];
					i++;
				} 
				else {
					tempArr[k] = arr[j];
					j++;
				}
			}
			k++;
		}

		for (int t = start; t <= end; t++) {
			arr[t] = tempArr[t];
		}
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
