import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * LIS
 */
public class BOJ2565전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2]; //A,B 2개 씩 저장
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }
        Arrays.sort(arr, (a, b)-> a[0]-b[0]);
        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {

        }
    }
}
