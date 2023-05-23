import java.util.Scanner;

public class HW22_5 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        boolean A, B, C, D;
        System.out.println("enter value for A");
        verify();
        A = scan.nextBoolean();
        System.out.println("enter value for B");
        verify();
        B = scan.nextBoolean();
        System.out.println("enter value for C");
        verify();
        C = scan.nextBoolean();
        System.out.println("enter value for D");
        verify();
        D = scan.nextBoolean();
        System.out.println("printing logic test results");
        System.out.println("B || C = " + (B || C));
        System.out.println("A && B || C = " + (A && B || C));
        System.out.println("A && B || C && D = " + (A && B || C && D));
    }
    public static void verify() {
        if (!scan.hasNextBoolean()){
            scan.next();
            System.out.println("please enter 'true' or 'false'");
            verify();
        }
    }
}
