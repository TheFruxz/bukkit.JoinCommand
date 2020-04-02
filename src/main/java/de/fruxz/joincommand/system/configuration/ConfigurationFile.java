package de.fruxz.joincommand.system.configuration;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ConfigurationFile implements FileManager {

    private final File file;
    private final YamlConfiguration loader;

    public ConfigurationFile(String path) {
        this.file = new File("plugins/JoinCommand", path);
        this.loader = YamlConfiguration.loadConfiguration(file);
    }

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

    @Override
    public void save() {
        try {
            loader.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void set(String path, Object v) {
        load();
        loader.set(path, v);
        save();
    }

    @Override
    public Object get(String path) {
        load();
        return loader.get(path);
    }

    @Override
    public String getString(String path) {
        load();
        return loader.getString(path);
    }

    @Override
    public Integer getInt(String path) {
        load();
        return loader.getInt(path);
    }

    @Override
    public Boolean getBoolean(String path) {
        load();
        return loader.getBoolean(path);
    }

    @Override
    public List<?> getList(String path) {
        load();
        return loader.getList(path);
    }

    @Override
    public List<String> getStringList(String path) {
        load();
        return loader.getStringList(path);
    }

    @Override
    public List<Integer> getIntList(String path) {
        load();
        return loader.getIntegerList(path);
    }

    @Override
    public List<Boolean> getBooleanList(String path) {
        load();
        return loader.getBooleanList(path);
    }

    public YamlConfiguration getLoader() {
        return loader;
    }

    public File getFile() {
        return file;
    }
}
