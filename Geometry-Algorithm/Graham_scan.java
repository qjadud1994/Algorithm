import java.util.Scanner;

public class Graham_scan {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		g_point []p = new g_point[n+1];		//순환되는 노드를 저장하기 위한 공간을 하나더 만든다.
		
		for(int i=1 ; i<=n ; i++){			//0번은 비우고 나머지를 채운다
			p[i] = new g_point(input.nextInt(),input.nextInt(),(char)(i+64));
		}

		int vertex = graham_scan(p,n);
		
		for(int i=1 ; i<=vertex ; i++){
			System.out.print(p[i].ch+" ");
		}
	}

	static int graham_scan(g_point p[], int n){
		int min = find_minY(p,n);				//y축 상 맨 밑의 노드를 기준으로
		swap(p[1],p[min]);						//1번배열과 위치를 바꾼다.
//		odd_even_sort(p,n);						//기준 노드 index=1 로 부터의 각도 순으로 정렬
		quicksort(p,1,n);
		p[0] = p[n].copy();	//0번 노드를 n번 노드와 같게 세팅
		print(p,n);
		int M=3,i;										//M은 이전의 연결 성공한 노드사이의 선을 의미한다.
		for(i=4 ; i<=n ; i++){							//i는 비교할 다음 노드를 의미한다.
			while( ccw(p[M-1],p[M],p[i]) <=0 ){			//우회전일때
				M--;							//while문 반복 수는 내부제거되는 노드 수이다.
			}
			M++;
			swap(p[i],p[M]);
			print(p,n);
		}
		return M;
	}
		
	static void print(g_point p[], int n){
		for(int i=0 ; i<=n ; i++){
			System.out.print(p[i].ch+"("+p[i].x+","+p[i].y+") ");
		}
		System.out.println();
	}
	static void odd_even_sort(g_point p[],int n){		//각도 순으로 정렬 (1~n번 노드까지)
		for(int i=1 ; i<n ; i++){					//기준 노드는 1번 노드
			if(i%2==0){									//even
				for(int j=2 ; j<n ; j+=2){				
					if(theta(p[1],p[j]) > theta(p[1],p[j+1]) ) swap(p[j],p[j+1]);
				}
			}
			else{										//odd
				for(int j=1 ; j<n ; j+=2){
					if(theta(p[1],p[j]) > theta(p[1],p[j+1]) ) swap(p[j],p[j+1]);
				}
			}
		}
	}
	
	static void quicksort(g_point p[], int left, int right){
		if(left>=right) return;
		float pivot = theta(p[1],p[right]);
		
		int l = left;
		int r = right-1;
		
		while(l<=r){
			while(l<=r && theta(p[1],p[l])<=pivot) l++;
			while(l<=r && theta(p[1],p[r])>=pivot) r--;
			
			if(l<r) swap(p[r],p[l]);
		}
		swap(p[right],p[l]);
		quicksort(p, 1,left-1);
		quicksort(p,left+1,right);
	}
	
	static int CCW(g_point p1, g_point p2, g_point p3){		//시계 반대방향 알고리즘
		return (p2.x-p1.x)*(p3.y-p1.y) - (p2.y-p1.y)*(p3.x-p1.x);	
	}

	static int ccw(g_point p0, g_point p1, g_point p2){		//시계 반대방향 알고리즘
		int dx1, dx2, dy1, dy2;
		dx1 = p1.x-p0.x;  dy1 = p1.y-p0.y;
		dx2 = p2.x-p0.x;  dy2 = p2.y-p0.y;
		
		if(dx1*dy2 > dy1*dx2) return 1;				//점p2가 선분 p0_p1 왼쪽
		if(dx1*dy2 <dy1*dx2) return -1;				//점p2가 선분 p0_p1 오른쪽
													//이 밑에 부터는 기울기가 같다는 전제(dx1*dy2 = dy1*dx2)
		if(dx1==0 && dy1==0) return 0;				//점으로 판단
		if(dx1*dx2<0 || dy1*dy2<0) return -1;		//교차하지 않고 선분p0_p1 와 같은 직선상 밑에 p2가 있다.
		if(dx1*dx1+dy1*dy1 < dx2*dx2+dy2*dy2) return 1;	//교차하지 않고 선분 p0_p1와 같은 직선상 위에 p2가 있다.
		return 0;
	}
	
	static void swap(g_point p1, g_point p2){
		int tempx = p2.x;
		int tempy = p2.y;
		char tempz = p2.ch;
		p2.setpoint(p1.x, p1.y, p1.ch);
		p1.setpoint(tempx, tempy, tempz);
	}
	
	static int find_minY(g_point []p, int n){		//최소 y를 갖는 노드 인덱스 찾기
		int minY=99999;
		int maxX=-99999;
		int index=0;
		for(int i=1 ; i<=n ; i++){		//최소 y가 같을때는 x가 큰 것을 선택한다.
			if(minY>p[i].y || (minY==p[i].y && maxX<p[i].x)){
				minY=p[i].y;
				maxX=p[i].x;
				index=i;
			}
		}
		return index;
	}
	
	static float theta(g_point p1, g_point p2){
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

class g_point{					//점 좌표
	int x,y;
	char ch;
	public g_point(int x, int y,char ch){
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
	public void setpoint(int x, int y, char ch){
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
	public g_point copy(){
		return new g_point(x, y, ch);
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