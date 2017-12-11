package validators;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс, реализующий алгоритмы валидации всех данных банковских карт
 */
public class BankCardValidator {

    private static final boolean VALID = true;
    private static final boolean NOT_VALID = false;

    @SuppressWarnings("all")
    public enum PaymentSystem{
        AMERICAN_EXPRESS("American Express", "^3[47].*$"),
        DANKORT("Dankort", "^5019.*$"),
        DINERS_CLUB("Diners Club", "^(36|38|30[0-5]).*$"),
        DISCOVER("Discover", "^(6011|65|64[4-9]|622).*$"),
        JCB("JCB", "^35.*$"),
        LASER("Laser", "^(6706|6771|6709).*$"),
        MAESTRO("Maestro", "^(5018|5020|5038|5612|5893|6304|6759|676[1-3]|0604|6390).*$"),
        MASTERCARD("MasterCard", "(^(5[1-5]|677189)|^(222[1-9]|2[3-6]\\d{2}|27[0-1]\\d|2720)).*$"),
        UNION_PAY("UnionPay", "^62.*$"),
        VISA_ELECTRON("Visa Electron", "^4(026|17500|405|508|844|91[37]).*$"),
        VISA("Visa", "^4.*$"),
        MIR("Mir", "^22.*$");

        private String name;
        private String pattern;

        PaymentSystem(String name, String pattern) {
            this.name = name;
            this.pattern = pattern;
        }

        public String getName() {
            return name;
        }

        private String getPattern(){
            return pattern;
        }
    }

//    возможные длины номера банковской карты
    private static final int[] ALL_CARD_NUMBER_LENGTH = {11, 12, 13, 14, 15, 16, 17, 18, 19};

//    регулярное выржение для валидации даты на банковской карте
    private static Pattern dateRegular = Pattern.compile("^(0[1-9]|1[0-2])/([0-9][0-9])$");

//    регулярное выражение для валидации имени на банковской карте
    private static Pattern nameRegular = Pattern.compile("^[A-Za-z\\s\\.]{2,}$");

//    регулярное выражение для валидации CVC кода на банковской карте
    private static Pattern cvcRegular = Pattern.compile("^\\d{3,}$");


    /**
     * Метод проверяющий корректность введеного номера банковской карты
     * В данном методе реализован алгоритм Луна
     * @param number - входная строка (номер)
     * @return - true - валидный - false - невалидный
     */
    public static boolean checkValidNumber(String number){
        if(number == null || number.length() == 0){
            return NOT_VALID;
        }

//        певоначальная проверка и корректировка строки
        String newNumber = checkPrimaryCorrect(number);

        if(newNumber == null)
            return false;

//        конвертация строки в массив чисел
        int[] numberArray = convertStringToIntegerArray(newNumber);

        if(numberArray != null){
//            проверка на валидность
            return countWithLunaAlgorithm(numberArray);
        }
        return NOT_VALID;
    }

    /**
     * Данный метод проводит первоначальную корректироку строки,
     * а так же первоначальную проверку валидности введенного номера
     * @param number - строка, содержащая номер банковской карты
     * @return - строка после корректировок
     */
    private static String checkPrimaryCorrect(String number){

//        удаляем из строки все символы кроме цифр
        String newNumber = number.replaceAll("\\D", "");

//        проверяем, подходит ли по длине полученная строка
        for (int cardLength : ALL_CARD_NUMBER_LENGTH)
            if (newNumber.length() == cardLength)
                return newNumber;

        return null;
    }

    /**
     * Метод конвертирующий строку в массив int
     * @param string - входная строка
     * @return - полученный массив
     */
    private static int[] convertStringToIntegerArray(String string){
        char[] stringArray = string.toCharArray();

        int[] integerArray = new int[stringArray.length];

        for(int i = 0; i < stringArray.length; i++){
//            преобразуем символ к строке
            String s = stringArray[i] + "";

//            пытаемся получить число из строки
            try {
                integerArray[i] = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return integerArray;
    }

    /**
     * Метод меняющий числа на нужных позициях для подсчета контрольной суммы
     * @param array - номер карты, пребразованный в массив int
     */
    private static boolean countWithLunaAlgorithm(int[] array){
//        проверяем, четное или нечетное количество цифр в массиве
        if((array.length % 2) == 0){
            for(int i = 0; i < array.length; i++){
//                нужно менять только числа на нечетных позициях,
//                поскольку первое число находится на позиции 0, то нужны четные позиции
                if(i % 2 == 0)
                    array[i] = createNewNumericForLunaAlgorithm(array[i]);
            }

        } else if ((array.length % 2) == 1){
            for(int i = 0; i < array.length; i++){
//                нужно менять только числа на четных позициях,
//                поскольку первое число находится на позиции 0, то нужны нечетные позиции
                if(i % 2 == 1)
                    array[i] = createNewNumericForLunaAlgorithm(array[i]);
            }

        }

        return checkControlSum(array);
    }

    /**
     * Метод меняющий число в соответствии с алгоритмом Луна
     * @param numeric - входное число
     * @return - полученное число
     */
    private static int createNewNumericForLunaAlgorithm(int numeric){
//        число умножается на 2
//        если число больше 9, вычитаем 9
        int newNumeric = numeric * 2;

        if(newNumeric > 9)
            return newNumeric - 9;
        else
            return newNumeric;
    }

    /**
     * Метод подсчитывающий контрольную сумму и сверяющий, сходится контрольная сумма или нет
     * Результатом данного метода является результат, валидный номер карты или нет
     * @param array - измененный номер карты
     * @return - true - валидный - false - не валидный
     */
    private static boolean checkControlSum(int[] array){

        int checkSum = 0;

        for (int anArray : array)
            checkSum += anArray;

        if(checkSum % 10 == 0)
            return VALID;
        else
            return NOT_VALID;
    }


    /**
     * Данный метод опредляет тип платежной системы по введенному номеру банковской карты
     * @param number - номер банковской карты
     * @return - тип платежной системы
     */
    public static PaymentSystem getPaymentSystem(String number){

        Matcher matcher;

        PaymentSystem[] paymentSystems = PaymentSystem.values();

        for(PaymentSystem paymentSystem : paymentSystems){
            Pattern pattern = Pattern.compile(paymentSystem.getPattern());

            matcher = pattern.matcher(number);

            if(matcher.matches()){
                return paymentSystem;
            }
        }

        return null;
    }

    /**
     * Данный метод проводит валидацию введенной даты
     * @param date - введенная дата
     * @return - true - валидна - false не валидна
     */
    public static boolean checkValidDate(String date){
        date = date.replace(" ", "");

        Matcher matcher = dateRegular.matcher(date);
        if(matcher.matches()){
            String[] dateArray = date.split("/");

//            получаем из строки введенные месяц и год
            int enteredMonth, enteredYear;

            try {
                enteredMonth = Integer.parseInt(dateArray[0]);
                enteredYear = Integer.parseInt(dateArray[1]);
            } catch (Exception e) {
                e.printStackTrace();

                return false;
            }

//            получаем максимально возможную дату для карты
//            от сегодняшнего дня + 10 лет
            Calendar maxDate = Calendar.getInstance();
            maxDate.set(Calendar.YEAR, maxDate.get(Calendar.YEAR) + 10);
//            maxDate.set(Calendar.DAY_OF_MONTH, maxDate.getActualMaximum(Calendar.DAY_OF_MONTH));

//            получаем актуальную дату
            Calendar actualDate = Calendar.getInstance();

//            получаем введенную дату
            Calendar enteredDate = Calendar.getInstance();

            int newYearValue = (maxDate.get(Calendar.YEAR) / 100) * 100 + enteredYear;
            int newMonthValue = enteredMonth - 1;

            enteredDate.set(Calendar.YEAR, newYearValue);
            enteredDate.set(Calendar.MONTH, newMonthValue);
            enteredDate.set(Calendar.DAY_OF_MONTH, maxDate.getActualMaximum(Calendar.DAY_OF_MONTH));

//            праверяем, что введенная дата находится в промежутке
//            между актуальной и максимальной датой
            return enteredDate.after(actualDate) && enteredDate.before(maxDate);
        } else {
            return false;
        }
    }

    /**
     * Данный метод проводит валидацию введенной даты
     * @param name - введенное имя
     * @return - true - валидно - false не валидно
     */
    public static boolean checkValidName(String name){
        if(name != null){
            Matcher matcher = nameRegular.matcher(name);
            return matcher.matches();
        }else{
            return false;
        }
    }

    /**
     * Данный метод проводит валидацию введенного CVC кода
     * @param cvc - введенный CVC код
     * @return - true - валидно - false не валидно
     */
    public static boolean checkValidCvc(String cvc){
        if(cvc != null){
            Matcher matcher = cvcRegular.matcher(cvc);
            return matcher.matches();
        } else {
            return false;
        }
    }
}
