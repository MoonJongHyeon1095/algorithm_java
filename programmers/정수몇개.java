package programmers;

import java.util.Scanner;

public class 정수몇개 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int [N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();

        }

        int v = scanner.nextInt();

        for(int e : arr) {
            if(e == v) count++;
        }

        System.out.println(count);
    }

}
