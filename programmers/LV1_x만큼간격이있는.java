package programmers;
import java.util.ArrayList;
import java.util.List;
public class LV1_x만큼간격이있는 {
    public static List<Long> solution(int x, int n) {
        List<Long> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long value = (long)x * (i + 1);
            answer.add(value);
        }

        return answer;
    }
}
