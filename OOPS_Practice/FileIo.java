
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("hero.txt", true))){
            System.out.print("Enter the text:");
            String text = sc.nextLine();

            writer.write("Text: " + text);
            System.out.println("File written successfully");
        } catch(IOException e){
            System.out.printf("Error: %s", e.getMessage());
        }


        try(BufferedReader reader = new BufferedReader(new FileReader("hero.txt"))) {
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }
}
