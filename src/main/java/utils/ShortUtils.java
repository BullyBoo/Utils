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
