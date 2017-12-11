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
