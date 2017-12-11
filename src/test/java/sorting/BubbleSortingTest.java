package sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortingTest {

    @Test
    public void increase() throws Exception {
        int[] increase = BubbleSorting.increase(new int[]{9, 1, 6, 3, 6, 8});

        print(increase);
    }

    @Test
    public void decrease() throws Exception {
        int[] increase = BubbleSorting.decrease(new int[]{9, 1, 6, 3, 6, 8});

        print(increase);
    }

    private void print(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }
}