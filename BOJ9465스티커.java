import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *110636kb
 * 696ms
 *
 * 풀지 못한 문제
 *
 1. 상하좌우가 안된다 = 대각선으로만 이동한다
 2. 1칸뒤 대각선과 2칸뒤 대각선 누적합 비교. (3칸 뒤 부터는 앞의 조합으로 갈 수 있으므로, 바로 가면 무조건 누적합이 작다.)

 점화식
 d[0][i] = Max(d[1][i - 1], d[1][i - 2]) + a[0][i];
 d[1][i] = Max(d[0][i - 1], d[0][i - 2]) + a[1][i];
 */
public class BOJ9465스티커 {
    static int T, n;
    static int[][] matrix;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            n=Integer.parseInt(br.readLine());
            dp = new long[2][n + 1];
            matrix = new int[2][n];
            initMatrix(br);

            if (n == 1) {
                sb.append(Math.max(matrix[0][0], matrix[1][0])).append("\n");
                continue;
            }

            //각 row의 첫열 초기화
            dp[0][0] = matrix[0][0];
            dp[1][0] = matrix[1][0];
            dp[0][1] = dp[1][0] + matrix[0][1];
            dp[1][1] = dp[0][0] + matrix[1][1];

            for (int column = 2; column < n; column++) {
                dp[0][column] = Math.max(dp[1][column - 1], dp[1][column - 2] ) + matrix[0][column];
                dp[1][column] = Math.max(dp[0][column - 1], dp[0][column - 2] ) + matrix[1][column];

            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }
        System.out.println(sb);
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
