import java.util.Scanner;

public class P19242007년 {
    public class Main{
        private static final String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        private static final int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();

            int totalDays = getTotalDays(x, y);
            int n = totalDays % 7;
            System.out.print(n == 0 ? days[6] : days[n-1]);
        }

        private static int getTotalDays(int x, int y) {
            int sum = 0;
            for (int i = 0; i < x - 1; i++) {
                sum += months[i];
            }
            return sum + y;
        }

    }
}
