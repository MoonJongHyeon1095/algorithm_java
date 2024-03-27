import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P25206너의평점은 {

    public class Main{
        public static Map<String, Double> gradeMap;

        static {
            gradeMap = new HashMap<>();
            gradeMap.put("A+", 4.5);
            gradeMap.put("A0", 4.0);
            gradeMap.put("B+", 3.5);
            gradeMap.put("B0", 3.0);
            gradeMap.put("C+", 2.5);
            gradeMap.put("C0", 2.0);
            gradeMap.put("D+", 1.5);
            gradeMap.put("D0", 1.0);
            gradeMap.put("F", 0.0);
        }


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double 점수누적 = 0.0;
            double 학점누적 = 0.0;

            while(sc.hasNextLine()) {
                String line = sc.nextLine();

                String[] parts = line.split(" ");
                String 과목 = parts[0];
                double 학점 = Double.parseDouble(parts[1]);
                String 등급 = parts[2];

                if (!"P".equals(등급)) {
                    double 평점 = gradeMap.get(등급);
                    점수누적 += (학점 * 평점);
                    학점누적 += 학점;
                }
            }
            System.out.println(점수누적 / 학점누적);
        }
    }
}
