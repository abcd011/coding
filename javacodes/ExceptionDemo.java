import java.util.Scanner;
import java.util.InputMismatchException;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, result = 0;

        try {
            System.out.print("Enter first number: ");
            a = sc.nextInt();
            System.out.print("Enter second number: ");
            b = sc.nextInt();
            sc.close();

           

            result = a / b;
            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
}
