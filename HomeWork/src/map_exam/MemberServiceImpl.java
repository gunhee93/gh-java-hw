package map_exam;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class MemberServiceImpl implements MemberService {
	Scanner sc = new Scanner(System.in);
	@Override
	public int menu() {

		System.out.println("\n1. 회원가입");
		System.out.println("2. 가입내역");
		System.out.println("3. 정보수정");
		System.out.println("4. 회원탈퇴");
		System.out.println("5. 초기화");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 : ");
		return sc.nextInt();
	}

	@Override
	public void join(Map<String, Member> memberList) {
		//Member 클래스의 값을 초기화
		Member m = new Member();

		sub : while(true) {
			System.out.print("아이디 입력 : ");
			m.setId(sc.next());

			Set<String> key = memberList.keySet();
			
			for(String s : key) {
				if(s.equals(m.getId())) {
					System.out.println("이미 가입한 회원 아이디입니다.");
					System.out.println("1. 다른이름으로 가입하기");
					System.out.println("2. 메인메뉴로 이동");
					System.out.print("선택 : ");
					int select = sc.nextInt();
					switch(select) {
					case 1:
						continue sub;
					case 2:
						System.out.println("메인메뉴로 이동합니다..");
						return;
					default :
						System.out.println("잘못입력하였습니다.");
					}
				}
			}
			break;
		}
		System.out.print("비밀번호 입력 : ");
		m.setPwd(sc.next());
		System.out.print("이름 입력 : ");
		m.setName(sc.next());
		System.out.print("이메일 입력 : ");
		m.setEmail(sc.next());

		memberList.put(m.getId(), m);
	}

	@Override
	public void output(Map<String, Member> memberList) {
		if(memberList.size() == 0) {
			System.out.println("가입한 회원내역이 없습니다.");
		} else {
			Collection<Member> value = memberList.values();
			for(Member mb : value) {
			System.out.println("\n아이디 : " + mb.getId());
			System.out.println("비밀번호 : " + mb.getPwd());
			System.out.println("회원이름 : " + mb.getName());
			System.out.println("이메일 : " + mb.getEmail());
			}
		}
	}

	@Override
	public void modify(Map<String, Member> memberList) {
		if(memberList.size() == 0) {
			System.out.println("수정할 수 있는 회원정보가 없습니다.");
		} else {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			
			Member m = memberList.get(id);
			
			if(m != null) {
				while(true) {
					System.out.println("1. 비밀번호 변경");
					System.out.println("2. 회원이름 변경");
					System.out.println("3. 이메일 변경");
					System.out.println("0. 메인메뉴로 이동");
					System.out.print("선택 : ");
					int menu = sc.nextInt();
					switch(menu) {
					case 1:
						System.out.print("새로운 비밀번호 입력 : ");
						m.setPwd(sc.next());
						System.out.println("비밀번호가 변경되었습니다.");
						break;
					case 2:
						System.out.print("새로운 회원이름 입력 : ");
						m.setName(sc.next());
						System.out.println("회원이름이 변경되었습니다.");
						break;
					case 3:
						System.out.print("새로운 이메일 입력 : ");
						m.setEmail(sc.next());
						System.out.println("이메일주소가 변경되었습니다.");
					case 0:
						System.out.println("메인메뉴로 돌아갑니다..");
						return;
					default :
						System.out.println("잘못입력하였습니다.");
					}
				}
			} else {
				System.out.println("가입하지 않은 회원입니다.");
			}
		}

	}

	@Override
	public void delete(Map<String, Member> memberList) {
		if(memberList.isEmpty()) {
			System.out.println("삭제할 수 있는 회원정보가 없습니다.");
		} else {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			
			Member m = memberList.get(id);
			
			if(m != null) {
				System.out.println(m.getId() + "님의 정보를 삭제합니다.");
				memberList.remove(id);
			} else {
				System.out.println("가입하지 않은 회원입니다.");
			}
		}

	}

	@Override
	public void clear(Map<String, Member> memberList) {
		System.out.println("정말 초기화 하시겠습니까?(모든 정보가 초기화됩니다.)");
		System.out.print("Y/N 중 선택 : ");
		String clear = sc.next();
		if("y".equals(clear) || "Y".equals(clear)) {
			System.out.println("모든 정보를 초기화합니다..");
			memberList.clear();
		} else {
			System.out.println("취소되었습니다. ");
		}
	}

}
