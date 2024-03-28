
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BOJ2477참외밭 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int K = sc.nextInt();
            int 파먹은사각형 = 0;
            ArrayList<Integer> directions = new ArrayList<>();
            ArrayList<Integer> lengths = new ArrayList<>();


            for (int i = 0; i < 6; i++) {
                int direction = sc.nextInt();
                int length = sc.nextInt();
                directions.add(direction);
                lengths.add(length);
            }

            for (int i = 0; i < 6; i++) {
                // 반대편 변을 찾아 그 면적을 뺌
                if (Objects.equals(directions.get((i) % 6), directions.get((i + 2) % 6)) && Objects.equals(directions.get((i + 1) % 6), directions.get((i + 3) % 6))) {
                    파먹은사각형 = lengths.get(i+1) * lengths.get(i+2);
                    break;
                }
            }

            lengths.sort((a,b)-> b-a);
            int 큰사각형 = lengths.get(0) * lengths.get(1);


            System.out.println((큰사각형 - 파먹은사각형)*K);

        }

    }
}
