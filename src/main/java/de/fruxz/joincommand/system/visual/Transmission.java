package de.fruxz.joincommand.system.visual;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Transmission {

    private final String rawMessage;
    private final String transmission;

    public Transmission(String rawMessage) {
        this.rawMessage = rawMessage;
        this.transmission = ChatColor.AQUA.toString() + "JoinCommand" + ChatColor.DARK_GRAY + " >> " + ChatColor.GRAY + rawMessage;
    }

    public Transmission send(CommandSender target) {
        target.sendMessage(transmission);
        return this;
    }

    public Transmission sendConsole() {
        Bukkit.getConsoleSender().sendMessage(transmission);
        return this;
    }

    public Transmission broadcast() {
        Bukkit.broadcastMessage(transmission);
        return this;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public String getTransmission() {
        return transmission;
    }
}
