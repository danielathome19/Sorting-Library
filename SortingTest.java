package Sorting;

import java.util.concurrent.TimeUnit;

public class SortingTest {

    private static void populateArray(Integer[] items) {
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = rand.nextInt(10);
        }
    }

    private static void printArray(Integer[] items) {
        for (Integer x : items) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] items = new Integer[500];

        bubbleSortTest(items);
        selectionSortTest(items);
        insertionSortTest(items);
        quickSortTest(items);
        mergeSortTest(items);
        heapSortTest(items);
    }

    @SuppressWarnings("unchecked")
    public static void bubbleSortTest(Integer[] items) {
        Sorts sorts = new Sorts();
        populateArray(items);
        System.out.println("Old Array: ");
        printArray(items);

        long oldTime = System.nanoTime();
        sorts.bubbleSort(items);
        long newTime = System.nanoTime();

        System.out.println("New Array: ");
        printArray(items);
        System.out.println("Elapsed time [Bubble Sort]: " + TimeUnit.MILLISECONDS.convert(newTime - oldTime, TimeUnit.NANOSECONDS) + "ms");
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void selectionSortTest(Integer[] items) {
        Sorts sorts = new Sorts();
        populateArray(items);
        System.out.println("Old Array: ");
        printArray(items);

        long oldTime = System.nanoTime();
        sorts.selectionSort(items);
        long newTime = System.nanoTime();

        System.out.println("New Array: ");
        printArray(items);
        System.out.println("Elapsed time [Selection Sort]: " + TimeUnit.MILLISECONDS.convert(newTime - oldTime, TimeUnit.NANOSECONDS) + "ms");
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void insertionSortTest(Integer[] items) {
        Sorts sorts = new Sorts();
        populateArray(items);
        System.out.println("Old Array: ");
        printArray(items);

        long oldTime = System.nanoTime();
        sorts.insertionSort(items);
        long newTime = System.nanoTime();

        System.out.println("New Array: ");
        printArray(items);
        System.out.println("Elapsed time [Insertion Sort]: " + TimeUnit.MILLISECONDS.convert(newTime - oldTime, TimeUnit.NANOSECONDS) + "ms");
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void quickSortTest(Integer[] items) {
        Sorts sorts = new Sorts();
        populateArray(items);
        System.out.println("Old Array: ");
        printArray(items);

        long oldTime = System.nanoTime();
        sorts.quickSort(items);
        long newTime = System.nanoTime();

        System.out.println("New Array: ");
        printArray(items);
        System.out.println("Elapsed time [Quick Sort]: " + TimeUnit.MILLISECONDS.convert(newTime - oldTime, TimeUnit.NANOSECONDS) + "ms");
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void mergeSortTest(Integer[] items) {
        Sorts sorts = new Sorts();
        populateArray(items);
        System.out.println("Old Array: ");
        printArray(items);

        long oldTime = System.nanoTime();
        sorts.mergeSort(items);
        long newTime = System.nanoTime();

        System.out.println("New Array: ");
        printArray(items);
        System.out.println("Elapsed time [Merge Sort]: " + TimeUnit.MILLISECONDS.convert(newTime - oldTime, TimeUnit.NANOSECONDS) + "ms");
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void heapSortTest(Integer[] items) {
        Sorts sorts = new Sorts();
        populateArray(items);
        System.out.println("Old Array: ");
        printArray(items);

        long oldTime = System.nanoTime();
        sorts.heapSort(items);
        long newTime = System.nanoTime();

        System.out.println("New Array: ");
        printArray(items);
        System.out.println("Elapsed time [Heap Sort]: " + TimeUnit.MILLISECONDS.convert(newTime - oldTime, TimeUnit.NANOSECONDS) + "ms");
        System.out.println();
    }
}
