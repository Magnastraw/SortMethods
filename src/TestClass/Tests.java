package TestClass;

import sortRealization.*;

public class Tests {


    public static void main(String[] args) {

        double[] array = new double[50000];
        double[] array2 = new double[50000];
        double[] array3 = new double[50000];
        double[] array4 = new double[50000];

        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        ShellSort shellSort = new ShellSort();

        for (int i = 0; i < array.length; i++) {
            array[i] = ((Math.random() * 1001) - 500);
        }

        System.arraycopy(array, 0, array2, 0, array.length);
        System.arraycopy(array, 0, array3, 0, array.length);
        System.arraycopy(array, 0, array4, 0, array.length);


        System.out.println("MergeSort time in seconds - " + workTime(mergeSort, array2));
        System.out.println("QuickSort time in seconds - " + workTime(quickSort, array3));
        System.out.println("ShellSort time in seconds - " + workTime(shellSort, array4));
        System.out.println("BubbleSort time in seconds - " + workTime(bubbleSort, array));

    }

    private static double workTime(SortInterface sorts, double[] array) {
        long startTime = System.nanoTime();
        sorts.sort(array);
        return (System.nanoTime() - startTime) / 1000000000.0;
    }
}
