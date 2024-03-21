package programmers;

import java.util.ArrayList;
import java.util.Collections;

// 문제 오류. 임의로 골라 두 그룹을 곱하는게 아니라 가장 큰 두 그룹이어야 한다.
public class 혼자놀기의달인 {

    private boolean[] opened;
    private int[] cards;
    private ArrayList<Integer> groupSizes;

    public int solution(int[] cards) {

        this.cards = cards;
        this.opened = new boolean[cards.length];
        this.groupSizes = new ArrayList<>();

        // 모든 상자를 순회하며 아직 열리지 않은 상자에서 시작하는 새 그룹 찾기
        for (int i = 0; i < cards.length; i++) {
            if (!opened[i]) {
                repeatOpenBox(i);
                groupSizes.add(countOpenedBoxes() - sum(groupSizes)); // 새로운 그룹의 크기를 추가
            }
        }


        // 가장 큰 두 개의 그룹 크기를 찾아 곱하기
        if (groupSizes.size() >= 2) {
            Collections.sort(groupSizes, Collections.reverseOrder()); // 그룹 크기 내림차순 정렬
            return groupSizes.get(0) * groupSizes.get(1); // 가장 큰 두 개
        }

        return 0;

//        int randomIndex = 0;
//        repeatOpenBox(randomIndex);
//        int count1 = countOpenedBoxes();

//        if(count1 == cards.length) return 0;
//
//        int randomIndex2 = findUnopenedIndex();
//        repeatOpenBox(randomIndex2);
//        int count2 = countOpenedBoxes() - count1;
//
//        return count1 * count2;
    }

    private void repeatOpenBox(int boxIndex){
        int nxtIndex = cards[boxIndex] - 1;

        if(opened[boxIndex]) return;

        opened[boxIndex] = true;
        repeatOpenBox(nxtIndex);

    }

    private int countOpenedBoxes() {
        int count = 0;
        for (boolean isOpened : opened) {
            if (isOpened) {
                count++;
            }
        }
        return count;
    }

//    private int findUnopenedIndex() {
//        for (int i = 0; i < opened.length; i++) {
//            if (!opened[i]) {
//                return i; // 첫 번째로 발견된 false의 인덱스 반환
//            }
//        }
//        return -1; // 모든 상자가 열렸음을 나타내는 -1 반환
//    }

    private int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}
