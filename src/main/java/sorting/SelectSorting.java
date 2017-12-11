package sorting;

public class SelectSorting {

    public static int[] increase(int[] array){
        int size = array.length;

        for (int i = 0; i < size; i++) {
            int minValueIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minValueIndex]) {
                    minValueIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minValueIndex];
            array[minValueIndex] = temp;
        }
        return array;
    }

    public static int[] decrease(int[] array){
        int size = array.length;

        for (int i = 0; i < size; i++) {
            int minValueIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (array[j] > array[minValueIndex]) {
                    minValueIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minValueIndex];
            array[minValueIndex] = temp;
        }
        return array;
    }
}
