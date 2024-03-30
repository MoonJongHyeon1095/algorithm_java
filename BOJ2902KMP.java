import java.util.Scanner;

/**
 * 17652kb
 * 204ms
 */
public class BOJ2902KMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[]names = sc.nextLine().split("-");

        StringBuilder sb = new StringBuilder();
        for(String name : names){
            sb.append(name.charAt(0));
        }
        System.out.println(sb);
    }

}

