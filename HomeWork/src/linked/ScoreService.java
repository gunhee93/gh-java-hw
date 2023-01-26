package linked;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ScoreService {
	Scanner sc = new Scanner(System.in);

	public int menu() {
		System.out.println("1. 점수입력");
		System.out.println("2. 점수출력");
		System.out.println("3. 점수수정");
		System.out.println("4. 점수삭제");
		System.out.println("5. 초기화");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 : ");
		return sc.nextInt();
	}

	public int scoreInput(String str) {
		System.out.print(str + "점수 입력 : ");
		return sc.nextInt();
	}

	public void input(List<Score> scoreList) {
		Score s = new Score();
		System.out.println("이름입력 : ");
		s.setName(sc.next());
		
		s.setKor(scoreInput("국어"));
		s.setEng(scoreInput("영어"));
		s.setMath(scoreInput("수학"));
		s.setSum();
		s.setAvg();

		scoreList.add(s);

	}

	public void output(List<Score> scoreList) {
		if(scoreList.size() == 0) {
			System.out.println("출력 가능한 정보가 없습니다.");
		} else {

			for(Score s : scoreList) {
				System.out.println("이름 : " + s.getName());
				System.out.println("총점 : " + s.getSum());
				System.out.println("평균 : " + s.getAvg());
				}
			}
		}

		public void modify(List<Score> scoreList) {
			System.out.print("이름 입력 : ");
			String name = sc.next();
			for(Score s : scoreList) {
				if(s.getName().equals(name)) {
					s.setKor(scoreInput("국어"));
					s.setEng(scoreInput("영어"));
					s.setMath(scoreInput("수학"));
					s.setSum();
					s.setAvg();
					break;
				
				}
			}
		}

		public void delete(List<Score> scoreList) {
			System.out.print("이름 입력 : ");
			String name = sc.next();
			for(Score s : scoreList) {
				if(s.getName().equals(name)) {
					scoreList.remove(s);
					System.out.println(name + "님의 정보가 삭제되었습니다.");
					break;
				}
			}	
		}

		public void clear(List<Score> scoreList) {
			System.out.println("모든 정보를 초기화합니다");
			scoreList.clear();
		}
	}
