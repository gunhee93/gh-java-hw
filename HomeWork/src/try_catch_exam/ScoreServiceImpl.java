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
			System.out.println("\n1. 점수등록");
			System.out.println("2. 전체정보");
			System.out.println("3. 점수수정");
			System.out.println("4. 정보삭제");
			System.out.println("5. 전체 초기화");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 : ");
			menu = sc.nextInt();
		} catch(Exception e) {
			System.out.println("숫자를 입력해 주세요.");
			sc = new Scanner(System.in);
		}
		return menu;
	}

	public int scoreInput(String str){
		int score = 0;
		do {
			try {
				System.out.print(str + "점수 입력 : ");
				score = sc.nextInt();
			}catch(Exception e) {
				System.out.println("숫자를 입력해 주세요.");
				sc = new Scanner(System.in);	
			}
		} while(score<0 || score>100);
		return score;
	}

	@Override
	public void input(Map<String, Score> scoreList) {
		Score s = new Score();
		System.out.print("이름 입력 : ");
		s.setName(sc.next());
		s.setKor(scoreInput("국어"));
		s.setEng(scoreInput("영어"));
		s.setMath(scoreInput("수학"));
		s.setSum();
		s.setAvg();

		scoreList.put(s.getName(), s);

	}

	@Override
	public void output(Map<String, Score> scoreList) {
		Collection<Score> value = scoreList.values();
		for(Score s : value) {
			if(s != null) {
			System.out.println("\n이름 : " + s.getName());
			System.out.println("총점 : " + s.getSum());
			System.out.println("평균 : " + s.getAvg());
			} else {
				System.out.println("동록된 점수가 없습니다.");
			}
		}

	}

	@Override
	public void modify(Map<String, Score> scoreList) {
		System.out.print("이름 입력 : ");
		String name = sc.next();
		Score s = scoreList.get(name);
		if(s == null) {
			System.out.println("없는 정보입니다.");
		} else {
			s.setKor(scoreInput("국어"));
			s.setEng(scoreInput("영어"));
			s.setMath(scoreInput("수학"));
			s.setSum();
			s.setAvg();
		}
	}

	@Override
	public void delete(Map<String, Score> scoreList) {
		System.out.print("이름 입력 : ");
		String name = sc.next();
		Score s = scoreList.remove(name);
		if(s == null) {
			System.out.println("없는 정보입니다.");
		} else {
			System.out.println(name + "님의 정보가 삭제되었습니다.");
		}

	}

	@Override
	public void clear(Map<String, Score> scoreList) {
		System.out.println("정말 초기화 하시겠습니까?(모든 정보가 초기화됩니다.)");
		System.out.print("Y/N 중 선택 : ");
		String clear = sc.next();
		if("y".equals(clear) || "Y".equals(clear)) {
			System.out.println("모든 정보를 초기화합니다..");
			scoreList.clear();
		} else {
			System.out.println("취소되었습니다. ");
		}
	}
}
