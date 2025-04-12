package de.asna.spymccb.utils.formatting;

public class FormattingUtil {

    public static String formatNumber(int value) {

        String numString = String.valueOf(value);

        int maxCount = 0;

        String result = "";

        for (int i = numString.length() - 1; i >=0; i--) {

            result = numString.charAt(i) + result;
            maxCount++;

            if (maxCount == 3 && i != 0) {
                result = "." + result;
                maxCount = 0;
            }
        }
        return result;
    }

}
