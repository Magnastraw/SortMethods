package sortRealization;


public class BubbleSort implements SortInterface {
    private boolean isSwap=true;
    private double array_temp;

    public void sort(double[] array){
        while (isSwap) {
            isSwap = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    array_temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = array_temp;
                    isSwap=true;
                }
            }
        }
    }
}
