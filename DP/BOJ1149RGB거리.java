package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14668kb
 * 140ms
 *
 * top down 방식
 */
public class BOJ1149RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] memo = new int[N][3];
        memo[0][0] = arr[0][0];
        memo[0][1] = arr[0][1];
        memo[0][2] = arr[0][2];

        // 점화식
        // memo[n] = fib(n - 1) + fib(n - 2); 패턴 기억
        for (int i = 1; i < N; i++) {
            memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + arr[i][0]; //i번째 집을 빨강으로 칠하기 위한 최소비용
            memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + arr[i][1];
            memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + arr[i][2];
        }

        int result = Math.min(Math.min(memo[N-1][0], memo[N-1][1]), memo[N-1][2]);
        System.out.println(result);
    }
}
