package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 18572kb
 * 208ms
 * 스택 시간복잡도 O(N)
 *
 * 겁나게 어려운데요
 */
public class BOJ1863스카이라인쉬운거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 시작점을 0으로 설정

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //0357210의 경우
            //3,5,7 push
            //2를 만나면 스택 비우고 (count +3) 2 push
            //1을 만나면 스택 비우고 (count +1) 1 push
            //0을 만나면 스택 비우기 (count +1)

            // 스택에서 현재 높이보다 큰 값 모두 제거
            while (y < stack.peek()) {
                stack.pop();
                count++;
            }

            // 현재 높이가 더 높으면 카운트
            if (y > stack.peek()) {
                stack.push(y);
            }

        }

        //처음에 넣은 0 말고 다른게 남아있으면 모두 카운트
        while(stack.size()>1) {
            stack.pop();
            count++;
        }

        System.out.println(count);
    }
}
