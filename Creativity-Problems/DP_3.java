
import java.util.Scanner;
				
public class DP_3 {		//
	private int R,C;
	private int[][] matrix;
	private int [][]solution;
	public DP_3(int R, int [][]matrix){
		this.R = R;
		C = 2;
		this.matrix = matrix;
		solution = new int[R][R];
	}
	
	public void test(){
		
		for(int i=0 ; i<R ; i++){
			solution[i][i+1] = solution[i][i] + matrix[i][i]*matrix[i][i+1]*matrix[i+1][i];
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int R = input.nextInt();
		int C = 2;
		int [][]matrix = new int[R][C];
		
		for(int i=0 ; i<R ; i++){				//곱셈 ?\85력	
			for(int j=0 ; j<C ; j++){
				matrix[i][j] = input.nextInt();
			}
		}
		
		DP_3 test = new DP_3(R,matrix);
		
		

	}

}

/*
3
6 7 12
-8 10 14
11 12 7
*/