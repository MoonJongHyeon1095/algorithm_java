package programmers;

import java.util.Arrays;
import java.util.List;

public class LV1_서울에서김서방찾기 {
    public String solution(String[] seoul) {
        List<String> 서울 = Arrays.asList(seoul);
        int index = 서울.indexOf("Kim");
        return "김서방은 " + index + "에 있다";
    }
}
