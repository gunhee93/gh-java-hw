package rock_paper_scissors;

import java.util.Scanner;

public class RpsService {
	Scanner sc = new Scanner(System.in);
	
	public int menu(int win, int lose, int draw, int cnt) {
		
		System.out.println("\n가위 바위 보 게임!!");
		System.out.println("승" + win);
		System.out.println("패" + lose);
		System.out.println("무" + draw);
		System.out.println();
		System.out.println(cnt + "번째 게임!!");
		
		System.out.println("1. 가위");
		System.out.println("2. 바위");
		System.out.println("3. 보");
		System.out.print("무엇을 내시겠습니까?");
		int user = sc.nextInt();
		
		return user;
	}
	
}
