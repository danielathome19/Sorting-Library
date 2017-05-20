/*
 * Author:  Daniel Szelogowski
 * Created: 5/10/17
 * Purpose: A collection of sorting methods in java.
 *
 * Currently implemented:
 *  -Bubble Sort
 *  -Selection Sort
 *  -Insertion Sort
 *  -Quick Sort
 *  -Merge Sort
 *  -Heap Sort
 *
 * To do:
 *  -Shell Sort
 *  -Radix Sort (LSD)
 *  -Radix Sort (MSD)
 *  -Cocktail Sort
 *
 **************************************************************************/

package Sorting;

public class Sorts<T extends Comparable<T>> {
    private static class HeapSort {
        private static Comparable[] a;
        private static int n;
        private static int left;
        private static int right;
        private static int largest;

        private static void buildheap(Comparable[] a){
            n = a.length - 1;
            for (int i = n/2; i >= 0; i--) {
                maxheap(a, i);
            }
        }

        @SuppressWarnings("unchecked")
        private static void maxheap(Comparable[] a, int i){
            left = 2 * i;
            right = 2 * i + 1;
            if(left <= n && a[left].compareTo(a[i]) > 0) {
                largest = left;
            } else {
                largest = i;
            }

            if(right <= n && a[right].compareTo(a[largest]) > 0){
                largest = right;
            }

            if(largest != i){
                exchange(i, largest);
                maxheap(a, largest);
            }
        }

        private static void exchange(int i, int j){
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        public static void sort(Comparable[] array){
            a = array;
            buildheap(a);

            for (int i = n; i > 0; i--) {
                exchange(0, i);
                n = n - 1;
                maxheap(a, 0);
            }
        }
    }

    private void swapValues(int indexOne, int indexTwo, T[] items) {
        T temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private int partitionArray(int left, int right, T pivot, T[] items) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (items[++leftPointer].compareTo(pivot) == -1);
            while (rightPointer > 0 && items[--rightPointer].compareTo(pivot) == 1);

            if (leftPointer >= rightPointer) break;
            else swapValues(leftPointer, rightPointer, items);
        }

        swapValues(leftPointer, right, items);
        return leftPointer;
    }

    private void quickSort(int left, int right, T[] items) {
        if (right - left <= 0)  {
            return;
        } else {
            T pivot = items[right];
            int pivotLocation = partitionArray(left, right, pivot, items);

            quickSort(left, pivotLocation - 1, items);
            quickSort(pivotLocation + 1, right, items);
        }
    }

    @SuppressWarnings("unchecked")
    private T[] combine(T[] left, T[] right) {
        T[] result = (T[])new Comparable[left.length + right.length];

        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) == -1) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    private T[] mergeSort(T[] items, int min, int max) {
        if (min == max) {
            return (T[])new Comparable[]{items[min]};
        }

        int mid = (min + max) / 2;
        T[] left = mergeSort(items, min, mid);
        T[] right = mergeSort(items, mid + 1, max);

        return combine(left, right);
    }

    /////////////////////////////////////////////////////////////

    void bubbleSort(T[] items) {
        for (int i = items.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (items[j].compareTo(items[j + 1]) == 1) {
                    swapValues(j, j + 1, items);
                }
            }
        }
    }

    void selectionSort(T[] items){
        for (int x = 0; x < items.length; x++){
            int minimum = x;
            for(int y = x; y < items.length; y++) {
                if(items[minimum].compareTo(items[y]) == 1){
                    minimum = y;
                }
            }
            swapValues(x, minimum, items);
        }
    }

    void insertionSort(T[] items){
        for (int i = 1; i < items.length; i++){
            int j = i;
            T toInsert = items[i];
            while ((j > 0) && (items[j - 1].compareTo(toInsert) == 1)){
                items[j] = items[j - 1];
                j--;
            }
            items[j] = toInsert;
        }
    }

    void quickSort(T[] items) {
        quickSort(0, items.length - 1, items);
    }

    void mergeSort(T[] items) {
        T[] sorted = mergeSort(items, 0, items.length - 1);
        System.arraycopy(sorted, 0, items, 0, sorted.length);
    }

    void heapSort(T[] items) {
        HeapSort.sort(items);
    }
}
