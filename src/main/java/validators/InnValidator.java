package validators;

/**
 * The class for validating INN number
 */
public class InnValidator extends BaseDigitValidator{

    /**
     * S-box for calculating the first number of checksum for the INN number
     * with the length of 12 digits
     */
    private static final int[] S_BOX_INN_12_1 = {
            7, 2, 4, 10, 3, 5, 9, 4, 6 ,8
    };

    /**
     * S-box for calculating the second number of checksum for the INN number
     * with length of 12 digits
     */
    private static final int[] S_BOX_INN_12_2 = {
            3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8
    };

    /**
     * S-box for calculating checksum for the INN number
     * with length of 10 digits
     */
    private static final int[] S_BOX_INN_10 = {
            2, 4, 10, 3, 5, 9, 4, 6, 8
    };

    /**
     * Method for validation INN number
     * @param inn - inn source number
     * @return - true - valid false - invalid
     */
    public static boolean isValid(String inn){
        if(inn == null ||
                inn.length() != 10 && inn.length() != 12 ||
                !digitPatten.matcher(inn).matches()){
            return false;
        }

        int[] intArray = convertToIntArray(inn);

        int[] innBody = getBody(intArray);

        int size = intArray.length;

        switch (size){
            case 10:
                int checkSum = countCheckSum(innBody, S_BOX_INN_10);

                return checkSum == intArray[size - 1];
            case 12:
                int[] newBody = new int[innBody.length + 1];

                System.arraycopy(innBody, 0, newBody, 0, innBody.length);
                newBody[innBody.length] = countCheckSum(innBody, S_BOX_INN_12_1);

                int second = countCheckSum(newBody, S_BOX_INN_12_2);

                return newBody[newBody.length - 1] == intArray[size - 2] &&
                        second == intArray[size - 1];
        }
        return false;
    }

    /**
     * Getting body of INN number, which will be using for calculating check sum
     * @param input - source of INN number
     * @return - body array
     */
    private static int[] getBody(int[] input){
        int ending = 0;

        switch (input.length) {
            case 10:
                ending = 1;
                break;
            case 12:
                ending = 2;
                break;
        }

        return getBody(input, ending);
    }

    /**
     * Method for calculating check sum of INN number
     * @param array - inn body array
     * @param sBox - S-BOX array
     * @return - check sum
     */
    private static int countCheckSum(int[] array, int[] sBox){

        int size = sBox.length;

        int count = 0;

        for(int i = 0; i < size; i++){
            count += array[i] * sBox[i];
        }

        return count % 11;
    }
}
