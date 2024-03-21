import java.util.Arrays;
import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int arr[] = new int [length];
        for(int i=0; i<length; i++){
            arr[i]= sc.nextInt();
        }
        long sum = 0;
        long max = 0;

        //최대값 방법1
        for(int i=0; i<length; i++){
            if(arr[i] > max){
                max = arr[i];
                sum = sum + arr[i];
            }
        }

        //최대값 방법2
        Arrays.sort(arr);
        max= arr[arr.length-1]; // 최대값
        //min = arr[0]

        //최대값 방법3
        max = Arrays.stream(arr).max().getAsInt();
        sum = Arrays.stream(arr).sum();

        System.out.println(sum * 100.0 / max / length); //100.0 으로 곱하면, double 형으로 자동으로 계산

    }
}
