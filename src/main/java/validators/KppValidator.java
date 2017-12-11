package validators;

import java.util.regex.Pattern;

public class KppValidator {

    private static final Pattern kppPattern = Pattern.compile("^[0-9]{4}[0-9A-Z]{2}[0-9]{3}$");

    public static boolean isValid(String kpp){
        if(kpp == null ||
                kpp.length() != 9){

            return false;
        }

        return kppPattern.matcher(kpp).matches();
    }
}
