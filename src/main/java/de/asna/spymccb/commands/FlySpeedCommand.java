package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FlySpeedCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.flyspeed")) {
                if (strings.length == 1) {
                    if (strings[0].equalsIgnoreCase("1")){
                        player.setFlySpeed(0.1f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §91");
                    } else if (strings[0].equalsIgnoreCase("2")) {
                        player.setFlySpeed(0.2f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §92");
                    } else if (strings[0].equalsIgnoreCase("3")) {
                        player.setFlySpeed(0.4f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §93");
                    } else if (strings[0].equalsIgnoreCase("4")) {
                        player.setFlySpeed(0.5f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §94");
                    } else if (strings[0].equalsIgnoreCase("5")) {
                        player.setFlySpeed(0.6f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §95");
                    } else if (strings[0].equalsIgnoreCase("6")) {
                        player.setFlySpeed(0.7f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §96");
                    } else if (strings[0].equalsIgnoreCase("7")) {
                        player.setFlySpeed(0.8f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §97");
                    } else if (strings[0].equalsIgnoreCase("8")) {
                        player.setFlySpeed(0.9f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §98");
                    } else if (strings[0].equalsIgnoreCase("9")) {
                        player.setFlySpeed(0.9f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §99");
                    }else if (strings[0].equalsIgnoreCase("10")) {
                        player.setFlySpeed(1.0f);
                        player.sendMessage(Main.PREFIX + "§7Dein FlySpeed beträgt §910");
                    } else {
                    player.sendMessage(Main.PREFIX + "§7Benutze: §9/flypseed <1-10>");
                }
                } else {
                    player.sendMessage(Main.PREFIX + "§7Benutze: §9/flypseed <1-10>");
                }
            } else {
                player.sendMessage(Main.NOPERM);
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (command.getName().equals("flyspeed")) {
            if (commandSender instanceof Player player) {
                if (strings.length == 1) {
                    List<String> l = new ArrayList<>();
                    l.add("1");
                    l.add("2");
                    l.add("3");
                    l.add("4");
                    l.add("5");
                    l.add("6");
                    l.add("7");
                    l.add("8");
                    l.add("9");
                    l.add("10");
                    return l;
                }
            }
        }

        return null;
    }
}
