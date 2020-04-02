package de.fruxz.joincommand.system.configuration;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * This class makes it possible to target configuration files and manage their contents in a simple and structured way
 *
 * @author Fruxz
 * @version 1.0
 */

public class ConfigurationFile implements FileManager {

    private final File file;
    private final YamlConfiguration loader;

    /**
     * Defines the configuration file and parameters
     * @param path defines the file name and the file extension
     */

    public ConfigurationFile(String path) {
        this.file = new File("plugins/JoinCommand", path);
        this.loader = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Loads the file
     */
    @Override
    public void load() {
        try {
            loader.load(file);
        } catch (FileNotFoundException e) {

            loader.set("installed", true);
            save();

        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the file
     */
    @Override
    public void save() {
        try {
            loader.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets or changes an existing value
     * @param path defines the location of the value
     * @param v defines the new value
     */
    @Override
    public void set(String path, Object v) {
        load();
        loader.set(path, v);
        save();
    }

    /**
     * Gets a value from the file
     * @param path defines the location of the value
     * @return the value of the path
     */
    @Override
    public Object get(String path) {
        load();
        return loader.get(path);
    }

    /**
     * Gets a text from the file
     * @param path defines the location of the value
     * @return the value of the path
     */
    @Override
    public String getString(String path) {
        load();
        return loader.getString(path);
    }

    /**
     * Gets a number from the file
     * @param path defines the location of the value
     * @return the value of the path
     */
    @Override
    public Integer getInt(String path) {
        load();
        return loader.getInt(path);
    }

    /**
     * Gets a yes/no from the file
     * @param path defines the location of the value
     * @return the value of the path
     */
    @Override
    public Boolean getBoolean(String path) {
        load();
        return loader.getBoolean(path);
    }

    /**
     * Gets a list from the file
     * @param path defines the location of the value
     * @return the value of the path
     */
    @Override
    public List<?> getList(String path) {
        load();
        return loader.getList(path);
    }

    /**
     * Gets a text list from the file
     * @param path defines the location of the value
     * @return the value of the path
     */
    @Override
    public List<String> getStringList(String path) {
        load();
        return loader.getStringList(path);
    }

    /**
     * Gets a number list from the file
     * @param path defines the location of the value
     * @return the value of the path
     */
    @Override
    public List<Integer> getIntList(String path) {
        load();
        return loader.getIntegerList(path);
    }

    /**
     * Gets a yes/no list from the file
     * @param path defines the location of the value
     * @return the value of the path
     */
    @Override
    public List<Boolean> getBooleanList(String path) {
        load();
        return loader.getBooleanList(path);
    }

    /**
     * Gets the loader from the file
     * @return the loader
     */
    public YamlConfiguration getLoader() {
        return loader;
    }

    /**
     * Gets the file
     * @return the file
     */
    public File getFile() {
        return file;
    }
}
