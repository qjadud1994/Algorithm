import java.util.*;
public class Gaussian_Elimination {
	
	private float [][]table;								//행렬 2차원 array
	private int row,col;									//행과 열
	private char []free = {'s','t','k','l','m','n','q'};		//free_variable 미지수 임의 지정 array
	private LinkedList<Integer> leading_one;					//leading_one 위치 저장을 위한 List
	
	public Gaussian_Elimination(int row, int col, float [][]table){
		this.row = row;
		this.col = col;									//생성자로 초기화
		this.table = table;
		leading_one = new LinkedList<Integer>();
	}
	
	public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("연립 방정식 식 개수를 입력하시오 : ");
    	int row = input.nextInt();
    	
    	System.out.println("변수 개수를 입력하시오 : ");
    	int col = input.nextInt()+1;					//행과 열 입력
    	
    	float [][]table = new float[row][col];
    	System.out.println("Augmented 행렬의 각 행의 내용을 입력하시오 : ");
    	for(int i=0 ; i<row ; i++){
    		for(int j=0 ; j<col ; j++){
    			table[i][j]=input.nextFloat();		//행렬 table 입력
    		}
    		input.nextLine();
    	}
    	
    	Gaussian_Elimination ge = new Gaussian_Elimination(row,col,table);
    	ge.solution();	
	}
	
	public void solution(){
		int leading;					//특정 행의 leading 위치 (열 기준의 위치)
		for(int r=0 ; r<row ; r++){
			boolean find = false;
			leading = r;				//초기 leading 위치는 r번째로
			
			while(leading < col-1 && table[r][leading]==0){		//leading 자리의 원소가 0이면
				for(int i=r ; i<row ; i++){
					if(table[i][leading]!=0) {	//그 아래 행 중에서 leading위치에 0이 아닌 것을 찾아서
						interchange(r,i);		//있으면 그 행과 위치를 바꾼다.
						find=true;				
						break;
					}
				}
				if(find) break;				//찾았으면 while문 벗어남
				else leading++;				//못찾았으면 leading_one 위치를 한칸 이동
			}
			
			leading_one.add(leading);					//leading_one 기억 위한 추가
			row_divide(r, table[r][leading]);			//leading one을 만들기 위한 row divide
			
			for(int i=r+1 ; i<row ; i++){
				row_subtract(i,r,table[i][leading]);		//leading one위치의 다른 행 값을 0으로 만든다.
			}			
		}
		
		for(int r=1 ; r<row ; r++){							//위의 작업을 반대로 다시한번 시행한다.
			leading = leading_one.get(r);
			for(int i=0 ; i<r ; i++){
				row_subtract(i,r,table[i][leading]);		//leading one 부터  마지막 원소사이의 모든 원소를 0으로 만든다.
			}
			if(isallzero(r)){								//특정 행의 모든 값이 0일때 (마지막열 원소 제외)
				if(table[r][col-1]!=0){						//마지막열 원소가 0이 아니면
					System.out.println("해가 존재하지 않음");		//존재하지 않는 조건
					return ;								//종료
				}
				else{										//마지막열 원소가 0이면
					System.out.println("무수히 많은 해가 존재");	//free_variable이 존대한다.
					interchange(r,row-1);					//모두 0인 행일 맨 아래로
					row--;									//행의 수 1 감소(삭제)
					leading_one.removeLast();
				}
			}
		}
		print();
		getsolution();		//해를 출력
	}
	
	public void print(){				//행렬 출력 함수
		for(int i=0 ; i<row ; i++){
			for(int j=0 ; j<col ; j++){
				System.out.print(table[i][j]+"    ");
			}
			System.out.println("");
		}
	}
	
	public void getsolution(){			//해를 출력하는 함수
		int free_variable = col-row-1;		//free_variable 의 수
		
		if (free_variable==0){				//유일해 출력
			System.out.println("유일해 존재");
			for(int i=col-2 ; i>=0 ; i--){
				System.out.println("x"+(i+1)+" = "+table[i][col-1]);
			}
		}		
		else{								//무수히 많은 해, 일반해 출력
			int []free_var = new int[free_variable];	//free_variable 을 저장하기 위한 array
			int a = 0;
			
			for(int i=0 ; i<col-1 ; i++){				//free_variable인 해 위치를 구하기
				if(a<leading_one.size() && i == leading_one.get(a)) a++;
				else{
					System.out.println("x"+(i+1)+" = "+free[free_variable-1]);	//free_variable 먼저 출력
					free_var[--free_variable]=i;		//그 위치를 배열에 저장			
				}
			}
			for(int i=0 ; i<leading_one.size() ; i++){			//나머지 해들
				System.out.print("x"+(leading_one.get(i)+1)+" = "+table[i][col-1]);  //먼저 맨 마지막 열의 원소부터 출력
				for(int j=0 ; j<free_var.length ; j++){
					float v = table[i][free_var[j]];							//나머지 free_variable 이어서 출력
					if(v>0) System.out.print("-"+table[i][free_var[j]]+"*"+free[j]);			
					else if(v<0) System.out.print("+"+-1*table[i][free_var[j]]+"*"+free[j]);	//부호를 맞추기 위한 조건문						
				}
				System.out.println("");
			}		
		}		
	}
	
	public void interchange(int row1, int row2){		//행의 행의 원소 교환
		if(row1 >=row || row2 >= row) return;
		float para;
		for(int i=0 ; i<col ; i++){
			para=table[row2][i];
			table[row2][i]=table[row1][i];
			table[row1][i]=para;
		}
	}
	
	public void row_divide(int m_row, float value){		//어떤 행의 모든 원소를 value로 나누는 함수
		if(m_row >=row || value==0) return;				//예외
		for(int i=0 ; i<col ; i++) table[m_row][i] /= value;
	}

	public void row_subtract(int row1, int row2, float value){		//행과 행(*value) 뺄셈 함수
		if(row1 >=row || row2 >= row || value==0) return;			
		for(int i=0 ; i<col ; i++) table[row1][i] -= value*table[row2][i];
	}
	
	public boolean isallzero(int row1){			//행의 맨 마지막열의 원소 빼고 나머지 원소가 모두 0인지 아닌지 판단 
		for(int i=0 ; i<col-1 ; i++){
			if(table[row1][i]!=0) return false;
		}
		return true;
	}
}

/*
3 3
1 3 2 1
1 4 4 4
2 7 8 10

3 3
1 2 1 4
3 8 7 20
2 7 9 23

3 4
1 0 0 4 -1
0 1 0 2 6
0 0 1 3 2

3 5
0 0 -2 0 7 12
2 4 -10 6 12 28
2 4 -5 6 -5 -1

4 5
0 0 -2 0 7 12
2 4 -10 6 12 28
2 4 -5 6 -5 -1
1 2 -5 3 6 0

5 5
0 0 -2 0 4 12
2 4 -10 12 10 24
2 4  4 -1 -4 12
1 -1 1 4 10 8
0 2 4 4 8 10

3 3
1 4 4 4
1 3 2 1
2 8 8 8

3 3
1 4 4 4
1 3 2 1
2 8 8 7


*/