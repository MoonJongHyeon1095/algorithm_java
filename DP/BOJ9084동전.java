package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14228kb
 * 124ms
 */
public class BOJ9084동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());  // 동전의 종류 수

            int[] coinArr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            //N가지 동전 종류
            for (int i = 0; i < N; i++) {
                coinArr[i] = Integer.parseInt(st.nextToken());  // 각 동전의 가치
            }

            int M = Integer.parseInt(br.readLine());  // 목표 금액
            int[] dp = new int[M + 1];  // dp[i]는 금액 i를 만들 수 있는 방법의 수
            dp[0] = 1;  // 금액 0을 만드는 방법은 아무 동전도 사용하지 않는 1가지 방법이 있음

            for (int coin : coinArr) {
                for (int j = coin; j <= M; j++) {
                    dp[j] += dp[j - coin];  // 각 동전을 사용해 j 금액을 만드는 방법 추가
                }
            }

            System.out.println(dp[M]);  // 목표 금액 M을 만드는 방법의 수 출력
        }
    }
}
