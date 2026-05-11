import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select operator:");
        System.out.println("1. ADDITION");
        System.out.println("2. SUBTRACTION");
        System.out.println("3. MUTIPLICATION");
         System.out.println("4. DIVISION");
        


        System.out.print("Enter your choice (make valid choice):");
        int choice = sc.nextInt();

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        switch (choice) {
            case 1:
                int result = num1 + num2;
                System.out.println("Result = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("Result = " + result);
                break;
             case 3:
                result = num1 * num2;
                System.out.println("Result = " + result);
                break;
                case 4:
                result = num1 / num2;
                System.out.println("Result = " + result);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
