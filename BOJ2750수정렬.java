import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2750수정렬 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] arr = new int[length];

        for(int i=0; i<length; i++){
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);
        for(int el : arr){
            System.out.println(el);
        }
    }

    public static void main2(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int num = input.nextInt();
            arr.add(num);
        }
        Collections.sort(arr);
        for(int el : arr){
            System.out.println(el);
        }

    }
}
