package de.fruxz.joincommand.listener;

import de.fruxz.joincommand.system.data.Space;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("joincommand.bypass")) {
            for (String command : Space.list_joinCommands.getCurrentValue()) {
                player.performCommand(command);
            }

            if (!player.hasPlayedBefore()) {
                for (String command : Space.list_firstJoinCommands.getCurrentValue()) {
                    player.performCommand(command);
                }
            }

        }

    }

}
