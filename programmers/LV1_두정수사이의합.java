package programmers;

public class LV1_두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
//        if(a < b){
//            for(int i = a; i<= b; i++){
//                answer += i;
//            }
//        }else if(a > b){
//            for(int i = b; i <= a; i++){
//                answer += i;
//            }
//        }else{
//            answer = a;
//        }

        if(a!=b){
            for(int i=Math.min(a,b);i<=Math.max(a,b);i++){
                answer+=i;
            }
        }else{
            answer=a;
        }
        return answer;
    }
}
