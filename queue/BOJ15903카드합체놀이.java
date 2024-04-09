package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 15368kb
 * 164ms
 * 최소힙으로 단순하게 구현했으나 계속 틀려서 헤맸습니다.
 * 알고보니 카드에 적힌 숫자 자체의 크기가 커서(최대 백만), long으로 풀어야 합니다.
 * int 타입의 값 범위는 -2^31에서 2^31-1
 * long 타입의 값 범위는 -2^63에서 2^63-1
 */
public class BOJ15903카드합체놀이 {
    private static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }
        for(int i=0; i<m; i++){
            plusAndCopy();
        }

        long answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        System.out.println(answer);
    }

    private static void plusAndCopy(){
        long minNum1 = pq.poll();
        long minNum2 = pq.poll();

        //카드 두장 복사해 넣기
        long newNum = minNum1 + minNum2;
        pq.add(newNum);
        pq.add(newNum);

    }
}
