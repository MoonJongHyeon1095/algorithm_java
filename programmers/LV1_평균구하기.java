package programmers;

import java.util.Arrays;

public class LV1_평균구하기 {

    public double solution(int[] arr) {

        double answer = 0;
        answer = Arrays.stream(arr).sum() /(double) arr.length;
        System.out.println(answer);
        return answer;
    }
}
