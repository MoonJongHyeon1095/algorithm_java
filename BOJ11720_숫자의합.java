import java.util.Scanner;

public class BOJ11720_숫자의합 {
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String sNum = sc.next();

//        char[] cNum = sNum.toCharArray();
        int sum = 0;

        for(int i=0; i<length; i++){
            char c = sNum.charAt(i);
//            System.out.println((int)c); //ASCII로 나온다. 0은 48, 1은 49, 5는 53...
//            sum += (int)c;
            sum += (int)c - '0'; //ASCII숫자로 나온다면, 거기에 문자 '0'의 아스키코드(48)를 빼버린다.
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String sNum = sc.next();

        int sum = 0;
        for(int i=0; i<length; i++){
            char c = sNum.charAt(i);
            int n = Character.getNumericValue(c);
            sum += n;
        }
        System.out.println(sum);
    }
}
