package programmers;

public class LV1_수박수박 {
    public static void main(String[] args) {
        int n = 5; // 입력 값
        String result = solution(n);
        System.out.println(result);
    }

    public static String solution(int n) {
        String string = "수박";
        StringBuilder s = new StringBuilder();

        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                s.append(string);
            }
        } else {
            for (int i = 0; i < (n - 1) / 2; i++) {
                s.append(string);
            }
            s.append("수");
        }
        return s.toString();
    }
}





