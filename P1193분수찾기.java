import java.util.Scanner;

public class P1193분수찾기 {


    public class Main {

        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int X = in.nextInt();

            int level = 1, acc = 0;

            while (true) {

                if (X <= acc + level) {
                    if(level%2 ==1){
                        System.out.print((level - (X - acc - 1)) + "/" + (X - acc));
                        break;
                } else {
                    System.out.print((X - acc) + "/" + (level - (X - acc - 1)));
                    break;
                }

                } else {

                    acc += level;
                    level++;
                }
            }
        }
    }
}
