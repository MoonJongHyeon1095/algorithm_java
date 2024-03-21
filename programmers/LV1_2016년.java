package programmers;

import java.util.Arrays;

public class LV1_2016년 {
    public static String solution(int a, int b) {
        String[] dayList = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] slicedMonth = Arrays.copyOfRange(month, 0, a);

        int monthSum = Arrays.stream(slicedMonth).sum();
        int daySum = monthSum - month[a - 1] + b - 1;

        String 무슨날일까 = dayList[daySum % 7];

        return 무슨날일까;
    }
}
