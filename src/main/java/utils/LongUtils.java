package utils;

import java.util.ArrayList;
import java.util.List;

public class LongUtils {

    public static List<Long> toList(long ... longArray){
        if(longArray == null){
            return null;

        } else if(longArray.length == 0){
            return new ArrayList<>();
        }

        List<Long> longList = new ArrayList<>(longArray.length);

        for(long i : longArray){
            longList.add(i);
        }

        return longList;
    }

    public static long[] toArray(List<Long> longList){
        if(longList == null){
            return null;

        } else if(longList.size() == 0){
            return new long[0];
        }

        int size = longList.size();

        long[] longArray = new long[size];

        for(int i = 0; i < size; i++){
            longArray[i] = longList.get(i);
        }

        return longArray;
    }
}
