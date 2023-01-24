package try_catch_exam;

import java.util.Map;

public interface ScoreService {
	int menu();
	void input(Map<String, Score> scoreList);
	void output(Map<String, Score> scoreList);
	void modify(Map<String, Score> scoreList);
	void delete(Map<String, Score> scoreList);
	void clear(Map<String, Score> scoreList);
}
