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

public class SnailsValidator extends BaseDigitValidator{

    public static boolean isValid(String number){
        if(number == null ||
                number.length() != 11 ||
                !digitPatten.matcher(number).matches()){

            return false;
        }

        int[] intArray = convertToIntArray(number);
        int size = intArray.length;

        int[] bodyArray = getBody(intArray, 2);

        int checkSum = countCheckSum(bodyArray);

        int first = checkSum / 10;
        int second = checkSum % 10;

        return first == intArray[size - 2] &&
                second == intArray[size - 1];
    }


    private static int countCheckSum(int[] input){
        int size = input.length;

        int count = 0;

        for(int i = 0; i < size; i++){
            count += input[i] * (size - i);
        }

        return count;
    }
}
