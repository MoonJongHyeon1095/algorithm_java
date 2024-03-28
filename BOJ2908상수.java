import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 메모리 14144kb
 * 시간 120ms
 */

public class BOJ2908상수 {
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int reversedNum1 = reverse(st.nextToken());
            int reversedNum2 = reverse(st.nextToken());
            System.out.println(Math.max(reversedNum1, reversedNum2));
        }


        private static int reverse(String token){
            String reversedStr = new StringBuilder(token).reverse().toString();
            return Integer.parseInt(reversedStr);
        }
    }
}
