import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 메모리 14128kb
 * 시간 124ms
 */
public class BOJ24267알고리즘수행시간6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((long)n*(n-1)*(n-2)/6);
        System.out.print(3);
    }

    // 수행횟수 nC3
//    for (int i = 0; i < n - 2; i++) {
//        for (int j = i + 1; j < n-1; j++) {
//          for (int k = j + 1; k < n; j++) {
//            sum += A[i] * A[j] * A[k]; // 코드1
//        }
//    }
}
