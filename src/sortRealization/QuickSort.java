package sortRealization;


public class QuickSort implements SortInterface {

    public void sort(double[] array){
        quickSort(array,0,array.length-1);
    }

    private void quickSort(double[] array, int l, int r){
        int left = l;
        int right = r;
        double p = array[l+(r-l)/2];

        while(left<=right){
            while (array[left] < p) {
                left++;
            }
            while (array[right] > p) {
                right--;
            }

            if (left <= right) {
                swap(array,left,right);
                left++;
                right--;
            }
        }
        if(l<right){
            quickSort(array,l,right);
        }
        if(left<r){
            quickSort(array,left,r);
        }
    }

    private void swap(double[] array,int i,int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
