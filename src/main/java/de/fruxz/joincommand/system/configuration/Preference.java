package de.fruxz.joincommand.system.configuration;

/**
 * This class helps to manage, save and change configurations of the configuration file
 * @param <T> defines the type of the value
 *
 * @author Fruxz
 * @version 1.0
 */

public class Preference<T> {

    private final String path;
    private final T defaultValue;
    private T currentValue;

    private final ConfigurationFile config = new ConfigurationFile("config.yml");

    /**
     * Defines the structure of the preference
     * @param path defines the path in the configuration file
     * @param defaultValue defines the default value of the configuration
     */
    public Preference(String path, T defaultValue) {
        this.path = path;
        this.defaultValue = defaultValue;
        if (config.get(path) != null) {
            currentValue = (T) config.get(path);
        } else {
            currentValue = defaultValue;
            config.set(path, defaultValue);
        }
    }

    /**
     * Reloads the currentValue of the preference
     */
    public void reload() {
        if (config.get(path) != null) {
            currentValue = (T) config.get(path);
        } else {
            currentValue = defaultValue;
            config.set(path, defaultValue);
        }
    }

    /**
     * @return the current path of the preference
     */
    public String getPath() {
        return path;
    }

    /**
     * @return the default value of the preference
     */
    public T getDefaultValue() {
        return defaultValue;
    }

    /**
     * Reload the preference and returns the current value of the preference
     * @return current value
     */
    public T getCurrentValue() {
        reload();
        return currentValue;
    }

    /**
     * Change the current value of the preference
     * @param currentValue current value
     */
    public void setCurrentValue(T currentValue) {
        this.currentValue = currentValue;
        config.set(path, currentValue);
    }
}
