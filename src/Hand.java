
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

    public Hand(String[] array) {
        currentCards = array;
    }

    public String[] getCurrentCards() {
        //System.out.println(Arrays.toString(currentCards));
        return currentCards;
    }

    public void check() {
        int[] cardsCheck = {0,0,0,0,0};
        for (int i = 0; i < currentCards.length; i++) {
            int count = 0;
            for(int x=0;x<currentCards.length;x++) {
                if (currentCards[i].equals(currentCards[x])) {
                    cardsCheck[i]++;
                }
for(int y=0;y<cardsCheck.length;y++){
    count+= cardsCheck[y];
}
    if(count==5){
        System.out.println("yurr");
        break;
    }
            }
            System.out.println(Arrays.toString(cardsCheck));
        }

    }


}
