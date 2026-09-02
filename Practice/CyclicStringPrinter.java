import java.util.Scanner;

public class CyclicStringPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        for(int i = 0;i < n;i++){
            System.out.print(s.charAt(i % s.length()));
        }
    }
}