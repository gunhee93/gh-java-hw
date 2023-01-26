package linked;


import java.util.LinkedList;
import java.util.List;

public class ScoreMain {
	public static void main(String[] args) {
		List<Score> scoreList = new LinkedList<Score>();
		ScoreService ss = new ScoreService();
		
		while(true) {
			int menu = ss.menu();
			switch(menu) {
			case 1:
				ss.input(scoreList);
				break;
			case 2:
				ss.output(scoreList);
				break;
			case 3:
				ss.modify(scoreList);
				break;
			case 4:
				ss.delete(scoreList);
				break;
			case 5:
				ss.clear(scoreList);
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default :
				System.out.println("�߸��Է��Ͽ����ϴ�.");
			}
		}
	}
}
