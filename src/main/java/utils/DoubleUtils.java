package utils;

import java.util.ArrayList;
import java.util.List;

public class DoubleUtils {

    public static List<Double> toList(double ... doubleArray){
        if(doubleArray == null){
            return null;

        } else if(doubleArray.length == 0){
            return new ArrayList<>();
        }

        List<Double> doubleList = new ArrayList<>(doubleArray.length);

        for(double i : doubleArray){
            doubleList.add(i);
        }

        return doubleList;
    }

    public static double[] toArray(List<Double> doubleList){
        if(doubleList == null){
            return null;

        } else if(doubleList.size() == 0){
            return new double[0];
        }

        int size = doubleList.size();

        double[] doubleArray = new double[size];

        for(int i = 0; i < size; i++){
            doubleArray[i] = doubleList.get(i);
        }

        return doubleArray;
    }
}
