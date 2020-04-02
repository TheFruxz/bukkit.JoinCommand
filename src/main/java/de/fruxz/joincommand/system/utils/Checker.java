package de.fruxz.joincommand.system.utils;

/**
 * This class helps to check different conditions
 *
 * @author Fruxz
 * @version 1.0
 */

public class Checker {

    /**
     * Check if the String is a integer
     * @param v defines the checking string
     * @return if it is a number
     */
    public boolean isInt(String v) {
        try {
            Integer.parseInt(v);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
