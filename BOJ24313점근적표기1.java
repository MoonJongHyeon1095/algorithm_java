import java.util.Scanner;

/**
 * 메모리 17644kb
 * 시간 216ms
 */

public class BOJ24313점근적표기1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        if(a1*n0+a0 <= c*n0 && c>= a1) {  //c>a1으로 계속 실패. a는 음수일 수 있으므로 7n-7 과 7n 의 경우 a1==c 일 때도 c*n이 더 클 수 있음.
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

}
