package programmers;

import java.util.Scanner;
import java.util.Stack;

public class 제로 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            int num = scanner.nextInt(); // K개의 줄 동안 정수를 입력받음

            if (num == 0) {
                if (!stack.isEmpty()) { // 스택이 비어있지 않다면 가장 최근에 쓴 수를 지움
                    stack.pop();
                }
            } else {
                stack.push(num); // 0이 아니면 해당 수를 스택에 추가
            }
        }

        for (Integer num : stack) {
            sum += num;
        }

        System.out.println(sum);
    }
}
