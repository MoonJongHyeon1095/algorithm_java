package programmers;

public class LV1_문자열내p와y의개수 {
    public static void main(String[] args) {
        String s = "pPyyppy"; // 입력 문자열
        boolean result = solution(s);
        System.out.println(result);
    }

    public static boolean solution(String s) {
         s = s.toLowerCase();
//        int nump = s.replaceAll("(?i)[^p]", "").length();
//        int numy = s.replaceAll("(?i)[^y]", "").length();
        int nump = s.replaceAll("[^p]", "").length();
        int numy = s.replaceAll("[^y]", "").length();

        return nump == numy;
    }
}
