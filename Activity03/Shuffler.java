package Activity03;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 1;

    /**
     * The number of values to shuffle.
     */
    private static final int VALUE_COUNT = 4;

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive perfect shuffles:");
        int[] values1 = new int[VALUE_COUNT];
        int[] shuffle1 = new int[VALUE_COUNT];
        for (int i = 0; i < values1.length; i++) {
            values1[i] = i;
            }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            shuffle1 =  perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + shuffle1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive efficient selection shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        int[] shuffle2 = new int[VALUE_COUNT];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = i;
            }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            shuffle2 = selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + shuffle2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm spli   ts the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static int[] perfectShuffle(int[] values) {
        int[] shuffle= new int[values.length];
        int k = 0;
        int middle;
        if(values.length % 2 == 0)
            middle = values.length / 2;
        else
            middle = (values.length + 1) / 2;
        for(int j = 0; j < middle; j++){
            shuffle[k] = values[j];
            k += 2;
        }
        k = 1;
        for(int j = middle; j < values.length; j++){
            shuffle[k] = values[j];
            k += 2;
        }
        return shuffle;
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static int[] selectionShuffle(int[] values) {
        int[] shuffle = new int[values.length];
        int j = (int)((values.length) * Math.random());
        for(int k = 0; k < values.length - 1; k++){
            while(values[j] == 0){
                j = (int)((values.length) * Math.random());
            }
            shuffle[k] = values[j];
            values[j] = 0;
        }
        return shuffle;
    }
}