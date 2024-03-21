package programmers;

public class LV1_문자열다루기기본 {
    public static boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            int 원본길이 = s.length();
            s = s.replaceAll("\\D", ""); // 숫자가 아닌 문자 제거 후 s에 할당
            return s.length() == 원본길이;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "123456a"; // 입력 문자열
        boolean result = solution(s);
        System.out.println(result);
    }
}
