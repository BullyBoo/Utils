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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringUtils {

    /**
     * The method for inverting input string
     * Example:
     * Input : abcdef
     * Result : fedcba
     *
     * @param input - string which will inverting
     * @return - inverting string
     */
    public static String invertString(String input){
        if(input == null){
            return null;

        } else if(input.length() == 0 || input.length() == 1){
            return input;
        }

        char[] inputArray = input.toCharArray();

        int lastIndex = inputArray.length - 1;
        int half = inputArray.length / 2;

        for(int i = 0; i < half; i++){
            char temp = inputArray[i];
            inputArray[i] = inputArray[lastIndex - i];
            inputArray[lastIndex - i] = temp;
        }

        return new String(inputArray);
    }

    /**
     * The method for inverting words
     * Example:
     * Input : hello java world
     * Result : world java hello
     *
     * @param input - input sentence for inverting
     * @return - invert string
     */
    public static String invertWords(String input){
        if(input == null){
            return null;
        } else if(input.length() == 0){
            return input;
        }

        String[] array = input.split(" ");

        StringBuilder sb = new StringBuilder();

        int size = array.length;

        for(int i = size - 1; i >= 0; i--){
            sb.append(array[i]).append(" ");
        }

//        removing last space
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }

    /**
     * The method for creating string with a capital letter
     * Example:
     * Input : abc
     * Result : Abc
     *
     * @param input - string which will with a capital letter
     * @return - string with a capital letter
     */
    public static String toCapitalLetter(String input){
        if(input == null){
            return null;

        } else if(input.length() == 0){
            return input;
        }

        char firstChar = input.charAt(0);

        return Character.toUpperCase(firstChar) + input.substring(1);
    }

    /**
     * The method for creating strings with a capital letter
     *
     * @param array - string array
     * @return - strings with a capital letter
     */
    public static String[] toCapitalLetter(String ... array){
        return toCase(array, StringUtils::toCapitalLetter);
    }

    /**
     * The method for creating strings with a capital letter
     *
     * @param stringList - string array
     * @return - strings with a capital letter
     */
    public static List<String> toCapitalLetter(List<String> stringList){
        return toCase(stringList, StringUtils::toCapitalLetter);
    }

    /**
     * The method for converting string array to array with strings in upper case
     * Example:
     * Input : {abc, qwe, zxc}
     * Result : {ABC, QWE, ZXO}
     *
     * @param array - source array
     * @return - strings in upper case
     */
    public static String[] toUpperCase(String ... array){
        return toCase(array, s -> s = s.toUpperCase());
    }

    public static List<String> toUpperCase(List<String> stringList){
        return toCase(stringList, s -> s = s.toUpperCase());
    }

    /**
     * The method for converting string array to array with strings in upper case
     * Example:
     * Input : {abc, qwe, zxc}
     * Result : {ABC, QWE, ZXO}
     *
     * @param array - source array
     * @return - strings in upper case
     */
    public static String[] toLowerCase(String ... array){
        return toCase(array, s -> s = s.toLowerCase());
    }

    public static List<String> toLowerCase(List<String> stringList){
        return toCase(stringList, s -> s = s.toLowerCase());
    }

    private static String[] toCase(String[] array, Consumer<String> action){
        if(array == null){
            return null;
        } else if(array.length == 0){
            return array;
        }
        return Arrays.stream(array)
                .peek(action)
                .toArray(String[]::new);
    }

    private static List<String> toCase(List<String> stringList, Consumer<String> action){
        if(stringList == null){
            return null;
        } else if(stringList.isEmpty()){
            return stringList;
        }
        return stringList.stream()
                .peek(action)
                .collect(Collectors.toList());
    }

    /**
     * The method for calculating the count of the particular character in input string
     * Example:
     * Input : "abcabc", 'a'
     * Result : 2
     * @param input - input string
     * @param character - particular character
     * @return - count
     */
    public static int getCharacterCount(String input, char character){
        return count(input, c -> c == character);
    }

    /**
     * The method for calculating the count of digits in input string
     * Example:
     * Input : 123abs43ddd
     * Result : 5
     *
     * @param input - input string
     * @return - count of digits
     */
    public static int getDigitsCount(String input){
        return count(input, Character::isDigit);
    }

    /**
     * The method for calculating the count of letters in input string
     * Example:
     * Input : 123abs43ddd
     * Result : 6
     *
     * @param input - input string
     * @return - count of digits
     */
    public static int getLettersCount(String input){
        return count(input, Character::isLetter);
    }

    /**
     * The method for calculating the count of spaces in input string
     * Example:
     * Input : "123 abs 43 ddd"
     * Result : 3
     *
     * @param input - input string
     * @return - count of digits
     */
    public static int getSpacesCount(String input){
        return count(input, Character::isSpaceChar);
    }

    /**
     * The method for calculating the count of letters in lower case in input string
     * Example:
     * Input : "123 abs 43 ddd"
     * Result : 6
     *
     * @param input - input string
     * @return - count of digits
     */
    public static int getLowerCaseLettersCount(String input){
        return count(input, Character::isLowerCase);
    }

    /**
     * The method for calculating the count of letters in lower case in input string
     * Example:
     * Input : "123 ABS 43 ddd"
     * Result : 3
     *
     * @param input - input string
     * @return - count of digits
     */
    public static int getUpperCaseLettersCount(String input){
        return count(input, Character::isUpperCase);
    }

    private static int count(String input, Predicate<Character> predicate){
        if(input == null || input.length() == 0){
            return 0;
        }

        int count = 0;
        int size = input.length();

        for(int i = 0; i < size; i++){
            if(predicate.test(input.charAt(i))){
                count++;
            }
        }

        return count;
    }

    public static String[] sortByAlphabetical(String ... array){
        return sort(array, String.CASE_INSENSITIVE_ORDER);
    }

    public static List<String> sortByAlphabetical(List<String> stringList){
        return sort(stringList, String.CASE_INSENSITIVE_ORDER);
    }

    public static String[] sortByReverseAlphabetical(String ... array){
        return sort(array, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    }

    public static List<String> sortByReverseAlphabetical(List<String> stringList){
        return sort(stringList, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    }

    private static String[] sort(String[] array, Comparator<String> comparator){
        if(array == null){
            return null;
        } else if(array.length == 0){
            return array;
        }
        return Arrays.stream(array)
                .sorted(comparator)
                .toArray(String[]::new);
    }

    private static List<String> sort(List<String> stringList, Comparator<String> comparator){
        if(stringList == null){
            return null;
        } else if(stringList.isEmpty()){
            return stringList;
        }
        return stringList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public static int similar(String checkable, String original){
        int checkableLength = checkable.length();
        int originalLength = original.length();

        int[] checkableArray;
        int[] originalArray = new int[originalLength + 1];

        for(int i = 0; i <= originalLength; i++) {
            originalArray[i] = i;
        }

        for(int i = 1; i <= checkableLength; i++) {
            checkableArray = originalArray;
            originalArray = new int[originalLength + 1];

            for(int j = 0; j <= originalLength; j++) {
                if(j == 0){
                    originalArray[j] = i;
                } else {
                    int cost = (checkable.charAt(i - 1) != original.charAt(j - 1)) ? 1 : 0;

                    if(originalArray[j - 1] < checkableArray[j]
                            && originalArray[j - 1] < checkableArray[j - 1] + cost) {
                        originalArray[j] = originalArray[j - 1] + 1;

                    } else if(checkableArray[j] < checkableArray[j - 1] + cost) {
                        originalArray[j] = checkableArray[j] + 1;

                    } else {
                        originalArray[j] = checkableArray[j - 1] + cost;
                    }
                }
            }
        }

        return originalArray[originalLength];
    }
}
