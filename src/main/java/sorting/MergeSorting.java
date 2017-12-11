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

import java.util.Arrays;

public class MergeSorting {

    public int[] increase(int[] array) {
        return increase(array, 0, array.length - 1);
    }

    public static int[] increase(int[] array, int low, int top){
        if (top <= low)
            return array;

        int mid = low + (top - low) / 2;
        array = increase(array, low, mid);
        array = increase(array, mid + 1, top);

        int[] buf = Arrays.copyOf(array, array.length);

        for (int k = low; k <= top; k++)
            buf[k] = array[k];

        int i = low, j = mid + 1;
        for (int k = low; k <= top; k++) {

            if (i > mid) {
                array[k] = buf[j];
                j++;
            } else if (j > top) {
                array[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                array[k] = buf[j];
                j++;
            } else {
                array[k] = buf[i];
                i++;
            }
        }
        return array;
    }

    public int[] decrease(int[] array) {
        return decrease(array, 0, array.length - 1);
    }

    private int[] decrease(int[] array, int low, int top){
        if (top <= low)
            return array;

        int mid = low + (top - low) / 2;

        array = decrease(array, low, mid);
        array = decrease(array, mid + 1, top);

        int[] buf = Arrays.copyOf(array, array.length);

        System.arraycopy(array, low, buf, low, top + 1 - low);

        int i = low, j = mid + 1;

        for (int k = low; k <= top; k++) {

            if (i > mid) {
                array[k] = buf[j];
                j++;
            } else if (j > top) {
                array[k] = buf[i];
                i++;
            } else if (buf[j] > buf[i]) {
                array[k] = buf[j];
                j++;
            } else {
                array[k] = buf[i];
                i++;
            }
        }
        return array;
    }

}
