package utils;

import java.util.ArrayList;
import java.util.List;

public class ShortUtils {

    public static List<Short> toList(short ... shortArray){
        if(shortArray == null){
            return null;

        } else if(shortArray.length == 0){
            return new ArrayList<>();
        }

        List<Short> shortList = new ArrayList<>(shortArray.length);

        for(short i : shortArray){
            shortList.add(i);
        }

        return shortList;
    }

    public static short[] toArray(List<Short> shortList){
        if(shortList == null){
            return null;

        } else if(shortList.size() == 0){
            return new short[0];
        }

        int size = shortList.size();

        short[] shortArray = new short[size];

        for(int i = 0; i < size; i++){
            shortArray[i] = shortList.get(i);
        }

        return shortArray;
    }
}
