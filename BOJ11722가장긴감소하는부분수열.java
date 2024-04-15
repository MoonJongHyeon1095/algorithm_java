import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 14608kb
 * 156ms
 */
public class BOJ11722가장긴감소하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] memo = new int[N];
        memo[0]=1;

        /**
         * 수열이 [9, 7, 5, 3, 8, 4, 2]
         * i=3 (원소 3)에 대해 검토할 때, j=0 (9), j=1 (7), j=2 (5)에 대해 각각 비교를 수행
         * 이들 각각에 대해, 3보다 큰 모든 원소들 (9, 7, 5)의 memo 값에 1을 더한 값이 memo[3]보다 크다면, memo[3]을 갱신
         * 3을 포함하여 만들 수 있는 가장 긴 감소하는 부분 수열의 길이를 갱신하는 과정
         */
        for(int i=1; i<N; i++){
            memo[i]=1;

            //0~i-1번 원소를 모두 검토하여 LDS 갱신
            for(int j=0; j<i; j++){
                //수가 감소할 것 && 길이가 더 길어서 LDS를 생신해야 할 것
                if (arr[j] > arr[i] && memo[j] + 1 > memo[i]) {
                    memo[i] = memo[j] + 1;
                }
            }
        }

        int answer = Arrays.stream(memo).max().getAsInt();
        System.out.println(answer);
    }
}
