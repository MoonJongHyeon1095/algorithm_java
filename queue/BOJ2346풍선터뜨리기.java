package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 15028kb
 * 180ms
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 덱 Dequeue
 * LinkedList: Deque 인터페이스구현체. 두 개의 포인터(또는 링크)를 사용하여 이전 요소와 다음 요소를 가리키는 방식으로 구현된 더블 링크드 리스트
 * 그러나 포인터 때문에 추가 메모리 오버헤드 발생
 * ArrayDeque는 내부적으로 원형 배열을 사용하여 요소를 저장, 추가 포인터 없이 인덱스로 배열 직접 접근. LinkedList보다 공간상 높은 효율
 * 요약: LinkedList는 더블 링크드 리스트, ArrayDeque는 더블 링크드 리스트가 아님
 *
 * 덱을 갱신하는 메서드는 O(1)
 * 반복문을 고려하면 전체 시간복잡도는 O(N^2)
 *
 --------------------------------------------------
 */
public class BOJ2346풍선터뜨리기 {
    private static class Balloon{
        int index, move;
        Balloon(int index, int move){
            this.index = index;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        //Deque<Balloon> q = new LinkedList<>(); //메모리 초과
        Deque<Balloon> q = new ArrayDeque<>();
        for(int i =0; i<N; i++){
            //1번 풍선부터 각 종이번호 넣기
            q.add(new Balloon(i+1, Integer.parseInt(st.nextToken())));
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        Balloon first = q.poll();
        sb.append(first.index).append(" ");
        int move = first.move;

        while(!q.isEmpty()){ //O(N^2)

            if(move > 0){
                //오른쪽이동
               for(int i = 0; i < move-1; i++){ //O(N)
                   q.addLast(q.pollFirst()); //O(1)
               }
               Balloon current = q.poll();
               move = current.move;
               sb.append(current.index).append(" ");

            } else {
                //왼쪽이동
               for(int i = 0; i < Math.abs(move)-1; i++){//O(N)
                   q.addFirst(q.pollLast());  //O(1)
               }
                Balloon current = q.pollLast();
                move = current.move;
                sb.append(current.index).append(" ");
           }

        }
        System.out.println(sb);

    }
}
