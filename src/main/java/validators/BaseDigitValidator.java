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
