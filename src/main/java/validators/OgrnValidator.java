package validators;

/**
 * The class for validating OGRN and OGRNIP
 */
public class OgrnValidator extends BaseDigitValidator{

    public static boolean isValid(String number){
        if(number == null ||
                number.length() != 13 && number.length() != 15 ||
                !digitPatten.matcher(number).matches()){

            return false;
        }

        int[] intArray = convertToIntArray(number);
        int size = intArray.length;

        long longNumber = Long.parseLong(number);

        long bodyNumber = longNumber / 10;

        int checkSum = countCheckSum(size, bodyNumber);

        if(checkSum > 9){
            checkSum %= 10;
        }

        return checkSum == intArray[size - 1];
    }

    private static int countCheckSum(int sourceSize, long number){

        switch (sourceSize){
            case 13:
                return (int) (number % 11);
            case 15:
                return (int) (number % 13);
        }

        return 0;
    }

}
