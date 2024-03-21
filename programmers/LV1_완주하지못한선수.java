package programmers;
import java.util.Arrays;
public class LV1_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"Jane", "John", "Tom", "Alice"};
        String[] completion = {"John", "Tom", "Jane"};
        String result = solution(participant, completion);
        System.out.println(result);
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        // completion 배열을 모두 돌았는데도 완주하지 못한 선수를 찾지 못한 경우에는 participant 배열의 마지막 선수를 반환합니다.
        return participant[participant.length - 1];
    }

}
