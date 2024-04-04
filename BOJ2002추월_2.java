//import java.io.*;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Queue;
//
//public class BOJ2002추월_2 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//
//        Map<String, Integer> enterMap = new HashMap<>();
//
//        for (int i = 0; i < N; i++) {
//            enterMap.put(br.readLine(), i);
//        }
//
//        int count = 0;
//        for (int i = 0; i < N; i++) {
//
//            if(enterMap.get(br.readLine()) != i ){
//                count++;
//            }
//        }
//
//        bw.write(count + "\n");
//        bw.flush();
//        bw.close();
//    }
//}
