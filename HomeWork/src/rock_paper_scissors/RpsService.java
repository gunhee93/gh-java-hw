package rock_paper_scissors;

import java.util.Scanner;

public class RpsService {
	Scanner sc = new Scanner(System.in);
	
	public int menu(int win, int lose, int draw, int cnt) {
		
		System.out.println("\n���� ���� �� ����!!");
		System.out.println("��" + win);
		System.out.println("��" + lose);
		System.out.println("��" + draw);
		System.out.println();
		System.out.println(cnt + "��° ����!!");
		
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. ��");
		System.out.print("������ ���ðڽ��ϱ�?");
		int user = sc.nextInt();
		
		return user;
	}
	
}
