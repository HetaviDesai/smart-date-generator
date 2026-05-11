import java.util.*;
import java.util.random.*;
public class guess {
    public static void main(String[] args) {
        //random number
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int randomNumber = rand.nextInt(100)+1;
        int guess =0;
        int attemps =0;
        
        System.out.println("Guess number between 1-100 ");

        while(guess !=randomNumber){
            System.out.print("Enter your Guess ");
            guess = sc.nextInt();
            attemps++;

            if(guess <randomNumber){
                System.out.println("Guess bigger number ");
            }
            else if(guess> randomNumber){
                System.out.println("Guess smaller number ");
            }
            else{
                System.out.println("You Guess Right!! ");
            }
        }
        sc.close();
    }
}
