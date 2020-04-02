package de.fruxz.joincommand.system.visual;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * This class helps to design and Send messages
 *
 * @author Fruxz
 * @version 1.0
 */

public class Transmission {

    private final String rawMessage;
    private final String transmission;

    /**
     * Defines the structure of the transmission
     * @param rawMessage defines the raw undesigned message
     */
    public Transmission(String rawMessage) {
        this.rawMessage = rawMessage;
        this.transmission = ChatColor.AQUA.toString() + "JoinCommand" + ChatColor.DARK_GRAY + " >> " + ChatColor.GRAY + rawMessage;
    }

    /**
     * Send the message to a player or a console
     * @param target defines the target player/console
     * @return itself
     */
    public Transmission send(CommandSender target) {
        target.sendMessage(transmission);
        return this;
    }

    /**
     * Send the message to the console
     * @return itself
     */
    public Transmission sendConsole() {
        Bukkit.getConsoleSender().sendMessage(transmission);
        return this;
    }

    /**
     * Send the message to everybody
     * @return itself
     */
    public Transmission broadcast() {
        Bukkit.broadcastMessage(transmission);
        return this;
    }

    /**
     * @return the raw undesigned message
     */
    public String getRawMessage() {
        return rawMessage;
    }

    /**
     * @return the designed message
     */
    public String getTransmission() {
        return transmission;
    }
}
