import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 274296kb
 * 840ms
 * 우선순위 큐 사용, 시간복잡도 O(log N)
 * 따로 로직을 구현하는게 좋을까 싶었으나, 결국 전체 자료를 비교해야할 것 같아 PQ 를 사용하는 것이 나아보였습니다.
 */

public class BOJ2075N번쨰큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        //최대값 N-1개 빼기
        for(int i=0; i<N-1; i++){
            pq.poll();
        }

        System.out.println(pq.poll());

    }
}
