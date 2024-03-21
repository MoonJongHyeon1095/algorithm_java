package programmers;

public class LV1_부족한금액계산 {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long cost = 0;
        for (int i = 0; i < count; i++) {
            cost += price * (i + 1);
        }

        long saving = money - cost;

        if (saving < 0) {
            answer = -1 * saving;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        LV1_부족한금액계산 solution = new LV1_부족한금액계산();
        int price = 3;
        int money = 20;
        int count = 4;
        long result = solution.solution(price, money, count);
        System.out.println(result);
    }
}