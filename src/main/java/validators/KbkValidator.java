package validators;

public class KbkValidator extends BaseDigitValidator{

    public static boolean isValid(String kbk){
        return kbk != null &&
                kbk.length() == 20 &&
                digitPatten.matcher(kbk).matches();
    }
}
