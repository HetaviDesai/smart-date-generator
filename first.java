import java.util.*;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c;

        System.out.println("Enter a:");
        int a = sc.nextInt();

        System.out.println("Enter b:");
        int b = sc.nextInt();

        System.out.println("Enter operation from +, -, *, /, %:");
        char op = sc.next().charAt(0);

        if (op == '+') {
            c = a + b;
            System.out.println("Answer: " + c);
        } else if (op == '-') {
            c = a - b;
            System.out.println("Answer: " + c);
        } else if (op == '*') {
            c = a * b;
            System.out.println("Answer: " + c);
        } else if (op == '/') {
            c = a / b;
            System.out.println("Answer: " + c);
        } else if (op == '%') {
            c = a % b;
            System.out.println("Answer: " + c);
        } else {
            System.out.println("Invalid operator!");
        }

        sc.close();
    }
}
