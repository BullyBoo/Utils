package sorting;

public class BubbleSorting {


    public static int[] increase(int[] array) {
        if(array == null){
            return null;
        } else if (array.length == 0 || array.length == 1){
            return array;
        }

        for(int i = array.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        return array;
    }

    public static int[] decrease(int[] array){
        if(array == null){
            return null;
        } else if (array.length == 0 || array.length == 1){
            return array;
        }

        for(int i = array.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        return array;
    }

}
