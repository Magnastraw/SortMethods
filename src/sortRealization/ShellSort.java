package sortRealization;

public class ShellSort implements SortInterface {

    //ПОДРОБНО ИЗУЧИТЬ(для больших значений что то не так)


    public void sort(double[] array) {
        int h = 1;
        while (h*3 < array.length)
            h = h * 3 + 1;

        while(h >= 1) {
            hSort(array, h);
            h = h/3;
        }
    }
    private void hSort(double[] array, int h) {
        int length = array.length;
        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                if (array[j] < array[j - h])
                    swap(array, j, j - h);
                else
                    break;
            }
        }
    }
    private static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
//    public void sort(double[] array) {
//        int s = -1, p1 = 1, p2 = 1, p3 = 1;
//        int[] inc = new int[1000];
//        do {
//            s++;
//            if (s % 2 == 0) {
//                inc[s] = 9 * p1 - 9 * p2 + 1;
//            } else {
//                inc[s] = 8 * p1 - 6 * p3 + 1;
//            }
//            p1 *= 2;
//            p2 *= 2;
//            p3 *= 2;
//        } while (3 * inc[s] < array.length);
//
//
//        for (int i = s - 1; i >= 0; i--) {
//            int d = inc[i];
//            for (int j = d; j < array.length; j++) {
//                double temp = array[j];
//                int k;
//                for (k = j; k >= d; k -= d) {
//                    if (temp < array[k - d])
//                        array[k] = array[k - d];
//                    else
//                        break;
//                }
//                array[k] = temp;
//            }
//        }
//    }
}
