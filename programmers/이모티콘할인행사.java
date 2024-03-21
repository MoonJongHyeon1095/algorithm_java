package programmers;

public class 이모티콘할인행사 {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        int dc10 = 0;
        int dc20 = 0;
        int dc30 = 0;
        int dc40 = 0;

        for(int i = 0; i < users.length; i++) {
            int d = users[i][0];
            if (d > 30) {
                dc40 += 1;
            } else if (30>=d && d > 20) {
                dc30 += 1;
            } else if (20>= d && d > 10) {
                dc20 += 1;
            } else {
                dc10 += 1;
            }
        }

        return answer;
    }


}
