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

package sorting;

public class SelectSorting {

    public static int[] increase(int[] array){
        int size = array.length;

        for (int i = 0; i < size; i++) {
            int minValueIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minValueIndex]) {
                    minValueIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minValueIndex];
            array[minValueIndex] = temp;
        }
        return array;
    }

    public static int[] decrease(int[] array){
        int size = array.length;

        for (int i = 0; i < size; i++) {
            int minValueIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (array[j] > array[minValueIndex]) {
                    minValueIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minValueIndex];
            array[minValueIndex] = temp;
        }
        return array;
    }
}
