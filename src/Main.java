import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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


        String[] lines = fileData.split("\n");

        Hand yurr = new Hand(lines);// named yurr cuz idk
        for (String line : lines) {
            String[] parts = line.split("\\|");
            String[] numbers = parts[0].split(","); // numbers[i] is each indivivual thing
            // ex. [1,2,3] numbers[0] = 1

            int bid = Integer.parseInt(parts[1]);

            yurr = new Hand(numbers);//new hand every loop so can use check() on current set of cards

            yurr.check();

        }
        yurr.getHandsAmount(); // pretty formatting
    }

}