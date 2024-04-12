import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 51088kb
 * 624ms
 * 정렬 : O(N log N)
 * 배열 조회 : O(N)
 */
public class BOJ13164행복유치원 {
    static int N,K;
    static int[] differenceArr;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 첫 원생만 따로 입력
        st = new StringTokenizer(br.readLine());
        int prevHeight = Integer.parseInt(st.nextToken());

        differenceArr = new int[N-1];
        int currentHeight;
        for (int i = 0; i <N-1; i++) {
            currentHeight = Integer.parseInt(st.nextToken());
            differenceArr[i] = currentHeight - prevHeight;
            prevHeight = currentHeight;
        }

        //O (N log N)
        Arrays.sort(differenceArr);

        //O N
        // 큰 차이 상위 K-1개 무시 (한명만 있는 조를 만듦)
        int sum = 0;
        for (int i = 0; i < N -1 - (K -1); i++) {
            sum += differenceArr[i];
        }

        System.out.println(sum);
    }
}
