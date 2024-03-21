package programmers;

import java.util.Arrays;

public class LV1_없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 0;

        int i = 0;
        while (i < 9) {
            i++;
            answer += i;
        }

        int result = Arrays.stream(numbers).sum();
        answer = answer - result;

        return answer;
    }
}
