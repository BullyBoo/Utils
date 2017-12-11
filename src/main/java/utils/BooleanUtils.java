package utils;

import java.util.ArrayList;
import java.util.List;

public class BooleanUtils {

    public static List<Boolean> toList(boolean ... booleanArray){
        if(booleanArray == null){
            return null;

        } else if(booleanArray.length == 0){
            return new ArrayList<>();
        }

        List<Boolean> booleanList = new ArrayList<>(booleanArray.length);

        for(boolean i : booleanArray){
            booleanList.add(i);
        }

        return booleanList;
    }

    public static boolean[] toArray(List<Boolean> booleanList){
        if(booleanList == null){
            return null;

        } else if(booleanList.size() == 0){
            return new boolean[0];
        }

        int size = booleanList.size();

        boolean[] booleanArray = new boolean[size];

        for(int i = 0; i < size; i++){
            booleanArray[i] = booleanList.get(i);
        }

        return booleanArray;
    }
}
