import java.util.Scanner;

public class BOJ2745진법변환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(" ");
        char[] str = parts[0].toCharArray();
        int radix = Integer.parseInt(parts[1]);

        //메서드가 참 좋다. 그냥 이렇게 해도 되긴 함
        //System.out.println(Integer.parseInt(letters, radix));

        int j=0;//제곱 수
        long result=0;

        for(int i=str.length-1;i>=0;i--){
            if(str[i]>='0'&&str[i]<='9'){
                result+= (long) (str[i] - '0') * (long)Math.pow(radix,j);
            }else {
                result+= (long) (str[i] - 'A' + 10) *(long) Math.pow(radix,j);
            }
            j++;
        }//타입 통일
        System.out.println(result);

    }
}
