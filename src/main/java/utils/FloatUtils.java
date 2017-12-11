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
