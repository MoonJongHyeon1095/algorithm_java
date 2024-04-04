import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


/**
 * 26116kb
 * 388ms
 * 최소힙 사용
 * 골드문제인데 브론즈보다 쉬운 거 같아요.
 */
public class BOJ1715카드정렬하기 {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        if (pq.size() == 1) {
            System.out.println(0); // 크기가 1일 경우, 합칠 필요가 없음
        } else {
            System.out.println(mergeCount());
        }

    }

    private static int mergeCount() {
        int result =0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            pq.add(sum);
            result += sum;
        }
        return result;

    }
}
