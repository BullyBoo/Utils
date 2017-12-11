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

import java.util.regex.Pattern;

public abstract class BaseDigitValidator {

    /**
     * Pattern for validation, that all character in String is digits
     */
    static final Pattern digitPatten = Pattern.compile("^\\d+$");

    /**
     * Method for converting String to int array
     * @param input - input String
     * @return - output int array
     */
    static int[] convertToIntArray(String input){

        int size = input.length();

        int[] output = new int[size];

        for(int i = 0; i < size; i++){
            output[i] = Character.getNumericValue(input.charAt(i));
        }

        return output;
    }

    /**
     * Method for getting int array without ending
     * @param input - source array
     * @param ending - ending offset
     * @return - new int array without ending
     */
    static int[] getBody(int[] input, int ending){
        int newSize = input.length - ending;

        int[] output = new int[newSize];

        System.arraycopy(input, 0, output, 0, newSize);

        return output;
    }


}
