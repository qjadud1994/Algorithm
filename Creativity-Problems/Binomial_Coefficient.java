import java.util.Scanner;

public class Binomial_Coefficient {			//nCk 이항계수

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		
		int [][]table = new int[n+1][n+1];
		
		for(int i=0 ; i<=n ; i++){
			table[i][0] = 1;
			table[i][i] = 1;
		}
		
		for(int i=2 ; i<=n ; i++){
			for(int j=1 ; j<i ; j++){
				table[i][j] = table[i-1][j-1]+table[i-1][j];
			}
		}
		
		System.out.println(table[n][k]);
		

	}

}
