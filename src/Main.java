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

       for (int i=0;i<lines.length;i++) {
           String[] numbers = "/n".split(" ");
           System.out.println(Arrays.toString(numbers));
       }

          String[] values = new int[numbers[i].length];
          Hand yurr = new Hand(values);
          for (int i = 0; i < values.length; i++) {
              values[i] = String.join(numbers[i]);

               //System.out.println(values[i]);
           }
           System.out.println(Arrays.toString(yurr.getCurrentCards()));
       }
}
