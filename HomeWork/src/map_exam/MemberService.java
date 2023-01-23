package map_exam;

import java.util.Map;

public interface MemberService {
	int menu();
	void join(Map<String, Member> memberList);
	void output(Map<String, Member> memberList);
	void modify(Map<String, Member> memberList);
	void delete(Map<String, Member> memberList);
	void clear(Map<String, Member> memberList);
	
}
