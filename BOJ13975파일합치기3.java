import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *331616kb
 * 3320ms
 * 우선순위 큐 입력 및 정렬 연산 O(N log N)
 * 파일 합치기 O (N log N)
 *
 * 쉽게 할 수 있는데, 괜히 문제에 적힌 반례에 꽂혀 시간을 보냈다. 누적합의 최소는 우선순위 큐에 requeue 하는 것으로 보통 해결된다.
 */
public class BOJ13975파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<T; i++) {
            int K = Integer.parseInt(br.readLine()); // 파일의 개수
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) pq.add(Long.parseLong(st.nextToken()));

            long acc = 0;
            //40, 30, 30, 50인 경우 -> 40, 50, 60 -> 60, 90 -> 150
            while(pq.size()>1){
                long a = pq.poll();
                long b = pq.poll();
                acc += a+b;
                pq.add(a+b);
            }
            sb.append(acc).append("\n");

        }
        System.out.println(sb);
    }
}
