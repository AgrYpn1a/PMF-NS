package sortiranje;

/**
 * Created by Rastko on 10/31/2016.
 */
class BubbleSort implements SortingAlgorithm<Integer> {

    public void sort(Integer[] array) {
        System.out.println("***Bubble sort***");

        int numberOfSteps = 0;
        int numberOfExchanges = 0;

        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array.length-1-i; j++) {
                if(array[j].compareTo(array[j+1]) > 0) {
                    Integer temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    numberOfExchanges++;
                }
                numberOfSteps++;
            }
        }

        // report stats
        System.out.println("Stats:");
        System.out.println("\tNumber of exchanges: " + numberOfExchanges);
        System.out.println("\tNumber of steps: " + numberOfSteps);
        System.out.println("***END***");
    }

}
