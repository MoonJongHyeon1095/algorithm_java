import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 87429kb
 * 864ms
 * 각 탑이 스택에 한번만 push되고 한번만 pop된다.
 * 모든 탑에 대해 총 N번의 push 연산과 최대 N번의 pop 연산이 발생하는 셈
 * 따라서 전체 시간복잡도는 O(N)
 */
public class BOJ2493탑 {
    private static class Tower{
        int index, height;
        Tower(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
    static Stack<Tower> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<N; i++){ //스택 특징상 O(N)+ O(N), O(N^2)가 아니다
            int current = Integer.parseInt(st.nextToken());
            //낮은 타워들 모두 제거
            while(!stack.isEmpty() && stack.peek().height < current) { //O(N)
                stack.pop(); //O(1)
            }

            if(stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }
            stack.push(new Tower(i+1, current)); //O(1)
        }
        System.out.println(sb);
    }
}
