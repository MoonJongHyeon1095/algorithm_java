import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 14696kb
 * 148ms
 * 단순하지만 의외로 대단히 어렵게 풀었다.
 */
public class BOJ2304창고다각형 {
    private static class Column {
        int L, H;

        Column(int L, int H) {
            this.L = L;
            this.H = H;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Column> columns = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            columns.add(new Column(L, H));
        }
        br.close();

        Collections.sort(columns, Comparator.comparingInt(c -> c.L));

        int maxHeight = 0, highestIndex = 0;
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).H > maxHeight) {
                maxHeight = columns.get(i).H;
                highestIndex = i;
            }
        }

        int totalArea = 0;
        // 왼쪽 부분 면적 계산
        int prevH = 0, prevL = columns.get(0).L;
        for (int i = 0; i <= highestIndex; i++) {
            if (columns.get(i).H > prevH) {
                totalArea += (columns.get(i).L - prevL) * prevH; // 면적부터 계산, 마지막 기둥 미포함
                prevH = columns.get(i).H;
                prevL = columns.get(i).L; //마지막 반복에서 가장 큰 기둥 왼쪽 인덱스
            }
        }

        // 오른쪽 부분 면적 계산
        prevH = 0;
        int rightPrevL = columns.get(columns.size() - 1).L;
        for (int i = columns.size() - 1; i >= highestIndex; i--) {
            if (columns.get(i).H > prevH) {
                totalArea += (rightPrevL - columns.get(i).L) * prevH;
                prevH = columns.get(i).H;
                rightPrevL = columns.get(i).L; //마지막 반복에서 가장 큰 기둥 오른쪽 인덱스
            }
        }

        // (오른쪽면적 마지막 위치 - 왼쪽면적 마지막 위치) * 최대기둥높이 // 가장 높은 기둥이 여러개 일 수 있다.
        totalArea += (rightPrevL - prevL + 1) * maxHeight;

        System.out.println(totalArea);
    }
}


