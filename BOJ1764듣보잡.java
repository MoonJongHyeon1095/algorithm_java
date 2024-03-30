import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 26592kb
 * 316ms
 */
public class BOJ1764듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashSet<String> neverHeard = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            neverHeard.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String neverSeen = br.readLine();
            if(neverHeard.contains(neverSeen)) {
                result.add(neverSeen);
            }
        }
        result.sort(Comparator.naturalOrder());

        bw.write(result.size() + "\n");
        for(String name : result) {
            bw.write(name + "\n");
        }

        bw.flush();
        bw.close();

    }
}
