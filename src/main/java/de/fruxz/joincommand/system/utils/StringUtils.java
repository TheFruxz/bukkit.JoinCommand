package de.fruxz.joincommand.system.utils;

/**
 * This class helps to manage and convert Strings
 *
 * @author Fruxz
 * @version 1.0
 */

public class StringUtils {

    /**
     * Convert a StringArray to a string (with spaces)
     * @param strings defines the StringArray
     * @return a String
     */
    public String convertToString(String[] strings) {
        StringBuilder builder = new StringBuilder();

        for (String entry : strings) {
            builder.append(entry).append(" ");
        }

        return builder.toString();
    }

}
