package map_exam;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class MemberServiceImpl implements MemberService {
	Scanner sc = new Scanner(System.in);
	@Override
	public int menu() {

		System.out.println("\n1. ȸ������");
		System.out.println("2. ���Գ���");
		System.out.println("3. ��������");
		System.out.println("4. ȸ��Ż��");
		System.out.println("5. �ʱ�ȭ");
		System.out.println("0. ���α׷� ����");
		System.out.print("���� : ");
		return sc.nextInt();
	}

	@Override
	public void join(Map<String, Member> memberList) {
		//Member Ŭ������ ���� �ʱ�ȭ
		Member m = new Member();

		sub : while(true) {
			System.out.print("���̵� �Է� : ");
			m.setId(sc.next());

			Set<String> key = memberList.keySet();
			
			for(String s : key) {
				if(s.equals(m.getId())) {
					System.out.println("�̹� ������ ȸ�� ���̵��Դϴ�.");
					System.out.println("1. �ٸ��̸����� �����ϱ�");
					System.out.println("2. ���θ޴��� �̵�");
					System.out.print("���� : ");
					int select = sc.nextInt();
					switch(select) {
					case 1:
						continue sub;
					case 2:
						System.out.println("���θ޴��� �̵��մϴ�..");
						return;
					default :
						System.out.println("�߸��Է��Ͽ����ϴ�.");
					}
				}
			}
			break;
		}
		System.out.print("��й�ȣ �Է� : ");
		m.setPwd(sc.next());
		System.out.print("�̸� �Է� : ");
		m.setName(sc.next());
		System.out.print("�̸��� �Է� : ");
		m.setEmail(sc.next());

		memberList.put(m.getId(), m);
	}

	@Override
	public void output(Map<String, Member> memberList) {
		if(memberList.size() == 0) {
			System.out.println("������ ȸ�������� �����ϴ�.");
		} else {
			Collection<Member> value = memberList.values();
			for(Member mb : value) {
			System.out.println("\n���̵� : " + mb.getId());
			System.out.println("��й�ȣ : " + mb.getPwd());
			System.out.println("ȸ���̸� : " + mb.getName());
			System.out.println("�̸��� : " + mb.getEmail());
			}
		}
	}

	@Override
	public void modify(Map<String, Member> memberList) {
		if(memberList.size() == 0) {
			System.out.println("������ �� �ִ� ȸ�������� �����ϴ�.");
		} else {
			System.out.print("���̵� �Է� : ");
			String id = sc.next();
			
			Member m = memberList.get(id);
			
			if(m != null) {
				while(true) {
					System.out.println("1. ��й�ȣ ����");
					System.out.println("2. ȸ���̸� ����");
					System.out.println("3. �̸��� ����");
					System.out.println("0. ���θ޴��� �̵�");
					System.out.print("���� : ");
					int menu = sc.nextInt();
					switch(menu) {
					case 1:
						System.out.print("���ο� ��й�ȣ �Է� : ");
						m.setPwd(sc.next());
						System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
						break;
					case 2:
						System.out.print("���ο� ȸ���̸� �Է� : ");
						m.setName(sc.next());
						System.out.println("ȸ���̸��� ����Ǿ����ϴ�.");
						break;
					case 3:
						System.out.print("���ο� �̸��� �Է� : ");
						m.setEmail(sc.next());
						System.out.println("�̸����ּҰ� ����Ǿ����ϴ�.");
					case 0:
						System.out.println("���θ޴��� ���ư��ϴ�..");
						return;
					default :
						System.out.println("�߸��Է��Ͽ����ϴ�.");
					}
				}
			} else {
				System.out.println("�������� ���� ȸ���Դϴ�.");
			}
		}

	}

	@Override
	public void delete(Map<String, Member> memberList) {
		if(memberList.isEmpty()) {
			System.out.println("������ �� �ִ� ȸ�������� �����ϴ�.");
		} else {
			System.out.print("���̵� �Է� : ");
			String id = sc.next();
			
			Member m = memberList.get(id);
			
			if(m != null) {
				System.out.println(m.getId() + "���� ������ �����մϴ�.");
				memberList.remove(id);
			} else {
				System.out.println("�������� ���� ȸ���Դϴ�.");
			}
		}

	}

	@Override
	public void clear(Map<String, Member> memberList) {
		System.out.println("���� �ʱ�ȭ �Ͻðڽ��ϱ�?(��� ������ �ʱ�ȭ�˴ϴ�.)");
		System.out.print("Y/N �� ���� : ");
		String clear = sc.next();
		if("y".equals(clear) || "Y".equals(clear)) {
			System.out.println("��� ������ �ʱ�ȭ�մϴ�..");
			memberList.clear();
		} else {
			System.out.println("��ҵǾ����ϴ�. ");
		}
	}

}
