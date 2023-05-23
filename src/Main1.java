import java.util.Scanner;

public class Main1 {
    static Scanner scan = new Scanner(System.in);
    static int input;
    public static void main(String[] args) {
        System.out.println("enter a number between 0 and 6 (inclusive)");
        verify();
        System.out.print("The day that matches your number is : ");
        if (input == 0) {
            System.out.println("Monday");
        } else if (input == 1) {
            System.out.println("Tuesday");
        } else if (input == 2) {
            System.out.println("Wednesday");
        } else if (input == 3) {
            System.out.println("Thursday");
        } else if (input == 4) {
            System.out.println("Friday");
        } else if (input == 5) {
            System.out.println("Saturday");
        } else {
            System.out.println("Sunday");
        }
    }
    public static void verify() {
        if (!scan.hasNextInt()){
            scan.next();
            System.out.println("please enter a number");
            verify();
        } else {
            input = scan.nextInt();
            if (input < 0 || input > 6){
                System.out.println("number out of range (0-6)");
                verify();
            }
        }
    }
}
