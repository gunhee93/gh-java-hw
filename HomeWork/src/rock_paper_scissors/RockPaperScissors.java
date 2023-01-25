package rock_paper_scissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		// 입력값을 위한 객체
		Scanner sc = new Scanner(System.in);
		// 랜덤값을 위한 객체
		Random rand = new Random();
		
		// 서비스 클래스 객체
		RpsService rps = new RpsService();
		
		// 랜덤값 저장 변수
		int ranNum;
		// 사용자 입력값 저장 변수
		int user;
		// 승, 무, 패 저장변수
		int win = 0, lose = 0, draw = 0;
		// 게임 순서 저장변수
		int cnt = 1;
		// 재시작 여부 저장변수
		String select;
		
		while(true) {
			user = rps.menu(win, lose, draw, cnt);
			
			// 컴퓨터의 랜덤값 1(가위), 2(바위), 3(보) 생성
			ranNum = rand.nextInt(3) + 1;
			
			switch(user) {
			case 1:// 사용자 가위
				System.out.println("\n가위 ~ 바위 ~ 보 ~!!");
				if(ranNum == 1) { //컴퓨터 가위
					System.out.println("나    : 가위");
					System.out.println("상대 : 가위");
					System.out.println("비겼습니다 ^ㅡ^");
					++draw;
				}
				if(ranNum == 2) { //컴퓨터 바위
					System.out.println("나    : 가위");
					System.out.println("상대 : 바위");
					System.out.println("졌습니다 ㅜㅜ");
					++lose;
				}
				if(ranNum == 3) { //컴퓨터 보
					System.out.println("나    : 가위");
					System.out.println("상대 : 보");
					System.out.println("이겼습니다!!!");
					++win;
				}
				break;
			case 2:// 사용자 바위
				System.out.println("가위 ~ 바위 ~ 보 ~!!");
				if(ranNum == 1) { //컴퓨터 가위
					System.out.println("나    : 바위");
					System.out.println("상대 : 가위");
					System.out.println("이겼습니다!!!");
					++win;
				}
				if(ranNum == 2) { //컴퓨터 바위
					System.out.println("나    : 바위");
					System.out.println("상대 : 바위");
					System.out.println("비겼습니다 ^ㅡ^");
					++draw;
				}
				if(ranNum == 3) { //컴퓨터 보
					System.out.println("나    : 바위");
					System.out.println("상대 : 보");
					System.out.println("졌습니다ㅜㅜ");
					++lose;
				}
				break;
			case 3:// 사용자 보
				System.out.println("가위 ~ 바위 ~ 보 ~!!");
				if(ranNum == 1) { //컴퓨터 가위
					System.out.println("나    : 보");
					System.out.println("상대 : 가위");
					System.out.println("졌습니다 ㅜㅜ");
					++lose;
				}
				if(ranNum == 2) { //컴퓨터 바위
					System.out.println("나    : 보");
					System.out.println("상대 : 바위");
					System.out.println("이겼습니다!!!");
					++win;
				}
				if(ranNum == 3) { //컴퓨터 보
					System.out.println("나    : 보");
					System.out.println("상대 : 보");
					System.out.println("비겼습니다 ^ㅡ^");
					++draw;
				}
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
			if(win == 5) {
				System.out.println("5회 승리하여 게임에서 승리하였습니다!!!");
				System.out.println("다시 하시겠습니까? (Y/N)");
				System.out.print("선택 : ");
				String restart = sc.next();
				if("Y".equals(restart) || "y".equals(restart)) {
					System.out.println("새로운 게임을 시작합니다 ^ㅡ^");
					win = 0;
					lose = 0;
					draw = 0;
					cnt += 1;
				} else {
					System.out.println("게임을 종료합니다...");
					return;
				}
			}
			if(lose == 5) {
				System.out.println("5회 패배하여 게임에서 패배하였습니다!!!");
				System.out.println("다시 하시겠습니까? (Y/N)");
				System.out.print("선택 : ");
				String restart = sc.next();
				if("Y".equals(restart) || "y".equals(restart)) {
					System.out.println("새로운 게임을 시작합니다 ^ㅡ^");
					win = 0;
					lose = 0;
					draw = 0;
					cnt += 1;
				} else {
					System.out.println("YOU LOSE...OTL...");
					return;
				}
			}
		}
	}
}
