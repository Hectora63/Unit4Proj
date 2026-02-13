import java.util.Arrays;

public class Hand {

    private int[] cards = new int[5];
    private int[] ordered = new int[5]; // sorted by freq then value
    private int bid;
    public int strength; // hand type value

    public static int[] handsAmount = new int[7]; // tracks how many of each type

    public Hand(String[] numbers, int bid) {

        for (int i = 0; i < 5; i++) {

            try {
                // try converting raw data first
                cards[i] = Integer.parseInt(numbers[i]);

            } catch (NumberFormatException e) {

                // convert big cards into numeric values
                String card = numbers[i].toUpperCase();

                if (card.equals("JACK"))
                    cards[i] = 11;

                else if (card.equals("QUEEN"))
                    cards[i] = 12;

                else if (card.equals("KING"))
                    cards[i] = 13;

                else if (card.equals("ACE"))
                    cards[i] = 14; // ace strongest

                else
                    cards[i] = 0; // safety fallback
            }
        }

        this.bid = bid;
    }

    public int getBid() {
        return bid;
    }

    public void check() {

        int[] freq = new int[15]; // index = card value (0–14)

        for (int i = 0; i < 5; i++) {
            freq[cards[i]]++; // count how many times each card appears
        }

        int maxCount = 0;
        int secondCount = 0;



        for (int i = 1; i < freq.length; i++) {

            if (freq[i] > maxCount) {
                secondCount = maxCount;
                maxCount = freq[i];
            } else if (freq[i] > secondCount) {
                secondCount = freq[i];
            }
        }
         //jacks
        if(freq[11]>0){
maxCount+=freq[11];
        }



        // determine hand type
        if (maxCount == 5) {
            strength = 7;
            handsAmount[0]++;
        } else if (maxCount == 3 && secondCount == 2) {
            strength = 5;
            handsAmount[1]++;
        } else if (maxCount == 4) {
            strength = 6;
            handsAmount[2]++;
        } else if (maxCount == 3) {
            strength = 4;
            handsAmount[3]++;
        } else if (maxCount == 2 && secondCount == 2) {
            strength = 3;
            handsAmount[4]++;
        } else if (maxCount == 2) {
            strength = 2;
            handsAmount[5]++;
        } else {
            strength = 1;
            handsAmount[6]++;
        }

        //order cards
        // most frequent first
        // if ties
        // higher value first

        int index = 0;

        for (int count = 5; count >= 1; count--) {
            for (int value = 14; value >= 2; value--) {

                if (freq[value] == count) {

                    for (int k = 0; k < count; k++) {
                        ordered[index++] = value;
                    }
                }
            }
        }
    }

    // compare this hand to another
    public boolean isStrongerThan(Hand other) {

        if (this.strength > other.strength)
            return true;

        if (this.strength < other.strength)
            return false;

        // if same type compare ordered cards
        for (int i = 0; i < 5; i++) {

            if (this.ordered[i] > other.ordered[i])
                return true;

            if (this.ordered[i] < other.ordered[i])
                return false;
        }

        return false;
    }

    public static void displayHandsAmount() {

        System.out.println("Number of five of a kind hands: " + handsAmount[0]);
        System.out.println("Number of full house hands: " + handsAmount[1]);
        System.out.println("Number of four of a kind hands: " + handsAmount[2]);
        System.out.println("Number of three of a kind hands: " + handsAmount[3]);
        System.out.println("Number of two pair hands: " + handsAmount[4]);
        System.out.println("Number of one pair hands: " + handsAmount[5]);
        System.out.println("Number of high card hands: " + handsAmount[6]);
    }
}
