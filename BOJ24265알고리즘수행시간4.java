import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 메모리 14344kb
 * 시간 136ms
 */
public class BOJ24265알고리즘수행시간4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((long)n*(n-1)/2);
        System.out.print(2);
    }

    // 수행횟수 nC2
//    for (int i = 0; i < n - 1; i++) {
//        for (int j = i + 1; j < n; j++) {
//            sum += A[i] * A[j]; // 코드1
//        }
//    }
}
