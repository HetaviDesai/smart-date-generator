
import java.util.*;

public class practice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number");
        int n = sc.nextInt();
        sc.close();
        int rev = 0;
        while (n != 0) {
            int ld = n % 10;
            rev = rev * 10 + ld;
            n = n / 10;
        }
        System.out.print(rev);
    }
}
