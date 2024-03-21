package programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LV1_나누어떨어지는숫자배열 {
    public static int[] solution(int[] arr, int divisor) {
        List<Integer> cthulu = new ArrayList<>();
        int[] nyarlathotep = {-1};

        for (int j : arr) {
            if (j % divisor == 0) {
                cthulu.add(j);
            }
        }

        if (!cthulu.isEmpty()) {
            return cthulu.stream().sorted().mapToInt(Integer::intValue).toArray();
        } else {
            return nyarlathotep;
        }
    }

//    public int[] divisible(int[] array, int divisor) {
//        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
//    }
}
