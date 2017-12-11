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
