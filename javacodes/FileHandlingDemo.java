import java.io.*;
import java.util.Scanner;

public class FileHandlingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks: ");
            String marks = sc.nextLine();

            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Marks: " + marks);
            writer.newLine();
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\nContents of " + fileName + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        sc.close();
    }
}
