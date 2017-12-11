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

public class CoctailSorting {

    public static int[] increase(int[] array){
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if(array[i] > array[i+1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
            right--;
            for (int i = right; i > left ; i--) {
                if(array[i] < array[i-1]) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                }
            }
            left++;
        } while (left <= right);

        return array;
    }

    public static int[] decrease(int[] array){
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if(array[i] < array[i+1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
            right--;
            for (int i = right; i > left ; i--) {
                if(array[i] > array[i-1]) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                }
            }
            left++;
        } while (left <= right);

        return array;
    }

}
