package de.fruxz.joincommand.commands;

import de.fruxz.joincommand.system.data.Space;
import de.fruxz.joincommand.system.utils.Checker;
import de.fruxz.joincommand.system.utils.StringUtils;
import de.fruxz.joincommand.system.visual.Transmission;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This command is the JoinCommand and helps to register the command and the tabcompleter
 *
 * @author Fruxz
 * @version 1.0
 */
public class JoinCommand implements CommandExecutor {

    private Transmission syntax(Command command) {
        return new Transmission("Bitte benutze " + ChatColor.RED + command.getUsage().replaceAll("<command>", command.getName()) + ChatColor.GRAY + "!");
    }

    private Transmission listBorder(String title) {
        return new Transmission(ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "---------" + ChatColor.AQUA + ' ' + title + ' ' + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "---------");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getPermission() == null || sender.hasPermission(command.getPermission())) {

            if (args.length == 0) {
                listBorder("JoinCommand | Befehle").send(sender);

                new Transmission(ChatColor.GREEN + "/jc add <Befehl>").send(sender);
                new Transmission(ChatColor.GREEN + "/jc remove <ID>").send(sender);
                new Transmission(ChatColor.GREEN + "/jc addfirst <Befehl>").send(sender);
                new Transmission(ChatColor.GREEN + "/jc removefirst <ID>").send(sender);
                new Transmission(ChatColor.GREEN + "/jc list").send(sender);
                new Transmission(ChatColor.GREEN + "/jc info").send(sender);
                new Transmission(ChatColor.GREEN + "/jc toggleBypassAble").send(sender);

                listBorder("JoinCommand | Befehle").send(sender);
            } else if (args.length == 1) {

                if (args[0].equalsIgnoreCase("list")) {

                    listBorder("Join-Befehle").send(sender);
                    if (!Space.list_joinCommands.getCurrentValue().isEmpty()) {
                        int id = 0;
                        for (String listEntry : Space.list_joinCommands.getCurrentValue()) {
                            new Transmission(ChatColor.GOLD.toString() + id + ChatColor.DARK_GRAY + " >> " + ChatColor.GREEN + '/' + listEntry).send(sender);
                            id++;
                        }
                    } else
                        new Transmission("Es sind " + ChatColor.RED + "keine Join-Befehle" + ChatColor.GRAY + " vorhanden!").send(sender);
                    listBorder("Join-Befehle").send(sender);

                    new Transmission(" ").send(sender);

                    listBorder("FirstJoin-Befehle").send(sender);
                    if (!Space.list_firstJoinCommands.getCurrentValue().isEmpty()) {
                        int id = 0;
                        for (String listEntry : Space.list_firstJoinCommands.getCurrentValue()) {
                            new Transmission(ChatColor.GOLD.toString() + id + ChatColor.DARK_GRAY + " >> " + ChatColor.GREEN + '/' + listEntry).send(sender);
                            id++;
                        }
                    } else
                        new Transmission("Es sind " + ChatColor.RED + "keine FirstJoin-Befehle" + ChatColor.GRAY + " vorhanden!").send(sender);
                    listBorder("FirstJoin-Befehle").send(sender);

                } else if (args[0].equalsIgnoreCase("info")) {
                    new Transmission("Programmiert von: " + ChatColor.GOLD + "Fruxz (TheFruxz)" + ChatColor.GRAY + " Idee gehört: " + ChatColor.AQUA + "TheRedVillager" + ChatColor.GRAY + "!" + ChatColor.DARK_GRAY + " | " + ChatColor.DARK_AQUA + "Quelle: https://forum.neruxvace.net/threads/joincommand.36979/").send(sender);
                } else if (args[0].equalsIgnoreCase("toggleBypassAble")) {
                    Space.system_isBypassAble.setCurrentValue(!Space.system_isBypassAble.getCurrentValue());

                    if (Space.system_isBypassAble.getCurrentValue()) {
                        new Transmission("Die Join-Commands können " + ChatColor.GREEN + "nun" + ChatColor.GRAY + " mit der Berechtigung " + ChatColor.YELLOW + Space.permission_bypass + ChatColor.GRAY + " umgangen werden!").send(sender);
                    } else
                        new Transmission("Die Join-Commands können " + ChatColor.RED + "nun nicht mehr" + ChatColor.GRAY + " mit der Berechtigung " + ChatColor.YELLOW + Space.permission_bypass + ChatColor.GRAY + " umgangen werden!").send(sender);

                } else
                    syntax(command).send(sender);

            } else if (args.length == 2) {
                if (new Checker().isInt(args[1])) {
                    int selected = Integer.parseInt(args[1]);
                    if (args[0].equalsIgnoreCase("remove")) {
                        if (selected >= 0 && Space.list_joinCommands.getCurrentValue().size() > selected) {
                            ArrayList<String> commands = new ArrayList<>(Space.list_joinCommands.getCurrentValue());
                            String deletingEntry = "" + commands.get(selected);
                            commands.remove(selected);
                            Space.list_joinCommands.setCurrentValue(commands);
                            new Transmission( ChatColor.GREEN + "Erfolgreich" + ChatColor.GRAY + " den Eintrag " + ChatColor.YELLOW + deletingEntry + ChatColor.GRAY + " gelöscht!").send(sender);
                        } else
                            new Transmission("Es existiert " + ChatColor.RED + "kein Eintrag mit der ID " + ChatColor.YELLOW + selected + ChatColor.GRAY + "!").send(sender);
                    } else if (args[0].equalsIgnoreCase("removefirst")) {
                        if (selected >= 0 && Space.list_firstJoinCommands.getCurrentValue().size() > selected) {
                            ArrayList<String> commands = new ArrayList<>(Space.list_firstJoinCommands.getCurrentValue());
                            String deletingEntry = "" + commands.get(selected);
                            commands.remove(selected);
                            Space.list_firstJoinCommands.setCurrentValue(commands);
                            new Transmission( ChatColor.GREEN + "Erfolgreich" + ChatColor.GRAY + " den Eintrag " + ChatColor.YELLOW + deletingEntry + ChatColor.GRAY + " gelöscht!").send(sender);
                        } else
                            new Transmission("Es existiert " + ChatColor.RED + "kein Eintrag mit der ID " + ChatColor.YELLOW + selected + ChatColor.GRAY + "!").send(sender);
                    } else
                        syntax(command).send(sender);
                } else
                    new Transmission("Der Eingabewert " + ChatColor.YELLOW + args[0] + ChatColor.GRAY + "ist " + ChatColor.RED + "keine gültige Zahl" + ChatColor.GRAY + "!").send(sender);
            } else {
                if (args[0].equalsIgnoreCase("add")) {
                    String entry = new StringUtils().convertToString(args).replaceFirst(args[0] + " ", "");
                    ArrayList<String> commands = new ArrayList<>(Space.list_joinCommands.getCurrentValue());
                    commands.add(entry);
                    Space.list_joinCommands.setCurrentValue(commands);
                    new Transmission( ChatColor.GREEN + "Erfolgreich" + ChatColor.GRAY + " den Eintrag " + ChatColor.YELLOW + entry + ChatColor.GRAY + " hinzugefügt!").send(sender);
                } else if (args[0].equalsIgnoreCase("addfirst")) {
                    String entry = new StringUtils().convertToString(args).replaceFirst(args[0] + " ", "");
                    ArrayList<String> commands = new ArrayList<>(Space.list_firstJoinCommands.getCurrentValue());
                    commands.add(entry);
                    Space.list_firstJoinCommands.setCurrentValue(commands);
                    new Transmission( ChatColor.GREEN + "Erfolgreich" + ChatColor.GRAY + " den Eintrag " + ChatColor.YELLOW + entry + ChatColor.GRAY + " hinzugefügt!").send(sender);
                } else
                    syntax(command).send(sender);
            }

        } else
            new Transmission(command.getPermissionMessage()).send(sender);

        return true;
    }

    public TabCompleter tabCompleter = (sender, command, alias, args) -> {

        if (args.length == 1) {
            return Arrays.asList("add", "remove", "addfirst", "removefirst", "list", "info", "togglebypassable");
        } else if (args.length > 1) {
            return Collections.singletonList("[BEFEHL]");
        }

        return Collections.singletonList(" ");
    };
}
