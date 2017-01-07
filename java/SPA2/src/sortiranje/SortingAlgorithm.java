package sortiranje;

/**
 * Created by Rastko on 10/31/2016.
 */
public interface SortingAlgorithm<T extends Comparable<T>> {

    public void sort(T[] array);

}
