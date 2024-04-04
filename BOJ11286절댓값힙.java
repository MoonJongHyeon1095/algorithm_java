import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 25148kb
 * 336ms
 * 머리쓰기 싫어서 그냥 다 분기 나눠서 단순하게 했습니다
 * pq 메서드는 O(logN)
 * 전체 시간복잡도는 O(N log N)
 */
public class BOJ11286절댓값힙 {
    private static PriorityQueue<Integer> pqPlus = new PriorityQueue<>();
    private static PriorityQueue<Integer> pqMinus = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int currentNum = Integer.parseInt(br.readLine());
            if(currentNum >0){
                pqPlus.add(currentNum);
            }else if(currentNum <0){
                pqMinus.add(currentNum);
            }else{
                sb.append(printMethod()).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int printMethod(){
        int answer =0;

        if(pqPlus.isEmpty() && pqMinus.isEmpty()) return 0;
        if(pqPlus.isEmpty()) return pqMinus.poll();
        if(pqMinus.isEmpty()) return pqPlus.poll();

        if(pqPlus.peek() == -1 * pqMinus.peek()){
            answer = pqMinus.poll();
        }else if(pqPlus.peek() > -1 * pqMinus.peek()){
            answer = pqMinus.poll();
        }else if(pqPlus.peek() < -1 * pqMinus.peek()){
            answer = pqPlus.poll();
        }
        return answer;
    }
}
