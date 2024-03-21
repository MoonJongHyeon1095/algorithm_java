package programmers;

import java.util.ArrayList;
import java.util.List;

public class 광물캐기 {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int diaPick = picks[0];
        int ironPick = picks[1];
        int stonePick = picks[2];

        List<List<String>> partsList = splitBy5(minerals);

        //이 예외처리를 하지 않으면, 곡괭이가 없어 못캐는 뒷부분도 정렬되어 버린다. 미리 빼고 정렬해야 한다.
        int totalPicks = diaPick + ironPick + stonePick;
        if (totalPicks < partsList.size()) {
            partsList = partsList.subList(0, totalPicks);
        }

        partsList.sort((a,b) -> useStonePick(b) - useStonePick(a));

        //&& i < partsList.size() 가 없으면 곡갱이수 > partsList 인 경우 index out of bounds exception
        for (int i = 0; i < diaPick && i < partsList.size(); i++) {
            answer += useDiaPick(partsList.get(i));
        }

        for (int i = diaPick; i < diaPick + ironPick && i < partsList.size(); i++) {
            answer += useIronPick(partsList.get(i));
        }

        for (int i = diaPick + ironPick; i < diaPick + ironPick + stonePick && i < partsList.size(); i++) {
            answer += useStonePick(partsList.get(i));
        }


        return answer;

    }

    private static int useDiaPick(List<String> arr){
        int score = 0;
        label:
        for (String m : arr) {
            switch (m) {
                case "diamond":
                    score += 1;
                    break;
                case "iron":
                    score += 1;
                    break;
                case "stone":
                    score += 1;
                    break;
                default:
                    break label;
            }
        }
        return score;
    }

    private static int useIronPick(List<String> arr){
        int score = 0;
        label:
        for (String m : arr) {
            switch (m) {
                case "diamond":
                    score += 5;
                    break;
                case "iron":
                    score += 1;
                    break;
                case "stone":
                    score += 1;
                    break;
                default:
                    break label;
            }
        }
        return score;
    }




    private static int useStonePick(List<String> arr) {
        int score = 0;
        label:
        for (String m : arr) {
            switch (m) {
                case "diamond":
                    score += 25;
                    break;
                case "iron":
                    score += 5;
                    break;
                case "stone":
                    score += 1;
                    break;
                default:
                    break label;
            }
        }
        return score;
    }

    private static List<List<String>> splitBy5(String[] minerals){
        List<List<String>> partsList = new ArrayList<>();
        List<String> part = new ArrayList<>();

        for (String mineral : minerals) {
            part.add(mineral);
            if (part.size() == 5) {
                partsList.add(new ArrayList<>(part));
                part.clear();
            }
        }

        //5개가 안되면
        if(!part.isEmpty()){
            while(part.size() < 5){
                part.add("");
            }
            partsList.add(part);
        }

        return partsList;
    }

}
