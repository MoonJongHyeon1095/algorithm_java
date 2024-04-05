import java.util.Arrays;
import java.util.Scanner;

//파라메트릭 서치
public class BOJ1654랜선자르기 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int K = s.nextInt();
        int N = s.nextInt();
        long[] arr = new long[K];

        for (int i =0; i<K; i ++) {
            arr[i] = s.nextInt();
        }

        //K개의 랜선 중 최대길이
        long max = Arrays.stream(arr).max().orElseThrow();

        long start = 1;
        long end = max;

        while (start <= end) {
            long mid = (start + end) /2;
            long sum = Arrays.stream(arr).map(e -> e / mid).sum(); //mid 길이만큼 잘라서 몇개가 나오나

            // N개보다 많이 만드는 것도 N개를 만드는 것에 포함(문제조건)
            if (sum >= N) {
                start = mid + 1; //더 많으면 더 크게 잘라도 된다. 자르는 단위의 왼쪽을 버린다.
            } else {
                end = mid - 1; //더 작으면 더 크게 잘라야 한다. 자르는 단위의 오른쪽을 버린다.
            }
        }

        System.out.println(end);
    }
}

