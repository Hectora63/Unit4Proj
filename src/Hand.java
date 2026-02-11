


import java.util.Arrays;


public class Hand {
// keep variable og current one, check agains all until it is bigger then swap
    //the smaller one is then compared to the others unto none left then deleetd/ not used


    String[] currentCards = null;
    static int[] handsAmount = {0, 0, 0, 0, 0, 0, 0};// static cuz we want to know hom manuy intotal across all hands
    static int[][] placement = new int[5][2];    // [position], [Hand strength ,card that repeats,bid]
static int[][] extras= ;

    int bid;// ex hand.{2,2,2,1,3} ex hand2. {3,3,4,5,6}
    //{ ---,---,---,[4,2],[2,3]}
    //        (3,1,0,0,0)|(6,5,4,0,0,)

    public Hand(String[] array,int bid) {
        currentCards = array;
        this.bid=bid;
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
        int[][] listOfHands = {
                {5,0,0,0,0}, // five of a kind
                {3,2,0,0,0}, // full house
                {4,1,0,0,0}, // four of a kind
                {3,1,1,0,0}, // three of a kind
                {2,2,1,0,0}, // two pair
                {2,1,1,1,0}, // one pair
                {1,1,1,1,1}  // high card
        };
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
        int strength=0;
        for(int i=6;i>=0;i--){
            if (Arrays.equals(cardsCheck, listOfHands[i])) {
                handsAmount[i]++;
                strength = i+1;
            }
        }


    }

    //sort lists into descending order to check hand easily
    static public void sort(int[] arr) { // this lowkey could be useful for pt 2, maybe( problem for later)
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

    public int mainCard(){

        return 0;
    }

    public void findPlacement(int strenght) {

        for(int position = 0; position <placement.length; position++) {
            if (strenght > placement[position][0]) {

            }
        }
//save the stregnth and the added values in placement the compare to figure out 1-5 rsnking
//finds a wau to push down all values below the one that is bigger ( say new > position 2__ push position 3-4 down and delete 5)

    }


    //pt 3 if four of a kind and if there is a j ;== five of a kind

}
