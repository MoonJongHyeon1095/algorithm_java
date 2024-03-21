package programmers;

public class 점찍기 {
    public long solution(long k, long d) {
        //x^2 + y^2 <= d^2
        //x = k*n

        long answer = 0;

        for(long i = 0; i*k<=d; i++){
            long x = k * i;

            //x^2 + y^2 <= d^2
            long y = (long) Math.sqrt( Math.pow(d, 2) - Math.pow(x, 2)) / k;

            answer += y + 1;
        }


    return answer;
    }
}
