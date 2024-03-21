package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디펜스게임 {

    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i;

        if (k == enemy.length) {
            return enemy.length;
        }

        for(i = 0; i < enemy.length; i++){
            n -= enemy[i];
            pq.add(enemy[i]);

            if(n < 0){
                if(k > 0){
                    k--;
                    n += pq.poll();
                }else{
                    break;
                }
            }
        }

        return i;
    }
}
