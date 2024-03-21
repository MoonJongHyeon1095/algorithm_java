package programmers;

public class 숫자카드나누기 {
    private static boolean dividable(int[] arr, int num){
        for(int n : arr){
            if(n%num == 0) continue;
            else return false;
        }

        return true;
    }

    private static boolean undividable(int[] arr, int num){
        for(int n : arr){
            if(n%num != 0) continue;
            else return false;
        }

        return true;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int num = Math.max(arrayA[0], arrayB[0]);

        //소인수 구하기
        for(int i=2; i<=num; i++){
            if((dividable(arrayA, i) && undividable(arrayB,i)) ||
                    (dividable(arrayB, i) && undividable(arrayA,i))){
                answer = i;
            }
        }
        return answer;
    }


}
