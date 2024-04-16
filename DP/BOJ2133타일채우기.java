package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 14172kb
 * 140ms
 */
public class BOJ2133타일채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[3][N];
        int[] dp = new int[N + 1];
        dp[0] = 1; // 타일을 사용하지 않는 하나의 경우
        if (N >= 2) dp[2] = 3;

        if (N % 2 != 0) {  // N이 홀수면 타일링 불가능
            System.out.println(0);
            return;
        }

        //dp[n] : 3xN 벽을 채우는 방법의 수
        for (int i = 4; i <= N; i += 2) {
            dp[i] = 3 * dp[i - 2]; //가로 2 당 3가지 방법
            for (int j = 4; j <= i; j += 2) {
                dp[i] += 2 * dp[i - j]; //가로 4칸 채우는 패턴 2가지

            }
        }

        System.out.println(dp[N]);
    }
}
