


import java.util.Arrays;


public class Hand {
    //brainstorming for pt2
    // grab values from index  and check which hand
    //along woitb saving
//    int A=1;
//    int J=11;
//    int Q=12;
//    int K=13;
// nt[] allCards={A,2,3,4,5,6,7,8,9,10,J,Q,K};

    String[] currentCards = null;
    static int[] handsAmount = {0, 0, 0, 0, 0, 0, 0};// static cuz we want to know hom manuy intotal across all hands

    public Hand(String[] array) {
        currentCards = array;
    }

//pretty display
    public void getHandsAmount() {
        System.out.println("Number of five of a kind hands: " + handsAmount[0]);
        System.out.println("Number of full house hands: " + handsAmount[1]);
        System.out.println("Number of four of a kind hands: " + handsAmount[2]);
        System.out.println("Number of three of a kind hands: " + handsAmount[3]);
        System.out.println("Number of two of a kind hands: " + handsAmount[4]);
        System.out.println("Number of one pair hands: " + handsAmount[5]);
        System.out.println("Number of high card hands: " + handsAmount[6]);
        System.out.println(Arrays.toString(handsAmount));

    }

    public void check() { // checks cards based of ma method ( annoying to make)
        int[] cardsCheck = {0, 0, 0, 0, 0}; // max unique cardis 5 ( might have to rework for to i can record which card is chosen
        boolean[] checked = {false, false, false, false, false}; // record what cards already checkd so no weird dupes
        int[] fiveOfAKind = {5, 0, 0, 0, 0};
        int[] fourOfAKind = {4, 1, 0, 0, 0};
        int[] fullHouse = {3, 2, 0, 0, 0};
        int[] threeOfAKind = {3, 1, 1, 0, 0};
        int[] twoPair = {2, 2, 1, 0, 0};
        int[] onePair = {2, 1, 1, 1, 0};
        int[] highCard = {1, 1, 1, 1, 1};
        int totalCount = 0;

        for (int i = 0; i < currentCards.length; i++) {

            if (checked[i] == false) {

                for (int x = 0; x < currentCards.length; x++) {
                    if (checked[x] == false && currentCards[i].equals(currentCards[x])) { // if i have not already checked this card check and see how many time appear
                        cardsCheck[i]++;
                        checked[x] = true;
                        totalCount++;
                    }
                }
            }
            if (totalCount == 5) { //hand size limit is 5
                break;
            }
        }
        sort(cardsCheck);
        // save which type of hand and records
        if (Arrays.equals(cardsCheck, fiveOfAKind)) {
            handsAmount[0]++;
        } else if (Arrays.equals(cardsCheck, fourOfAKind)) {
            handsAmount[1]++;
        } else if (Arrays.equals(cardsCheck, fullHouse)) {
            handsAmount[2]++;
        } else if (Arrays.equals(cardsCheck, threeOfAKind)) {
            handsAmount[3]++;
        } else if (Arrays.equals(cardsCheck, twoPair)) {
            handsAmount[4]++;
        } else if (Arrays.equals(cardsCheck, onePair)) {
            handsAmount[5]++;
        } else if (Arrays.equals(cardsCheck, highCard)) {
            handsAmount[6]++;
        }
    }
//sort lists into descending order to check hand easily
    public void sort(int[] arr) { // this lowkey could be useful for pt 2, maybe( problem for later)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}
