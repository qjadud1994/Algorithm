
import java.util.Scanner;

public class Matrix_Path {		// 행렬 최단 경로 문제

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int R = input.nextInt();
		
		int [][]matrix = new int[R][R];
		
		for(int i=0 ; i<R ; i++){					
			for(int j=0 ; j<R ; j++){
				matrix[i][j] = input.nextInt();
			}
		}
		for(int i=1 ; i<R ; i++){			//양 끝에는 연쇄 합으로 세팅
			matrix[0][i] += matrix[0][i-1];
			matrix[i][0] += matrix[i-1][0];
		}
											//이동 가능 방향은 오른쪽 또는 아래
		for(int i=1 ; i<R ; i++){			//위, 왼쪽 중 최소값을 더해나간다.
			for(int j=1 ; j<R ; j++){
				matrix[i][j] += Math.min(matrix[i][j-1], matrix[i-1][j]);
			}
		}
		
		System.out.println("Min sum : "+matrix[R-1][R-1]);
		

	}

}

/*
4
6 7 12 5
5 3 11 18
7 17 3 3
8 10 14 9
*/