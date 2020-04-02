package de.fruxz.joincommand.system.utils;

public class StringUtils {

    public String convertToString(String[] strings) {
        StringBuilder builder = new StringBuilder();

        for (String entry : strings) {
            builder.append(entry).append(" ");
        }

        return builder.toString();
    }

}
