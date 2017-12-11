package sorting;

public class GnomeSorting {

    public static int[] increase(int[] array){
        int i = 1;

        int size = array.length;

        while(i < size) {
            if(i == 0 || array[i - 1] <= array[i]){
                i++;
            } else {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            }
        }
        return array;
    }

    public static int[] decrease(int[] array){
        int i = 1;

        int size = array.length;

        while(i < size) {
            if(i == 0 || array[i - 1] >= array[i]){
                i++;
            } else {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            }
        }
        return array;
    }

}
