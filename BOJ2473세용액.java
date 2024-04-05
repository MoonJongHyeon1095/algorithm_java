import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 17432kb
 * 344ms
 * 투포인터를 반복문 안에서 돌리기
 * 괜히 메서드 분리시키려다가 인덱스 더 헷갈림. 단순하게 할 수 있는 건 단순하게.
 * 탐색 시간복잡도 O(N^2)
 */
public class BOJ2473세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] intArr = new int[N];
        //TreeSet<Integer> intSet = new TreeSet<>();

        for(int i=0; i<N; i++){
            intArr[i]=Integer.parseInt(st.nextToken());
            //intSet.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(intArr);

        long minSum = Long.MAX_VALUE;
        long[] result = new long[3];
        for (int i = 0; i < N; i++) {
            long fixedValue = intArr[i];
            int left = 0;
            int right = N - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                long sum = intArr[left] + intArr[right] + fixedValue;
                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    result[0] = fixedValue;
                    result[1] = intArr[left];
                    result[2] = intArr[right];
                }

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    break; // sum이 0인 경우
                }
            }
        }

        Arrays.sort(result); // 결과 정렬
        System.out.println(result[0]+" "+result[1]+" "+result[2]);
    }
}
