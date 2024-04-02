import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1244스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int switchNum = Integer.parseInt(st.nextToken());
        boolean[] switchArr = new boolean [switchNum];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<switchNum; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken()) == 1; //ture or false
        }

        st = new StringTokenizer(br.readLine());
        int studentNum = Integer.parseInt(st.nextToken());
        int[][] studentArr = new int [studentNum][2];

        for(int i=0; i<studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            studentArr[i][0] = Integer.parseInt(st.nextToken()); //셩별
            studentArr[i][1] = Integer.parseInt(st.nextToken()); //숫자
        }

        for(int[] student : studentArr){
            switch(student[0]){
                case 1: maleSwitch(switchArr, student[1]);
                break;
                case 2: femaleSwitch(switchArr, student[1]);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < switchArr.length; i++){
            sb.append(switchArr[i] ? "1" : "0").append(" ");
            if ((i + 1) % 20 == 0) {
                sb.append("\n"); // 20개씩
            }
        }
        System.out.println(sb);
    }

    private static void maleSwitch(boolean[] switchArr, int receivedNum){

        for(int i = 1; i <= switchArr.length; i++){
            if(i%receivedNum == 0){
                switchArr[i - 1] = !switchArr[i - 1];
            }
        }
    }

    private static void femaleSwitch(boolean[] switchArr, int receivedNum){
        //int idxLimit = Math.min(receivedNum-1, switchArr.length - receivedNum);
        int receivedIdx = receivedNum - 1;
        int leftIdx = receivedIdx - 1;
        int rightIdx = receivedIdx + 1;
        //가운데
        switchArr[receivedIdx] = ! switchArr[receivedIdx];

        //양옆
        while(leftIdx >= 0 && rightIdx < switchArr.length && switchArr[leftIdx] == switchArr[rightIdx]){
            switchArr[leftIdx] = !switchArr[leftIdx];
            switchArr[rightIdx] = !switchArr[rightIdx];
            leftIdx--;
            rightIdx++;
        }

    }

}
