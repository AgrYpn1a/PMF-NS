package sortiranje;

/**
 * Created by Rastko on 10/31/2016.
 */
class InsertionSort implements SortingAlgorithm<Integer> {

    public void sort(Integer[] array) {
        System.out.println("***Insertion sort**");

        int numberOfSteps = 0;

        for(int i=1; i<array.length; i++) {
            Integer current = array[i];

            int j = i;
            while(j > 0 && current.compareTo(array[j-1]) < 0) {
                array[j] = array[j-1];
                j--;
                numberOfSteps++;
            }

            array[j] = current;
        }
        // report stats
        System.out.println("Stats:");
        System.out.println("\tNumber of steps: " + numberOfSteps);
        System.out.println("***END***");
    }

}
