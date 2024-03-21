package programmers;
import java.util.Scanner;
public class LV0_직사각형별찍기 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        int numColumns = sc.nextInt();
        int numRows = sc.nextInt();
//        int numColumns = 5;
//        int numRows = 3;

        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < numColumns; i++) {
            stars.append("*");
        }

        for (int i = 0; i < numRows; i++) {
            System.out.println(stars.toString());
        }
}

}
