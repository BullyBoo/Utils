package utils;

import java.util.ArrayList;
import java.util.List;

public class ByteUtils {

    public static List<Byte> toList(byte ... byteArray){
        if(byteArray == null){
            return null;

        } else if(byteArray.length == 0){
            return new ArrayList<>();
        }

        List<Byte> byteList = new ArrayList<>(byteArray.length);

        for(byte i : byteArray){
            byteList.add(i);
        }

        return byteList;
    }

    public static byte[] toArray(List<Byte> byteList){
        if(byteList == null){
            return null;

        } else if(byteList.size() == 0){
            return new byte[0];
        }

        int size = byteList.size();

        byte[] byteArray = new byte[size];

        for(int i = 0; i < size; i++){
            byteArray[i] = byteList.get(i);
        }

        return byteArray;
    }
}
