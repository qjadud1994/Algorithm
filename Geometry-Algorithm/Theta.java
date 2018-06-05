import java.util.Scanner;

public class Theta {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		t_point []p = new t_point[n];

		for(int i=0 ; i<n ; i+=2){			//입력 받은 대로 선분을 정의한다.
			p[i] = new t_point(input.nextInt(), input.nextInt());
			p[i+1] = new t_point(input.nextInt(), input.nextInt());
			System.out.println(theta(p[i],p[i+1]));
		}
	}
	
	static float theta(t_point p1, t_point p2){
		float dx = p2.x - p1.x;
		float ax = Math.abs(dx);
		
		float dy = p2.y - p1.y;
		float ay = Math.abs(dy);
		
		float t;
		
		if((ax+ay)==0) t=0;
		else t = dy/(ax+ay);		//역탄젠트 대신 쓸수있는 것이라고 함
									//역탄젠트보단 정확하진 않지만 그래도 대강 비슷하다고함
		if(dx<0) t = 2-t;
		else if(dy<0) t = 4+t;
		
		return t*90;
	}
}

class t_point{					//점 좌표
	int x,y;
	public t_point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
