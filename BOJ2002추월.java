import java.io.*;
import java.util.*;

/**
 * 14848kb
 * 160ms
 * Queue.remove(something) 으로 링크드리스트로 구현된 큐의 중간 요소를 삭제하는 부분 시간복잡도 O(N)
 * 해당 작업을 순회하기 때문에, 전체 시간복잡도는 O(N^2)
 * 대조하여 하나는 중간요소 삭제, 하나는 poll 하는 작업이 직관적이지 않아 생각하기 쉽지 않다.
 */
public class BOJ2002추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Queue<String> enterQueue = new LinkedList<>();
        Queue<String> exitQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            enterQueue.add(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            exitQueue.add(br.readLine());
        }

        int count = 0;
        while (!exitQueue.isEmpty()) {
            String exitingCar = exitQueue.poll();
            if (!enterQueue.peek().equals(exitingCar)) {
                count++;
                enterQueue.remove(exitingCar); //O(N)
            } else {
                enterQueue.poll();
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
