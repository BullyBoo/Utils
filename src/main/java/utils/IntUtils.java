package utils;

import java.util.ArrayList;
import java.util.List;

public class IntUtils {

    public static List<Integer> toList(int ... array){
        if(array == null){
            return null;

        } else if(array.length == 0){
            return new ArrayList<>();
        }

        List<Integer> integerList = new ArrayList<>(array.length);

        for(int i : array){
            integerList.add(i);
        }

        return integerList;
    }

    public static int[] toArray(List<Integer> integerList){
        if(integerList == null){
            return null;

        } else if(integerList.size() == 0){
            return new int[0];
        }

        int size = integerList.size();

        int[] intArray = new int[size];

        for(int i = 0; i < size; i++){
            intArray[i] = integerList.get(i);
        }

        return intArray;
    }
}
