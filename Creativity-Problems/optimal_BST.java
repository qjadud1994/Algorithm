import java.util.*;
public class optimal_BST {
   
	public static void main(String[] args){
	      Scanner s=new Scanner(System.in);
	      int n=s.nextInt();
	      float p[]=new float[n+1];			//p 세팅
	      
	      for(int i=1;i<=n;i++){			//1부터
	         p[i]=s.nextFloat();
	      }
	      int r[][]=new int[n+2][n+1];		//행렬 만들기		
	      float x;
	      x=OptimalBST(p,r,n);
	      System.out.println(x+" "+r[1][n]);
	   }
	   
   public static float OptimalBST(float p[],int r[][],int n){
      int i,j,d,k,h,pos = 0;
      float[][] A=new float[n+2][n+1];
      float min;
      float pp;
      
      for(i=1;i<=n;i++){		
         A[i][i]=p[i];			//(i,i) 대각선 세팅
         r[i][i]=i;				//최적인 형태를 찾기 위한 행렬
      }
     
      for(d=1;d<=n-1;d++){
         for(i=1;i<=n-d;i++){
            j=i+d;
            min=0;					//최소값을 찾기 위해
            pp=0;					//그냥 매개변수
            for(k=i;k<=j;k++){
               pp+=p[k];			//Pk까지 의 합을 구한다.
            }
            A[i][j]=pp;				//이 부분은 최소 최대와 관계없이 항상 넣는 값이므로 미리 넣는다.
            for(h=i;h<=j;h++){		//최소를 찾는다.
               pp=A[i][h-1]+A[h+1][j];	
               if(min==0){
                  min=pp;
                  pos=h;
               }else if(pp<min){
                  min=pp;
                  pos=h;
               }
            }
            A[i][j]+=min;		//구한 최소값을 세팅한다.
            r[i][j]=pos;		//형태 추적을 위한 세팅
         }
      }
      
      for(int x=1;x<=n;x++){
         for(int y=1;y<=n;y++){
            System.out.print(A[x][y]+" ");
         }
         System.out.println();
      }
      for(int x=1;x<=n;x++){
         for(int y=1;y<=n;y++){
            System.out.print(r[x][y]+" ");
         }
         System.out.println();
      }
      return A[1][n];
   }

}


/*

4
0.1 0.2 0.3 0.4


*/