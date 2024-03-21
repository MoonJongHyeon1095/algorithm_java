package programmers;

public class 하샤드수 {
    public boolean solution(int x) {

        String str = Integer.toString(x);
        char[] chars = str.toCharArray();

        int sum = 0;
        // 각 숫자를 정수로 변환 후 더하기
        for (char c : chars) {
            sum += Character.getNumericValue(c);
        }
       return x % sum == 0 ? true : false;

    }
}
