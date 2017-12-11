package sorting;

public class InsertionSorting {

    public static int[] increase(int[] array){
        int size = array.length;

        for(int j = 1; j < size; j++) {
            int key = array[j];

            for(int i = j-1; i >= 0; i--) {
                if(array[i] > key){
                    array[i+1] = array[i];
                    array[i] = key;
                }
            }
        }
        return array;
    }

    public static int[] decrease(int[] array){
        int size = array.length;

        for(int j = 1; j < size; j++) {
            int key = array[j];

            for(int i = j-1; i >= 0; i--) {
                if(array[i] < key){
                    array[i+1] = array[i];
                    array[i] = key;
                }
            }
        }
        return array;
    }
}
