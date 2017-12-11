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

/**
 * The class for validating the bank`s account number
 */
public class BankAccountValidator extends BaseDigitValidator{

    /**
     * S-box for calculating check sum of bank`s account number
     */
    private static final int[] S_BOX = {
            7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1
    };

    /**
     * Pattern for validation, that all character in String is digits
     */
    private static final Pattern digitPatten = Pattern.compile("^\\d+$");

    public static boolean isValid(String accountNumber, String bic){
        if(accountNumber == null || bic == null ||
                accountNumber.length() != 20 || bic.length() != 9 ||
                !digitPatten.matcher(accountNumber).matches() ||
                !digitPatten.matcher(bic).matches()){

            return false;
        }

        int bicLength = bic.length();

        String body = bic.substring(bicLength - 3, bicLength) + accountNumber;

        int[] intArray = convertToIntArray(body);

        int checkSum = countCheckSum(intArray);

        int first = checkSum % 10;

        int second = (first * 3) % 10;

        return first == second;
    }

    private static int countCheckSum(int[] array){

        int size = array.length;

        int count = 0;

        for(int i = 0; i < size; i++){
            count += array[i] * S_BOX[i];
        }

        return count;
    }
}
