package Sorting;

public class Sorts<T extends Comparable<T>> {

    private void swapValues(int indexOne, int indexTwo, T[] items) {
        T temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    public void bubbleSort(T[] items) {
        for (int i = items.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (items[j].compareTo(items[j + 1]) == 1) {
                    swapValues(j, j + 1, items);
                }
            }
        }
    }

    public void selectionSort(T[] items){
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

    public void insertionSort(T[] items){
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

}
