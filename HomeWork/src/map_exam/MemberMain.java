package map_exam;

import java.util.HashMap;
import java.util.Map;

public class MemberMain {
	public static void main(String[] args) {
		Map<String, Member> memberList = new HashMap<String, Member>();
		MemberService ms = new MemberServiceImpl();
		
		while(true) {
			int menu = ms.menu();
			switch(menu) {
			case 1:
				ms.join(memberList);
				break;
			case 2:
				ms.output(memberList);
				break;
			case 3:
				ms.modify(memberList);
				break;
			case 4:
				ms.delete(memberList);
				break;
			case 5:
				ms.clear(memberList);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못입력하였습니다.");
			}
		}
	}
}
