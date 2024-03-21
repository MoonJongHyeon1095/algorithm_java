package programmers;

import java.util.Arrays;

public class LV1_내적 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3}; // 입력 배열 a
        int[] b = {4, 5, 6}; // 입력 배열 b
        int result = solution(a, b);
        System.out.println(result);
    }

    public static int solution(int[] a, int[] b) {

        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i] * b[i];
        }

        return Arrays.stream(arr).reduce(0, (x, y) -> x + y);
    }
}
