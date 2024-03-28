import java.util.Scanner;

/**
 * 메모리 37844kb
 * 시간 523ms
 */
public class BOJ1152단어의개수 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().trim(); // 혹시나 해서 앞 뒤에 공백 제거
            if (input.isEmpty()) { //자꾸 틀려서 인풋이 없는 분기점 만듦
                System.out.print(0);
            } else {
                String[] arr = input.split(" ");
                System.out.print(arr.length);
            }
        }
    }
}
