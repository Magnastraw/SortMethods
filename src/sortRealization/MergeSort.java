package sortRealization;


import java.util.Arrays;

public class MergeSort implements SortInterface {

    public void sort(double[] array) {
        int size2;  //размер второго массива в методе слияния
        int len = array.length; //длина входного массива
        double array2[];    //хранилище для результирующего массива слияния
        //цикл по n где n - кратность сравнений(сравниваем вначале по одному элементу, потом по два, потом по три)
        for (int n = 1; n <= len; n *= 2) {
            // цикл по кускам по массива, то есть вначале минимально возможный цикл по 0-2,2-4 и тд, потом 0-4, 4-8 и тд
            for (int i = 0; i < len - 1; i += n * 2) {
                //если на конце массива остается один элемент, прерываем цикл
                if ((i + n) >= len) break;
                //размер второго массива, проверка для того чтобы не выйти за пределы массива, если последняя группа элементов в массиве меньше n(напр. 0 1 2 3 | 4 5 6 ) (разобрать еще)
                size2 = (i + n * 2 > len) ? (len - (i + n)) : n;
                // сливаем упорядоченные массивы
                array2 = merge(Arrays.copyOfRange(array, i, i + n), Arrays.copyOfRange(array, i + n, i + n + size2));
                //перезаписываем выбранные куски в исходном массиве
                for (int j = 0; j < n + size2; ++j) {
                    array[i + j] = array2[j];
                }
            }


        }
    }

    private double[] merge(double[] arr_1, double[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2; // a, b - счетчики в массивах
        double[] result = new double[len];
        //сливаем упорядоченные элементы по очереди в буфер, если в одном из массиов кончились элементы, докидываем оставшиеся из другого в буфер
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }

}
