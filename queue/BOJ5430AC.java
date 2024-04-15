package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 97436kb
 * 796ms
 * 수행할 문자열의 길이나 정수배열의 길이가 최대 100,000에 달하므로 처음부터 문자열 전체를 작동시키면 안된다고 생각
 * 숫자를 제거하는 방향이나 출력 방향등은 flag 값 활용
 * Deque활용
 *
 */
public class BOJ5430AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        outerLoop:
        for(int i=0; i<T; i++){
            Deque<Integer> q = new ArrayDeque<>();
            String functionStr = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrayStr = br.readLine();
            arrayStr = arrayStr.substring(1, arrayStr.length() - 1); // 대괄호 제거

            //빈 배열도 함수가 R만 있으면 error를 내서는 안된다.
//            if(arrayStr.equals("")){
//                System.out.println("error");
//                continue;
//            }


            if(n > 0){
                String[] numbers = arrayStr.split(",");
                for (String numStr : numbers) {
                    q.add(Integer.parseInt(numStr));
                }
            }

            boolean reverseFlag = false;
            for(char c : functionStr.toCharArray()){
                if(c == 'R'){
                    reverseFlag = !reverseFlag;
                }
                if(c=='D'){
                    if(q.isEmpty()){
                        System.out.println("error");
                        continue outerLoop; //라벨을 사용해서 외부 반복으로 탈출
                    }
                    if (reverseFlag) {
                        q.pollLast();
                    } else {
                        q.poll();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while(!q.isEmpty()) {
                sb.append(reverseFlag ? q.pollLast() : q.poll());
                if(!q.isEmpty()) {
                    sb.append(",");
                }
            }
            //sb.deleteCharAt(sb.length()-1);
            sb.append("]");

            System.out.println(sb);
        }
    }
}
