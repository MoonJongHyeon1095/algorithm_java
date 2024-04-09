package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 23408kb
 * 168ms
 * 큐 연산 메서드당 O(1)
 * BFS 최악의 경우에도 모든 노드를 한번씩 방문, O(N)
 */
public class BOJ1697숨바꼭질 {
    private static int[] count = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = bfs(N,K);
        System.out.println(result-1); //시작을 1로 쳤기 때문에 1을 빼야 함

    }

    private static int bfs(int N, int K){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        count[N] = 1; // 1부터 시작 //방문 배열을 따로 만들지 않기 위함

        while(!q.isEmpty()){
            int current = q.poll();

            // 도착지점에 도달
            if (current == K) {
                return count[current];
            }

            //델타배열...이 아니라 델타를 적용한 배열
            int[] nextPoint = {current - 1, current + 1, current * 2};

            for (int next : nextPoint) {
                //인덱스 벗어남
                if(next <0 || next > 100000) continue;

                if (count[next] ==0) { //방문한적 없는 경우
                    q.add(next);
                    count[next] = count[current] + 1;
                }
            }
        }
        return -1; //도달 못한 경우
    }
}
