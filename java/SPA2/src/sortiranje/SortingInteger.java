package sortiranje;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Rastko on 10/31/2016.
 */
public class SortingInteger {
    private ArrayList<SortingAlgorithm<Integer>> algorithms;

    public SortingInteger() {
        algorithms = new ArrayList<>();
        addAlgorithms();
    }

    private void addAlgorithms() {
        algorithms.add(new BubbleSort());
        algorithms.add(new SelectionSort());
        algorithms.add(new InsertionSort());
    }

    public void sort(Integer[] array) {
        System.out.println("Pick a sorting algorithm: ");
        System.out.println("\t 0) Bubble Sort");
        System.out.println("\t 1) Selection Sort");
        System.out.println("\t 2) Insertion Sort");

        Scanner sc = new Scanner(System.in);
        algorithms.get(sc.nextInt()).sort(array);

        print(array);
    }

    private void print(Integer[] array) {
        System.out.println("Sorted array: ");
        for(Integer i : array)
            System.out.print(i + " ");
    }

}
