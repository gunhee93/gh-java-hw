package linked;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ScoreService {
	Scanner sc = new Scanner(System.in);

	public int menu() {
		System.out.println("1. �����Է�");
		System.out.println("2. �������");
		System.out.println("3. ��������");
		System.out.println("4. ��������");
		System.out.println("5. �ʱ�ȭ");
		System.out.println("0. ���α׷� ����");
		System.out.print("���� : ");
		return sc.nextInt();
	}

	public int scoreInput(String str) {
		System.out.print(str + "���� �Է� : ");
		return sc.nextInt();
	}

	public void input(List<Score> scoreList) {
		Score s = new Score();
		System.out.println("�̸��Է� : ");
		s.setName(sc.next());
		
		s.setKor(scoreInput("����"));
		s.setEng(scoreInput("����"));
		s.setMath(scoreInput("����"));
		s.setSum();
		s.setAvg();

		scoreList.add(s);

	}

	public void output(List<Score> scoreList) {
		if(scoreList.size() == 0) {
			System.out.println("��� ������ ������ �����ϴ�.");
		} else {

			for(Score s : scoreList) {
				System.out.println("�̸� : " + s.getName());
				System.out.println("���� : " + s.getSum());
				System.out.println("��� : " + s.getAvg());
				}
			}
		}

		public void modify(List<Score> scoreList) {
			System.out.print("�̸� �Է� : ");
			String name = sc.next();
			for(Score s : scoreList) {
				if(s.getName().equals(name)) {
					s.setKor(scoreInput("����"));
					s.setEng(scoreInput("����"));
					s.setMath(scoreInput("����"));
					s.setSum();
					s.setAvg();
					break;
				
				}
			}
		}

		public void delete(List<Score> scoreList) {
			System.out.print("�̸� �Է� : ");
			String name = sc.next();
			for(Score s : scoreList) {
				if(s.getName().equals(name)) {
					scoreList.remove(s);
					System.out.println(name + "���� ������ �����Ǿ����ϴ�.");
					break;
				}
			}	
		}

		public void clear(List<Score> scoreList) {
			System.out.println("��� ������ �ʱ�ȭ�մϴ�");
			scoreList.clear();
		}
	}
