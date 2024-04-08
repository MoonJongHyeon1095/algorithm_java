import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 27864kb
 * 368ms
 * 힙정렬 시간복잡도 O(N log N)
 *
 */
public class BOJ19638센티와마법의뿅망치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        for(int i=0; i<T; i++){
            //조건 만족하면 탈출 //첫 거인부터 키가 작은 경우도 처리
            if(pq.peek() < H) {
                System.out.println("YES");
                System.out.println(i);
                return;
            }

            // 1 초과인 경우만 나눔
            int tallest = pq.poll();
            if (tallest > 1) {
                pq.add(tallest / 2);
            } else {
                pq.add(tallest);
                break;
            }
        }

        if (pq.peek() >= H) {
            System.out.println("NO");
            System.out.println(pq.peek());
        }else {
            //뿅망치 T번 모두 사용
            System.out.println("YES");
            System.out.println(T);
        }

    }
}
