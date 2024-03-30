import java.io.*;
import java.util.*;

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
            String exitingCar = exitQueue.poll(); // 차량이 터널에서 나옵니다.
            if (!enterQueue.peek().equals(exitingCar)) {
                count++;
                enterQueue.remove(exitingCar);
            } else {
                enterQueue.poll();
            }


        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
