
import java.util.*;

public class Knapsack01  {

	public Knapsack01() {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int W = input.nextInt();
		
		Sack sack[] = new Sack[N+1];
		
		for(int i=0 ; i<N ; i++){
			sack[i] = new Sack(input.nextInt(),input.nextInt());
		}
		
		int [][]table = new int[N+1][W+1];
			
		for(int i= 1 ; i<N+1 ; i++){
			for(int j=1 ; j<W+1 ; j++){
				if(sack[i].weight > j)
					table[i][j] = table[i-1][j];
				else
					table[i][j] = Math.max(sack[i].profit+table[i-1][j-sack[i].weight], table[i-1][j]);
			}
		}
		System.out.println(table[N][W]);
    }
    public static void main(String args[]) {
        new Knapsack01();
    }
}

class Sack{
	int weight;
	int profit;
	Sack(int weight, int profit){
		this.weight = weight;
		this.profit = profit;
	}
}