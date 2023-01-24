package try_catch_exam;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class ScoreServiceImpl implements ScoreService {
	Scanner sc = new Scanner(System.in);
	@Override
	public int menu() {
		int menu = 6; 
		try {
			System.out.println("\n1. �������");
			System.out.println("2. ��ü����");
			System.out.println("3. ��������");
			System.out.println("4. ��������");
			System.out.println("5. ��ü �ʱ�ȭ");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� : ");
			menu = sc.nextInt();
		} catch(Exception e) {
			System.out.println("���ڸ� �Է��� �ּ���.");
			sc = new Scanner(System.in);
		}
		return menu;
	}

	public int scoreInput(String str){
		int score = 0;
		do {
			try {
				System.out.print(str + "���� �Է� : ");
				score = sc.nextInt();
			}catch(Exception e) {
				System.out.println("���ڸ� �Է��� �ּ���.");
				sc = new Scanner(System.in);	
			}
		} while(score<0 || score>100);
		return score;
	}

	@Override
	public void input(Map<String, Score> scoreList) {
		Score s = new Score();
		System.out.print("�̸� �Է� : ");
		s.setName(sc.next());
		s.setKor(scoreInput("����"));
		s.setEng(scoreInput("����"));
		s.setMath(scoreInput("����"));
		s.setSum();
		s.setAvg();

		scoreList.put(s.getName(), s);

	}

	@Override
	public void output(Map<String, Score> scoreList) {
		Collection<Score> value = scoreList.values();
		for(Score s : value) {
			if(s != null) {
			System.out.println("\n�̸� : " + s.getName());
			System.out.println("���� : " + s.getSum());
			System.out.println("��� : " + s.getAvg());
			} else {
				System.out.println("���ϵ� ������ �����ϴ�.");
			}
		}

	}

	@Override
	public void modify(Map<String, Score> scoreList) {
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		Score s = scoreList.get(name);
		if(s == null) {
			System.out.println("���� �����Դϴ�.");
		} else {
			s.setKor(scoreInput("����"));
			s.setEng(scoreInput("����"));
			s.setMath(scoreInput("����"));
			s.setSum();
			s.setAvg();
		}
	}

	@Override
	public void delete(Map<String, Score> scoreList) {
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		Score s = scoreList.remove(name);
		if(s == null) {
			System.out.println("���� �����Դϴ�.");
		} else {
			System.out.println(name + "���� ������ �����Ǿ����ϴ�.");
		}

	}

	@Override
	public void clear(Map<String, Score> scoreList) {
		System.out.println("���� �ʱ�ȭ �Ͻðڽ��ϱ�?(��� ������ �ʱ�ȭ�˴ϴ�.)");
		System.out.print("Y/N �� ���� : ");
		String clear = sc.next();
		if("y".equals(clear) || "Y".equals(clear)) {
			System.out.println("��� ������ �ʱ�ȭ�մϴ�..");
			scoreList.clear();
		} else {
			System.out.println("��ҵǾ����ϴ�. ");
		}
	}
}
