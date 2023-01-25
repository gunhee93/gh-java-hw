package rock_paper_scissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		// �Է°��� ���� ��ü
		Scanner sc = new Scanner(System.in);
		// �������� ���� ��ü
		Random rand = new Random();
		
		// ���� Ŭ���� ��ü
		RpsService rps = new RpsService();
		
		// ������ ���� ����
		int ranNum;
		// ����� �Է°� ���� ����
		int user;
		// ��, ��, �� ���庯��
		int win = 0, lose = 0, draw = 0;
		// ���� ���� ���庯��
		int cnt = 1;
		// ����� ���� ���庯��
		String select;
		
		while(true) {
			user = rps.menu(win, lose, draw, cnt);
			
			// ��ǻ���� ������ 1(����), 2(����), 3(��) ����
			ranNum = rand.nextInt(3) + 1;
			
			switch(user) {
			case 1:// ����� ����
				System.out.println("\n���� ~ ���� ~ �� ~!!");
				if(ranNum == 1) { //��ǻ�� ����
					System.out.println("��    : ����");
					System.out.println("��� : ����");
					System.out.println("�����ϴ� ^��^");
					++draw;
				}
				if(ranNum == 2) { //��ǻ�� ����
					System.out.println("��    : ����");
					System.out.println("��� : ����");
					System.out.println("�����ϴ� �̤�");
					++lose;
				}
				if(ranNum == 3) { //��ǻ�� ��
					System.out.println("��    : ����");
					System.out.println("��� : ��");
					System.out.println("�̰���ϴ�!!!");
					++win;
				}
				break;
			case 2:// ����� ����
				System.out.println("���� ~ ���� ~ �� ~!!");
				if(ranNum == 1) { //��ǻ�� ����
					System.out.println("��    : ����");
					System.out.println("��� : ����");
					System.out.println("�̰���ϴ�!!!");
					++win;
				}
				if(ranNum == 2) { //��ǻ�� ����
					System.out.println("��    : ����");
					System.out.println("��� : ����");
					System.out.println("�����ϴ� ^��^");
					++draw;
				}
				if(ranNum == 3) { //��ǻ�� ��
					System.out.println("��    : ����");
					System.out.println("��� : ��");
					System.out.println("�����ϴ٤̤�");
					++lose;
				}
				break;
			case 3:// ����� ��
				System.out.println("���� ~ ���� ~ �� ~!!");
				if(ranNum == 1) { //��ǻ�� ����
					System.out.println("��    : ��");
					System.out.println("��� : ����");
					System.out.println("�����ϴ� �̤�");
					++lose;
				}
				if(ranNum == 2) { //��ǻ�� ����
					System.out.println("��    : ��");
					System.out.println("��� : ����");
					System.out.println("�̰���ϴ�!!!");
					++win;
				}
				if(ranNum == 3) { //��ǻ�� ��
					System.out.println("��    : ��");
					System.out.println("��� : ��");
					System.out.println("�����ϴ� ^��^");
					++draw;
				}
				break;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
			if(win == 5) {
				System.out.println("5ȸ �¸��Ͽ� ���ӿ��� �¸��Ͽ����ϴ�!!!");
				System.out.println("�ٽ� �Ͻðڽ��ϱ�? (Y/N)");
				System.out.print("���� : ");
				String restart = sc.next();
				if("Y".equals(restart) || "y".equals(restart)) {
					System.out.println("���ο� ������ �����մϴ� ^��^");
					win = 0;
					lose = 0;
					draw = 0;
					cnt += 1;
				} else {
					System.out.println("������ �����մϴ�...");
					return;
				}
			}
			if(lose == 5) {
				System.out.println("5ȸ �й��Ͽ� ���ӿ��� �й��Ͽ����ϴ�!!!");
				System.out.println("�ٽ� �Ͻðڽ��ϱ�? (Y/N)");
				System.out.print("���� : ");
				String restart = sc.next();
				if("Y".equals(restart) || "y".equals(restart)) {
					System.out.println("���ο� ������ �����մϴ� ^��^");
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
