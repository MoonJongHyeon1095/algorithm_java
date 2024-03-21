package programmers;

public class 콜라츠추측 {
    public int solution(int num) {
        int answer = 0;

        //int 형 범위를 넘어가서 특정 케이스에서 오버플로우
        long n = num;

        if(num ==1){
            return 0;
        }


        while(n != 1) {
            if(answer == 500){
                return -1;
            }

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            answer++;
        }

        return answer;
    }
}
