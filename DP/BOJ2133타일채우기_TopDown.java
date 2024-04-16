package DP;

import java.io.*;

public class BOJ2133타일채우기_TopDown {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        dp = new int[N + 1];
        dp[0] = 1;
        if (N >= 2) dp[2] = 3;

        if (N >= 2) {
            System.out.println(tile(N));
        } else {
            System.out.println(0);
        }
    }

    private static int tile(int n) {
        if (n % 2 != 0) return 0;
        if (dp[n] != 0) return dp[n];

        // The main recurrence: dp[n] = 3*dp[n-2] + 2*sum(dp[n-4], dp[n-6], ..., dp[0])
        dp[n] = 3 * tile(n - 2); // Primary tiling patterns for the last two columns
        for (int i = 4; i <= n; i += 2) {
            dp[n] += 2 * tile(n - i); // Additional patterns from offsetting the tiles
        }

        return dp[n];
    }
}
