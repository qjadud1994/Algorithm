import java.util.Scanner;

public class String_Edit_Distance {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String S = "GUMBO"; //input.nextLine();
		String T = "GAMBOL"; //input.next();
		
		int m = S.length();		//5
		int n = T.length();		//6
		
		int [][]table = new int[n+1][m+1];
		int i_cost = 1;			//insert cost
		int d_cost = 1;			//delete cost
		int cost = 0;			//exchange cost
		
		for(int i=1 ; i<=n ; i++){
			if(i<=m) table[0][i] = i;		//setting edge
			table[i][0] = i;
		}
		
		for(int i=1 ; i<=n ; i++){
			for(int j=1 ; j<=m ; j++){
				if(S.charAt(j-1)==T.charAt(i-1)) cost=0;	//같으면 거리가 0이므로 cost=0, 즉 대각선 원소 그대로 내려온다.
				else cost=1;
				table[i][j] = getmin(table[i][j-1]+i_cost, table[i-1][j]+d_cost, table[i-1][j-1]+cost);
			}
		}
		
		System.out.println(table[n][m]);
	}
	
	static int getmin(int a, int b, int c){
		int min=a;
		if(min>b) min=b;
		if(min>c) min=c;
		return min;
	}

}
