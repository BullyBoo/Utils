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
