/*
 * Copyright (C) 2017 BullyBoo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
