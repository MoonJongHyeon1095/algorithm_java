import java.util.Collections;
import java.util.Scanner;

public class BOJ2445별찍기8 {

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            String stars = String.join("", Collections.nCopies(i, "*"));
            String spaces = String.join("", Collections.nCopies(2 * (N - i), " "));
            System.out.println(stars + spaces + stars);
        }

        for(int j = 1; j < N; j++) {
            String stars = String.join("", Collections.nCopies(N - j, "*"));
            String spaces = String.join("", Collections.nCopies(2 * j, " "));
            System.out.println(stars + spaces + stars);
        }
    }
}

}
