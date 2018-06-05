import java.util.Scanner;

public class intersection {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		line []l = new line[n];

		for(int i=0 ; i<n ; i++){			//입력 받은 대로 선분을 정의한다.
			l[i] = new line(new point(input.nextInt(),input.nextInt()),new point(input.nextInt(),input.nextInt()));
		}
		
		int result=0;
		for(int i=0 ; i<n ; i++){
			for(int j=i+1 ; j<n ; j++){
				if(intersect(l[i],l[j])) result++;		//교차한다면 result를 1증가
			}
		}
		
		System.out.println(result);
	}
	
	static int ccw(point p0, point p1, point p2){		//시계 반대방향 알고리즘
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
	
	static int CCW(point p1, point p2, point p3){		//시계 반대방향 알고리즘
		return (p2.x-p1.x)*(p3.y-p1.y) - (p2.y-p1.y)*(p3.x-p1.x);	
				// dx1*dy2 - dx2*dy1
	}
	
	static boolean intersect(line l1, line l2){
		return  ( ccw(l1.p1, l1.p2, l2.p1) * ccw(l1.p1, l1.p2, l2.p2) ) <=0  &&
				(ccw(l2.p1, l2.p2, l1.p1) * ccw(l2.p1, l2.p2, l1.p2)) <=0 ;
				//곱이 둘다 음수이다 ->교차한다 (어떤 직선을 기준으로 오른쪽 왼쪽에 다른 직선의 끝점이 있기때문에)
	}
}

class point{					//점 좌표
	int x,y;
	public point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class line{				//선분
	point p1,p2;
	public line(){}
	public line(point p1, point p2){	//선분의 끝점을 setting한다.
		this.p1 = p1;
		this.p2 = p2;
	}
	public void setline(point p1, point p2){	//선분의 끝점을 setting한다.
		this.p1 = p1;
		this.p2 = p2;
	}
}


/*

2
-5 -5 5 5
5 -5 -5 5

*/