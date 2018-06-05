import java.util.Scanner;

public class closed_path {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		c_point []p = new c_point[n+1];		//min Y인 노드를 저장하기 위한 공간를 하나더 만든다.
		
		for(int i=0 ; i<n ; i++){			//입력 받은 대로 선분을 정의한다.
			p[i] = new c_point(input.nextInt(),input.nextInt(),(char)(i+65));
		}
		
		int standard = find_minY(p,n);	//y축 상 맨 밑의 노드를 기준으로
		p[n] = p[standard].copy();
//		odd_even_sort(p,n);				//기준 노드로 부터의 각도 순으로 정렬
		quicksort(p,0,n-1,n);
		
		for(int i=0 ; i<n; i++){
			System.out.print(p[i].ch+" ");
			System.out.println(theta(p[n],p[i]));
		}
	}

	static void odd_even_sort(c_point p[],int n){		//각도 순으로 정렬
		for(int i=0 ; i<n ; i++){
			if(i%2==0){									//even
				for(int j=0 ; j<n-1 ; j+=2){
					if(theta(p[n],p[j]) > theta(p[n],p[j+1]) ) swap(p[j],p[j+1]);
				}
			}
			else{										//odd
				for(int j=1 ; j<n-1 ; j+=2){
					if(theta(p[n],p[j]) > theta(p[n],p[j+1]) ) swap(p[j],p[j+1]);
				}
			}
		}
	}
	
	static void quicksort(c_point p[], int left, int right,int n){
		if(left>=right) return;
		float pivot = theta(p[n],p[right]);
		
		int l = left;
		int r = right-1;
		
		while(l<=r){
			while(l<=r && theta(p[n],p[l])<=pivot) l++;
			while(l<=r && theta(p[n],p[r])>=pivot) r--;
			
			if(l<r) swap(p[r],p[l]);
		}
		swap(p[right],p[l]);
		quicksort(p, 0,left-1,n);
		quicksort(p,left+1,right,n);
	}

	static void swap(c_point p1, c_point p2){
		int tempx = p2.x;
		int tempy = p2.y;
		char tempz = p2.ch;
		p2.setpoint(p1.x, p1.y, p1.ch);
		p1.setpoint(tempx, tempy, tempz);
	}
	
	static int find_minY(c_point []p, int n){		//최소 y를 갖는 노드 인덱스 찾기
		int minY=99999;
		int maxX=-99999;
		int index=0;
		for(int i=0 ; i<n ; i++){		//최소 y가 같을때는 x가 큰 것을 선택한다.
			if(minY>p[i].y || (minY==p[i].y && maxX<p[i].x)){
				minY=p[i].y;
				maxX=p[i].x;
				index=i;
			}
		}
		return index;
	}
	
	static float theta(c_point p1, c_point p2){
		float dx = p2.x - p1.x;
		float ax = Math.abs(dx);
		
		float dy = p2.y - p1.y;
		float ay = Math.abs(dy);
		
		float t;
		
		if((ax+ay)==0) t=0;
		else t = dy/(ax+ay);
		
		if(dx<0) t = 2-t;
		else if(dy<0) t = 4+t;
		
		return t*90;
	}
}

class c_point{					//점 좌표
	int x,y;
	char ch;
	public c_point(int x, int y,char ch){
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
	public void setpoint(int x, int y, char ch){
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
	public c_point copy(){
		return new c_point(x, y, ch);
	}
}


/*

16
-7 -3
3 7
-6 3
1 2
5 -5
-8 1
4 -1
-3 -2
-1 0
-2 -4
6 -6
7 5
-5 6
2 -8
0 4
-4 -7

*/