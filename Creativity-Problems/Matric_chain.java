import java.util.Scanner;

public class Matric_chain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int []d = new int[n*2];
		for(int i=0 ; i<n ; i++){		//행렬의 크기는 d[i]Xd[i+1] 로 나타낸다.
			d[i] = input.nextInt();
			d[i+1] = input.nextInt();	//입력은 항상 연쇄행렬 곱이 가능한 순서대로 넣어야한다.
		}								//ex)  aXb -> bXc -> cXd -> dXe  이런 식으로
		
		int [][]M = new int[n+1][n+1];	//0 인덱스 제거를 위해 +1
		int [][]P = new int[n+1][n+1];
		int j,min,para,mem;
		
		for(int diagonal=1 ; diagonal<n ; diagonal++){		//대각선
			for(int i=1 ; i<=n-diagonal ; i++){	//i는 대각선으로 이동하면서 처리할 행
				j = diagonal+i;					//j는 열
				min = 9999; mem=i;
				for(int k=i ; k<=j-1 ; k++){	//min 찾기
					para = M[i][k]+ M [k+1][j] + d[i-1]*d[k]*d[j];
					if(min>para) min=para; mem=k;
				}
				M[i][j] = min;
				P[i][j] = mem;
			}
		}
		
		System.out.println(M[1][n]);
		for(int i=1 ; i<=n ; i++){
			for(j=1 ; j<=n ; j++){
				System.out.print(P[i][j]+"  ");
			}
			System.out.println();
		}
		order(P,1,n);
		
	}
	static void order(int [][]P,int i, int j){
		if((i==j)) System.out.print("A"+i);
		else{
			System.out.print("(");
			int k = P[i][j];
			order(P,i,k);
			order(P,k+1,j);
			System.out.print(")");
		}
	}
}



/*

6
5 2
2 3
3 4
4 6
6 7
7 8


*/