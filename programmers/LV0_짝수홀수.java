package programmers;

public class LV0_짝수홀수 {

    public String solution(int num) {
        if(num>0) {
            return num % 2 == 1 ? "Odd" : "Even";
        }else{
            return num % 2 == -1 ? "Odd" : "Even";
        }
    }

}
