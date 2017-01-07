package sortiranje;

/**
 * Created by Rastko on 10/31/2016.
 */
class SelectionSort implements SortingAlgorithm<Integer> {

    public void sort(Integer[] array) {
        System.out.println("***Selection sort**");

        int numberOfSteps = 0;
        int numberOfComparison = 0;

        for(int i=0; i<array.length-1; i++) {
            int minPos = i;
            for(int j=i+1; j<array.length; j++) {
                // find minimum
                if(array[j].compareTo(array[minPos]) < 0) {
                    minPos = j;
                }
                numberOfSteps++;
            }
            Integer temp = array[i];
            array[i] = array[minPos];
            array[minPos] = temp;
        }

        // report stats
        System.out.println("Stats:");
        System.out.println("\tNumber of steps: " + numberOfSteps);
        System.out.println("***END***");
    }

}

