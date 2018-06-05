import java.util.*;

public class heap_sort {
    private int[] arr;
    private int n;
    public heap_sort(int[] arr,int n) {
        this.arr = arr;
        this.n = n;
    }
 
    public void max_Heapify(int i) {		//히프화 하기
        if (arr == null || n < 1)
            return;
 
        int leftChild = i * 2;				//왼쪽 자식
        int rightChild = leftChild + 1;		//오른쪽 자식
        int largest = i;
 
        if (leftChild < n && arr[leftChild] > arr[i])
            largest = leftChild;
 
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;		//노드 i와 left, right 중 가장 큰 노드가 largest
        
        if (largest != i) {				//i가 가장큰 노드가 아니면
            swap(i, largest);			//i위치에 가장 큰 노드와 바꾸어준다.
            max_Heapify(largest);		//바꾼 노드 아래로 다시 히프화한다.
        }
    }
 
    public void buildMaxHeap() {
        if (arr == null || n < 1)
            return;
 
        for (int i = n/2; i > 0; i--) {		//자식이 없는 노드는 히프화에 제외한다.
            max_Heapify(i);
        }

        for(int i = n ; i > 1 ; i--){		//루트(max, index=1) 와 마지막노드(index=i)를 바꾼다.
        	swap(1,i);
        	max_Heapify(1);					//다시 max heap으로 만든다.
        	n--;							//고정 됬으니 비교할 수를 빼준다.
        }
    }
 
    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
 
    public void printArr() {
        for (int i = 1; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
 
    public static void main(String args[]) {
    	Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n+1];
		for(int i=1 ; i<n+1 ; i++) arr[i]=input.nextInt();
        
        heap_sort heap = new heap_sort(arr,n);
        heap.printArr();
        heap.buildMaxHeap();
        heap.printArr(); 
    }
}

/*

7
1 6 3 7 4 5 2

*/
