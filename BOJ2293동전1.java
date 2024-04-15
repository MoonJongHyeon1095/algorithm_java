import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14216kb
 * 128ms
 * Bottom up
 * "조합 문제를 해결할 때 배열 인덱스를 목표 값을 표현하는 변수로 사용하는 방법은 매우 일반적"
 *
 * 시간복잡도 O(n * k)
 * n개 종류의 동전에 대해 최대 k번 배열 순회
 */
public class BOJ2293동전1 {
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] coinArr = new int[n];
        for (int i = 0; i < n; i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        //베열 인덱스로 목표값(동전의 합) 표현
        int[] memo = new int[k+1];
        memo[0] =1; //합이 0인 경우는 아무 동전도 선택하지 않은 경우 한가지

        for(int coin: coinArr){
            //모든 동전들의 가치(최대 k) //1원짜리로 1~k원 만드는 경우의 수, 1~2원짜리로 2~k원, 1~3원 짜리로 ...
            for(int j=coin; j<=k; j++){
                memo[j] += memo[j - coin]; //현재 동전을 사용해 k원을 만드는 경우 추가
                // memo[1] += memo[0] //  memo[2] += memo[1] ...

            }
        }
        System.out.println(memo[k]);
    }
}
