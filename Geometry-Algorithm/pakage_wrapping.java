import java.util.Scanner;

public class pakage_wrapping {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		w_point []p = new w_point[n+1];		//min Y인 노드를 저장하기 위한 공간를 하나더 만든다.
		
		for(int i=0 ; i<n ; i++){			//입력 받은 대로 선분을 정의한다.
			p[i] = new w_point(input.nextInt(),input.nextInt(),(char)(i+65));
		}
		
		int vertex = packagewrapping(p,n);
		
		for(int i=0 ; i<=vertex ; i++){
			System.out.print(p[i].ch+" ");
		}
	}
	
	static int packagewrapping(w_point []p, int n){
		int min = find_minY(p,n);
		p[n] = p[min].copy();		//배열 맨 마지막 원소는 최소Y를 갖는 노드
		float th=0,v;
		int M,i;
		
		for(M=0 ; M<n ; M++){		//M은 min노드 기준으로 둘레에 있는 원소들이다.		
			swap(p[M],p[min]);		//min은 배열 0부터 채우기 위해 기존 원소와 swap한다.
			min=n;
			v=th;		//v는 이전 노드의 각도
			th=360;		//th는 최소 각을 찾기 위한 매개변수
			
			for(i=M+1 ; i<=n ; i++){
				if(theta(p[M],p[i]) > v && theta(p[M],p[i]) < th){	//이전 노드의 각도 보다는 커야한다. (다각형 조건)
					min=i;											//th는 최소값을 찾기 위해 계속 바꾸어준다.
					th = theta(p[M],p[min]);
				}
			}														//다음 노드를 찾았다. (min)
			
			if(min==n) return M;					//다시 처음 노드로 돌아왔으면 종료
		}
		return -1;
	}
	
	static void swap(w_point p1, w_point p2){
		int tempx = p2.x;
		int tempy = p2.y;
		char tempz = p2.ch;
		p2.setpoint(p1.x, p1.y, p1.ch);
		p1.setpoint(tempx, tempy, tempz);
	}
	
	static int find_minY(w_point []p, int n){		//최소 y를 갖는 노드 인덱스 찾기
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
	
	static float theta(w_point p1, w_point p2){
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

class w_point{					//점 좌표
	int x,y;
	char ch;
	public w_point(int x, int y,char ch){
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
	public void setpoint(int x, int y, char ch){
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
	public w_point copy(){
		return new w_point(x, y, ch);
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