package utils;

import java.util.ArrayList;
import java.util.List;

public class FloatUtils {

    public static List<Float> toList(float ... floatArray){
        if(floatArray == null){
            return null;

        } else if(floatArray.length == 0){
            return new ArrayList<>();
        }

        List<Float> floatList = new ArrayList<>(floatArray.length);

        for(float i : floatArray){
            floatList.add(i);
        }

        return floatList;
    }

    public static float[] toArray(List<Float> floatList){
        if(floatList == null){
            return null;

        } else if(floatList.size() == 0){
            return new float[0];
        }

        int size = floatList.size();

        float[] floatArray = new float[size];

        for(int i = 0; i < size; i++){
            floatArray[i] = floatList.get(i);
        }

        return floatArray;
    }
}
