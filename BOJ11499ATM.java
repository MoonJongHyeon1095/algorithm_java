import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 14528kb
 * 144ms
 * 시간복잡도 O(n log n) : ArrayList.sort()
 * stream 사용은 주의해야하지만, 기억을 되살릴겸 연습삼아 써봤습니다
 */
public class BOJ11499ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> intArr = new ArrayList<>();
        ArrayList<Integer> sumArr = new ArrayList<>();

        for(int i=0; i<N; i++){
            intArr.add(Integer.parseInt(st.nextToken()));
        }
        intArr.sort((a,b) -> a-b); //O(n log n)

        int sum=0;
        for(int i=0; i<N; i++){
            sum += intArr.get(i);
            sumArr.add(sum);
        }

        //stream 사용은 주의해야하지만, 기억을 되살릴겸 연습삼아 써봤습니다
        int answer = sumArr.stream().reduce(0, (a,b)->a+b); //O(n)
        System.out.println(answer);
    }
}
