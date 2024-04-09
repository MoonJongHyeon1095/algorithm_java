package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *31532kb
 * 548ms
 * 거꾸로 나누어 최적의 조합을 찾는다.
 * 임의의 시간을 각각 나눈다는 것이 좀처럼 떠올리기 쉽지 않음
 * 반복문 탈출 조건이 없으면 자료형 초과
 * 정렬 O(N log N)
 * 탐색 O(N log N)
 */

public class BOJ3079입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] timeArr = new int[N];

        for(int i=0; i<N; i++){
            timeArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(timeArr); //O(N log N)
        System.out.println(parametricSearch(M, timeArr));

    }

    //O(N log N)
    private static long parametricSearch(int needCaptacity, int[] timeArr){
        long low = 0; // 최소 1
        long high = (long)timeArr[timeArr.length-1]*needCaptacity; //최악의 경우

        while (low <= high) {
            long mid = (low + high) / 2;
            long possbleCapacity = 0; //해당 시간 창구 수용가능 인원

            for(int i=0; i<timeArr.length; i++){
                if(possbleCapacity>=needCaptacity){ // 충족하면 탈출 //이 조건이 없으면 누적합이 long 자료형도 벗어남
                    break;
                }

                possbleCapacity += mid/timeArr[i];
            }

            if (possbleCapacity < needCaptacity) {
                low = mid + 1; // 더 긴 시간이 든다
            } else {
                high = mid - 1; // 더 빨리 된다
            }
        }
        //위 while문이 끝난 후의 최소시간
        return low;
    }
}
