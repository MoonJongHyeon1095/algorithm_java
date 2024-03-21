package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실 {
//    String[][] book_time = {
//            {"15:00", "17:00"},
//            {"16:40", "18:20"},
//            {"14:20", "15:20"},
//            {"14:10", "19:20"},
//            {"18:20", "21:20"}
//    };
//

    public static int solution(String[][] book_time) {

        Arrays.sort(book_time, (a, b) -> splitTimeString(a[0]) - splitTimeString(b[0]));


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String[] time : book_time) {
            int start = splitTimeString(time[0]);
            int end = splitTimeString(time[1]) + 10;

            // pq.peek() 큐의 첫 요소(최소값)를 삭제하지 않고 가져온다. 큐가 비어있으면 null을 반환
            // pq.poll() 큐의 첫 요소(최소값)를 삭제하고 가져온다. 없으면 null
            // 방이 빈 경우
            if (!pq.isEmpty() && start >= pq.peek()) {
                pq.poll();
            }

            pq.add(end);
        }

        return pq.size();

    }


    private static int splitTimeString(String time){
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        return ((Integer.parseInt(hour) * 60) + Integer.parseInt(minute));
    }



}
