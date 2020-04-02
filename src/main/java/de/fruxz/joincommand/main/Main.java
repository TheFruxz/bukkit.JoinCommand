package de.fruxz.joincommand.main;

import de.fruxz.joincommand.commands.JoinCommand;
import de.fruxz.joincommand.listener.ConnectionHandler;
import de.fruxz.joincommand.system.data.Space;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class is the startup registration class, it helps to add commands and event handlers
 *
 * @author Fruxz
 * @version 1.0
 */
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("joincommand").setExecutor(new JoinCommand());
        getCommand("joincommand").setTabCompleter(new JoinCommand().tabCompleter);
        getCommand("joincommand").setPermission(Space.permission_admin);

        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new ConnectionHandler(), this);

    }

}
