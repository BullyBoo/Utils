package sorting;

import java.util.List;

public class CoctailSorting {

    public static int[] increase(int[] array){
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if(array[i] > array[i+1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
            right--;
            for (int i = right; i > left ; i--) {
                if(array[i] < array[i-1]) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                }
            }
            left++;
        } while (left <= right);

        return array;
    }

    public static int[] decrease(int[] array){
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if(array[i] < array[i+1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
            right--;
            for (int i = right; i > left ; i--) {
                if(array[i] > array[i-1]) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                }
            }
            left++;
        } while (left <= right);

        return array;
    }

}
