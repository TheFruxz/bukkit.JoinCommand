package de.fruxz.joincommand.system.configuration;

public class Preference<T> {

    private final String path;
    private final T defaultValue;
    private T currentValue;

    private final ConfigurationFile config = new ConfigurationFile("config.yml");

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

    public void reload() {
        if (config.get(path) != null) {
            currentValue = (T) config.get(path);
        } else {
            currentValue = defaultValue;
            config.set(path, defaultValue);
        }
    }

    public String getPath() {
        return path;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public T getCurrentValue() {
        reload();
        return currentValue;
    }

    public void setCurrentValue(T currentValue) {
        this.currentValue = currentValue;
        config.set(path, currentValue);
    }
}
