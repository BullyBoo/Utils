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
