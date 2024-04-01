import java.util.*;

/**
 * 18632kb
 * 236ms
 */
public class BOJ2566최댓값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0 ; i< 81; i++){
            int num = sc.nextInt();
            pq.add(num);
            map.put(num, i);
        }

        int max = pq.poll();
        int idx = map.get(max);
        int row = idx / 9 + 1;
        int col = idx % 9 + 1;

        System.out.println(max);
        System.out.println(row + " " + col);
    }
}
