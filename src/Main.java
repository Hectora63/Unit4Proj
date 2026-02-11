import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        int bid=0;
        String[] lines = fileData.split("\n");
        Hand yurr = new Hand(lines,bid);// named yurr cuz idk

        for (String line : lines) {

            String[] parts = line.split("\\|");
            String[] numbers = parts[0].split(","); // numbers[i] is each indivivual thing
            // ex. [1,2,3] numbers[0] = 1

             bid = Integer.parseInt(parts[1]);

            yurr = new Hand(numbers,bid);//new hand every loop so can use check() on current set of cards

            yurr.check();

        }
        yurr.getHandsAmount(); // pretty formatting
    }

}