import java.util.*;

public class Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        for(int ctr = 1 ; ctr < (1<<len) ; ctr++) {
            String combi = "";
            for(int sh = 0 ; sh < len ; sh++) {
                if((ctr & (1<<sh)) > 0) {
                    combi += s.charAt(sh);
                }
            }
            System.out.println(combi);
        }
        sc.close();
    }
}