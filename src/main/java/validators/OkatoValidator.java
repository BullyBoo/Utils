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

package validators;

/**
 * The class for validating OKATO and OKTMO numbers
 */
public class OkatoValidator extends BaseDigitValidator{

    private static final int[] S_BOX_1 = {
            1, 2, 3, 4, 5, 6, 7, 8, 9
    };

    private static final int[] S_BOX_2 = {
            3, 4, 5, 6, 7, 8, 9, 10, 11
    };

    public static boolean isValid(String number){
        if(number == null ||
                number.length() < 3 || number.length() > 9 && number.length() != 12 ||
                !digitPatten.matcher(number).matches()){

            return false;
        }

        int[] intArray = convertToIntArray(number);
        int size = intArray.length;

        int checkSum = countCheckSum(intArray, S_BOX_1);

        if(checkSum == 10){
            int checkSum2 = countCheckSum(intArray, S_BOX_2);

            if(checkSum2 == 10){
                checkSum2 = 0;
            }

            return checkSum2 == intArray[size - 1];
        } else {
            return checkSum == intArray[size - 1];
        }
    }

    private static int countCheckSum(int[] array, int[] sBox){
        int size = array.length;

        int count = 0;

        for(int i = 0; i < size; i++){
            count += array[i] * sBox[i];
        }

        return count % 11;
    }
}
