import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 120638kb
 * 1040ms
 * 정렬 시간복잡도 O(N log N)
 * 매개변수탐색 시간복잡도 O(N log M)
 *
 */
public class BOJ2805나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] treeArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            treeArr[i] = Integer.parseInt(st.nextToken());
        }

        //이진탐색 혹은 그것을 응용한 매개변수 탐색은 정렬된 자료가 필요
        //하지만 여기서는 0~최대나무높이 가 그 역할을 하기 때문에, 배열을 정렬할 필요가 없음
        //좋지 않은 예시도 필요할 것 같아 그대로 남겨놓습니다
        Arrays.sort(treeArr); //O(N log N)
        System.out.println(parametricSearch(treeArr, M)); //O(N log M)

    }

    //O(N log minTotalLength)
    private static int parametricSearch(int[] sortedArr, int minTotalLength){
        int maxLength = sortedArr[sortedArr.length-1];
        int low = 0;
        int high = maxLength;

        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0; // 잘린 나무 길이의 총합

            for (int tree : sortedArr) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            if (sum >= minTotalLength) {
                low = mid + 1; // 더 길게 자를 수 있다
            } else {
                high = mid - 1; // 더 낮게 잘라야 한다
            }
        }
        //위 while문이 끝난 후 자를 수 있는 가장 큰 단위
        return high;
    }
}
