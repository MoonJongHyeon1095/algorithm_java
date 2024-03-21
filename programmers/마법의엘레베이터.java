package programmers;

public class 마법의엘레베이터 {

    public int solution(int storey) {
        int stones = 0;

        while (storey > 0) {
            // 현재 자리 숫자
            int digit = storey % 10;
            // 다음 자리로 이동
            storey /= 10;

            if (digit > 5) {
                stones += (10 - digit);
                storey += 1; // 다음 자리수에 +1
            } else {
                stones += digit;
            }
        }

        return stones;
    }

    //555의 경우 14, 귀찮아 안함

}
