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
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        //System.out.println(fileData);
        String[] lines = fileData.split("\n");
Hand yurr;
        for (String line : lines) {
          String[]numbers = line.split(" "); // numbers[i] is each indivivual thing
            // ex. [1,2,3] numbers[0] = 1
             yurr = new Hand(numbers);

            System.out.println(Arrays.toString(yurr.currentCards));

      //      for(int i=0;i<numbers.length;i++){
                System.out.println(numbers[0]);
      //  }

        }


    }

}