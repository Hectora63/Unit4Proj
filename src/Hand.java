
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Hand {
    // grab values from index  and check which hand
    //along woitb saving
//    int A=1;
//    int J=11;
//    int Q=12;
//    int K=13;
// nt[] allCards={A,2,3,4,5,6,7,8,9,10,J,Q,K};
    String[] currentCards = null;
int[] checkAmount= new int[4];
    public Hand(String[] array) {
        currentCards = array;
    }

    public String[] getCurrentCards() {
        //System.out.println(Arrays.toString(currentCards));
return currentCards;
    }

    public void check() {
        for(int i=0;i<currentCards.length;i++) {
        try {
            File f = new File(currentCards[i]);
            Scanner s = new Scanner(f);
        }
       catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
    }
    }


}
