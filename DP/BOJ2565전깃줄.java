package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * LIS bottop up
 * 14180kb
 * 128ms
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
        //A 오름차순 정렬
        Arrays.sort(arr, (a, b)-> a[0]-b[0]);
        int[] dp = new int[N];
        Arrays.fill(dp, 1);  // 각 요소의 초기값을 1로 설정
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            for(int j=0; j<i; j++){
                //증가하면
                if(arr[j][1] < arr[i][1]) dp[i] = Math.max(dp[i], dp[j]+1); //최대값 갱신
            }
        }

        //dp에 있는 최대 수열
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(N - maxLen);
    }
}
