package de.fruxz.joincommand.system.utils;

public class Checker {

    public boolean isInt(String v) {
        try {
            Integer.parseInt(v);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
