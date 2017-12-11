package sorting;

import java.util.Arrays;

public class MergeSorting {

    public int[] increase(int[] array) {
        return increase(array, 0, array.length - 1);
    }

    public static int[] increase(int[] array, int low, int top){
        if (top <= low)
            return array;

        int mid = low + (top - low) / 2;
        array = increase(array, low, mid);
        array = increase(array, mid + 1, top);

        int[] buf = Arrays.copyOf(array, array.length);

        for (int k = low; k <= top; k++)
            buf[k] = array[k];

        int i = low, j = mid + 1;
        for (int k = low; k <= top; k++) {

            if (i > mid) {
                array[k] = buf[j];
                j++;
            } else if (j > top) {
                array[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                array[k] = buf[j];
                j++;
            } else {
                array[k] = buf[i];
                i++;
            }
        }
        return array;
    }

    public int[] decrease(int[] array) {
        return decrease(array, 0, array.length - 1);
    }

    private int[] decrease(int[] array, int low, int top){
        if (top <= low)
            return array;

        int mid = low + (top - low) / 2;

        array = decrease(array, low, mid);
        array = decrease(array, mid + 1, top);

        int[] buf = Arrays.copyOf(array, array.length);

        System.arraycopy(array, low, buf, low, top + 1 - low);

        int i = low, j = mid + 1;

        for (int k = low; k <= top; k++) {

            if (i > mid) {
                array[k] = buf[j];
                j++;
            } else if (j > top) {
                array[k] = buf[i];
                i++;
            } else if (buf[j] > buf[i]) {
                array[k] = buf[j];
                j++;
            } else {
                array[k] = buf[i];
                i++;
            }
        }
        return array;
    }

}
