
import java.util.*;
public class N_Queens {
	private final int num_Queens;
	private int count;
	private int []Columns;
	public N_Queens(int num_Queens){
		this.num_Queens = num_Queens;
		Columns = new int[num_Queens];
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num_Queens = input.nextInt();
		
		N_Queens test = new N_Queens(num_Queens);
		
		for(int i=0 ; i<num_Queens ; i++){
			test.setColumn(0, i);	//泥?以?4媛吏 寃쎌슦
			test.Solution(0);		//洹?寃쎌슦??留욌뒗 ?듭븞
		}
	}
	
	public void Solution(int Row){		//using recursive
		
		if(!isplace(Row)) return;
		
		if(Row == num_Queens-1) {System.out.println("solution"+(++count)); print(); System.out.println("");}	//留덉?留??됯퉴吏 ?명똿?섎㈃ 異쒕젰
		else{
			for(int i=0 ; i<num_Queens ; i++){
				Columns[Row+1] = i;
				Solution(Row+1);
			}
		}
	}	
	
	public void setColumn(int row, int t){
		Columns[row] = t;
	}
	
	public void print(){
		for(int i=0 ; i<num_Queens ; i++){
			for(int j=0 ; j<num_Queens ; j++){
				if(Columns[i]==j) System.out.print("X");
				else System.out.print("O");
			}
			System.out.println("");
		}
	}
	
	public boolean isplace(int NewRow){		//?대? 1李⑥썝諛곗뿴???곕뒗 ?먯껜濡?媛숈? ?됱뿏 寃뱀튂寃?諛곗튂媛 ?덈맂??
		int CurrentRow = 0;
		
		while(CurrentRow < NewRow){	//?댁뿉 寃뱀튂??寃껋씠 ?덈뒗吏 || ?媛곸꽑??寃뱀튂?붽쾬???덈뒗吏 ?먯깋
			if(Columns[NewRow] == Columns[CurrentRow] || Math.abs(Columns[NewRow]-Columns[CurrentRow]) == Math.abs(NewRow-CurrentRow)){
				return false;
			}
			CurrentRow++;
		}
		return true;
	}
	

}