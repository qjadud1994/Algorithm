import java.util.*;

public class selection_sort {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] intArr = new int[n];
		for(int i=0 ; i<n ; i++) intArr[i]=input.nextInt();
		
		selection_sort sort = new selection_sort();
		sort.sort(intArr);
	}

	private void sort(int[] arr) {
		int smallest, temp;
		for (int i = 0; i < arr.length - 1; i++) {
			smallest = i;			//arr[k] 를 최소값이라고 가정
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[smallest] > arr[j]) {
					smallest = j;			//최소값을 찾아낸다.
				}
			}
			temp = arr[i];		//최소값 세팅
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
		printArr(arr);

	}

	private void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i+" ");
		}

	}
}

/*

8
9 3 6 8 4 1 5 7

*/
