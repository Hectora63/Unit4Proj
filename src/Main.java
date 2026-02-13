import java.io.File;
import java.io.FileNotFoundException;
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

        String[] lines = fileData.split("\n");

        // make array size equal to amount of hands
        Hand[] yurr = new Hand[lines.length];

        for (int i = 0; i < lines.length; i++) {

            String[] parts = lines[i].split("\\|");
            String[] numbers = parts[0].split(","); // numbers[i] is each individual thing
            int bid = Integer.parseInt(parts[1]);

            // new hand every loop so can use check() on current set of cards
            yurr[i] = new Hand(numbers, bid);

            yurr[i].check(); // determines strength + ordered cards
        }

        // ---------- RANKING SYSTEM ----------

        int[] ranks = new int[yurr.length];

        for (int i = 0; i < yurr.length; i++) {

            int rank = 1; // weakest = 1

            for (int j = 0; j < yurr.length; j++) {

                if (i != j) {

                    // if another hand stronger increase rank
                    if (yurr[j].isStrongerThan(yurr[i])) {
                        rank++;
                    }
                }
            }

            ranks[i] = rank;
        }

        // ---------- TOTAL WINNINGS ----------

        long total = 0;

        for (int i = 0; i < yurr.length; i++) {
            total += (long) ranks[i] * yurr[i].getBid();
        }
        Hand.displayHandsAmount();
        System.out.println("Total Winnings: " + total);



    }
}
