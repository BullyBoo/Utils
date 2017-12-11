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
