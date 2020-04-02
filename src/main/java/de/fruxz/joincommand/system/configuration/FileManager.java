package de.fruxz.joincommand.system.configuration;

import java.util.List;

/**
 * This interface allows you to easily manage files
 *
 * @author Fruxz
 * @version 1.0
 */

public interface FileManager {

    void load();
    void save();

    void set(String path, Object v);

    Object get(String path);
    String getString(String path);
    Integer getInt(String path);
    Boolean getBoolean(String path);

    List<?> getList(String path);
    List<String> getStringList(String path);
    List<Integer> getIntList(String path);
    List<Boolean> getBooleanList(String path);

}
