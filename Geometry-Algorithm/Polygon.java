import java.util.Scanner;

public class Polygon {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int dimension = input.nextInt();
		p_point []polygon = new p_point[dimension+2];	//array 순환을 위해 앞뒤 하나씩 추가
		
		for(int i=1 ; i<=dimension ; i++){			//입력 받은 대로 선분을 정의한다.
			polygon[i] = new p_point(input.nextInt(),input.nextInt());
		}
		p_point inp = new p_point(input.nextInt(), input.nextInt());
		
		System.out.println(inside(polygon,inp,dimension));		
	}
	
	static boolean inside(p_point []polygon, p_point t, int dimension){
		int count=0,j=0;
		p_line lt = new p_line(t,t.clone());
		lt.p2.x=1000;					//비교할 점을 x축과 평행인 직선으로 만들기
		
		polygon[0] = polygon[dimension];		//array의 양 끝에는 순환이 되게 값을 세팅
		polygon[dimension+1] = polygon[1];	// ex) 0 1 2 3 4 0 -> 4 1 2 3 4 1
		
		if(intersect(lt, new p_line(polygon[0],polygon[0]))) j = dimension-1;
						//i=1일 때는 교차점을 걸러내지 못한다. 그래서 다음과 같은 조건을 추가하였다.
						//내부점이 p0이고, 다각형 p0과 p1을 잇는 직선을 만드는데, 이 때 j는 p0가 아닌 p3을 가리켜야 교차점을 피할 수 있는데
						//j의 초기값 때문에 걸러내지 못한다. 그래서 이 경우 p3을 가리키도록 세팅한다.
		
		for(int i=1 ; i<=dimension ; i++){							//점을 먼저 비교하는 이유는 선분이 점에 걸려있으면
			p_line lp = new p_line(polygon[i],polygon[i].clone());	//두번 카운트된다.
			if(intersect(lt,lp)==false){			//lt가 다각형의 꼭지점과 만나면 내부가 아니므로 count 되지 않는다.
				lp.p2 = polygon[j];			//p[i]p[j] 직선으로 변경
				j = i;						//j의 역할은 교차점을 걸러내기 위한 도구이다. (강노 교차점 그림 참고)	
				if(intersect(lt,lp)) count++;	//겹치면 count증가
			}
		}
		
		if(count%2==1) return true;		//내부에 있다.
		else return false;
	}
	
	static int ccw(p_point p0, p_point p1, p_point p2){		//시계 반대방향 알고리즘
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
	
	static boolean intersect(p_line l1, p_line l2){
		return  ( ccw(l1.p1, l1.p2, l2.p1) * ccw(l1.p1, l1.p2, l2.p2) ) <=0  &&
				(ccw(l2.p1, l2.p2, l1.p1) * ccw(l2.p1, l2.p2, l1.p2)) <=0 ;
				//곱이 둘다 음수이다 ->교차한다 (어떤 직선을 기준으로 오른쪽 왼쪽에 다른 직선의 끝점이 있기때문에)
	}
}

class p_point{					//점 좌표
	int x,y;
	public p_point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public p_point clone(){
		return new p_point(x,y);
	}
}

class p_line{				//선분
	p_point p1,p2;
	public p_line(p_point p1, p_point p2){
		this.p1 = p1;
		this.p2 = p2;
	}
}


/*
 		//교차 -> 점
4
1 4
-2 3
-4 -3
5 -1
5 -1 
		//교차 -> 직선 형태
4
1 1
-2 1
-4 -3
5 -1
0 1
		//내부
4
1 1
-2 1
-4 -3
5 -1
0 0

*/
