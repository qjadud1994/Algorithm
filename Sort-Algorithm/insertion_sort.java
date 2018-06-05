import java.util.*;
public class insertion_sort {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] intArr = new int[n];
		for(int i=0 ; i<n ; i++) intArr[i]=input.nextInt();
		
		insertion_sort sort = new insertion_sort();
		sort.sort(intArr);
	}

	private void sort(int[] arr) {
		int key, i;
		for(int j=1; j<arr.length; j++) {
			key = arr[j];
			i = j-1;
			while( i>= 0 && arr[i] > key) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}

		printArr(arr);

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
