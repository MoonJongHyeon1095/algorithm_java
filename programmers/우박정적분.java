package programmers;

import java.util.ArrayList;
import java.util.List;

public class 우박정적분 {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        List<Integer> yList = new ArrayList<>();

        while(k > 1){
            yList.add(k);

            if(k % 2 == 0){
                k /= 2;
            }else{
                k = k * 3 + 1;
            }
        }

        //k=1
        yList.add(k);

        int n = yList.size()-1;

        for(int i = 0; i < ranges.length; i++){
            // 유효하지 않은 구간 -1
            if(ranges[i][0] > ranges[i][1] + n){
                answer[i] = -1;
                continue;
            }else if(ranges[i][0] == ranges[i][1] + n){
                answer[i] = 0;
                continue;
            }

            double 총넓이 = 0;
            for(int j = ranges[i][0]; j < ranges[i][1] + n; j++){
                총넓이 += (yList.get(j) + yList.get(j + 1)) / 2.0;
            }

            answer[i] = 총넓이;

        }


        return answer;
    }


}
