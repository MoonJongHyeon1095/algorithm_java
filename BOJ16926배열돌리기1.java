import java.io.*;
import java.util.*;

public class BOJ16926배열돌리기1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt() % ((N+M-2)*2);

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        List<Deque<Integer>> queues = insertQueue(matrix, N, M);

        for(Deque<Integer> q : queues){
            rotateQueue(q, R);
        }

        StringBuilder sb = new StringBuilder();
        printMatrixFromQueue(queues, N, M);
        System.out.print(sb);
    }

    private static int getLayerNum(int N, int M){
        int minNum = Math.min(N,M);
        return minNum%2==0 ? minNum / 2 : minNum / 2 + 1; //2를 몇번 뺄 수 있는지 카운트 하는 것은, 그냥 2로 나눈다는 뜻..ㅎㅎㅎ
    }

    private static List<Deque<Integer>> insertQueue(int[][] matrix, int N, int M){
        int layerNum = getLayerNum(N, M);
        List<Deque<Integer>> layers = new ArrayList<>();

        for (int i = 0; i < layerNum; i++) {
            layers.add(new LinkedList<>());
        }

        for (int layer = 0; layer < layerNum; layer++) {
            Deque<Integer> queue = layers.get(layer);
            int count = 1;
            for(int i=layer; i < N-layer; i++){
                if(count==1){
                    //첫행 다넣기
                    for(int j=layer; j<M-layer; j++) {
                        queue.add(matrix[i][j]);
                    }
                    count++;
                }else if(count >1 && count < N - layer *2){
                    //중간행 첫 숫자
                    queue.addFirst(matrix[i][layer]);
                    //중간행 마지막 숫자
                    queue.addLast(matrix[i][M-(1+layer)]);
                    count++;
                }else{
                    //마지막행
                    for(int j=layer; j<M-layer; j++) {
                        queue.addFirst(matrix[i][j]);
                    }
                }
            }

            //자르기. 자른 부분은 그대로 requeue
            int rotateCount = N + M - 2;
            for (int i = 0; i < rotateCount; i++) {
                Integer firstElement = queue.poll();
                queue.add(firstElement);
            }
        }
        return layers;
    }

    private static void rotateQueue(Deque<Integer> queue, int R){

        for (int i = 0; i < R; i++) {
            Integer firstElement = queue.poll();
            queue.add(firstElement);
        }

    }

    private static void printMatrixFromQueue(List<Deque<Integer>> queues, int N, int M){
        int layerNum = getLayerNum(N, M);
        StringBuilder sb = new StringBuilder();

        for (int layer = 0; layer < layerNum; layer++) {
            Deque<Integer> queue = queues.get(layer);



        }

    }
}
