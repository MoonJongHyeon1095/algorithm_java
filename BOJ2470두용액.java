import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 28212kb
 * 380ms
 * 정렬 시간복잡도 O(N long N)
 * 탐색 시간복잡도 O(N)
 * 투포인터 알고리즘, 이라던데 그냥 값 갱신해나가면서 직관적으로 하면 됨
 * 이분탐색으로 더 개선할 수 없을까?
 */
public class BOJ2470두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] intArr = new int[N];

        for(int i=0; i<N; i++){
            intArr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intArr);
        int left = 0;
        int right = intArr.length-1;
        int min = Integer.MAX_VALUE;
        int[] result = {left, right};

        while(left<right){
            int sum = intArr[left] + intArr[right];
            int absSum = Math.abs(intArr[left] + intArr[right]);

            //0과 가장 가까운 값 갱신
            if(absSum < min){
                min = absSum;
                result[0] = intArr[left];
                result[1] = intArr[right];
            }
            //합이 음수일 때 음수 포인터 증가
            if(sum <0){
                left++;
            }else{
                //합이 양수일 때 양수 포인터 감소
                right--;
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.println(sb);

    }
}
