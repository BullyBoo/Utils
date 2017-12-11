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

public class VinValidator {

    private static final char[] CHARS = {
            'A','B','C','D','E','F','G','H','J','K','L','M','N','P','R','S','T','U','V','W','X','Y','Z'
    };

    private static final int[] CODES = {
            1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 7, 9, 2, 3, 4, 5, 6, 7, 8, 9
    };

    private static final int[] S_BOX = {
            8, 7, 6, 5, 4, 3, 2, 10, 9, 8, 7, 6, 5, 4, 3, 2
    };


    public static boolean isValid(String vin){
        if(vin == null ||
                vin.length() != 17){

            return false;
        }

        int[] intArray = replaceChars(vin.toCharArray());

        int[] bodyArray = removeNinthElement(intArray);

        int checkSum = countCheckSum(bodyArray);

        if(checkSum == 10){
            return vin.charAt(8) == 'X';
        } else {
            return vin.charAt(8) == Character.forDigit(checkSum, 10);
        }
    }

    private static int[] replaceChars(char[] array) {
        int size = array.length;

        int[] intArray = new int[size];

        for (int i = 0; i < size; i++) {
            if (Character.isDigit(array[i])) {
                intArray[i] = Character.getNumericValue(array[i]);
            } else {
                intArray[i] = getCodeByChar(array[i]);
            }
        }
        return intArray;
    }

    private static int getCodeByChar(char character){
        int size = CHARS.length;

        for(int i = 0; i < size; i++){
            if(character == CHARS[i]){
                return CODES[i];
            }
        }

        return 0;
    }

    private static int[] removeNinthElement(int[] input){
        int size = input.length;

        int[] output = new int[size - 1];

        for(int i = 0; i < size; i++){
            if(i < 8){
                output[i] = input[i];
            } else if(i > 8){
                output[i - 1] = input[i];
            }
        }

        return output;
    }

    private static int countCheckSum(int[] array){
        int size = array.length;

        int count = 0;

        for(int i = 0; i < size; i++){
            count += array[i] * S_BOX[i];
        }

        int first = count / 11;
        int second = first * 11;

        return count - second;
    }
}
