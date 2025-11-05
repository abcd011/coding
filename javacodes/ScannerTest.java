
import java.util.Scanner;

public class ScannerTest{
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String x = myScanner.nextLine();
        System.out.println(x);
        myScanner.close();
        System.out.println(Math.PI*2);
    }
}