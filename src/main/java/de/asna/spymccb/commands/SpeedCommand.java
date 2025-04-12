package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.speed")) {
                if (strings.length == 1) {
                    if (strings[0].equalsIgnoreCase("1")) {
                        player.setWalkSpeed(0.1f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §91");
                    } else if (strings[0].equalsIgnoreCase("2")) {
                        player.setWalkSpeed(0.2f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §92");
                    } else if (strings[0].equalsIgnoreCase("3")) {
                        player.setWalkSpeed(0.4f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §93");
                    } else if (strings[0].equalsIgnoreCase("4")) {
                        player.setWalkSpeed(0.5f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §94");
                    } else if (strings[0].equalsIgnoreCase("5")) {
                        player.setWalkSpeed(0.6f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §95");
                    } else if (strings[0].equalsIgnoreCase("6")) {
                        player.setWalkSpeed(0.7f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §96");
                    } else if (strings[0].equalsIgnoreCase("7")) {
                        player.setWalkSpeed(0.8f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §97");
                    } else if (strings[0].equalsIgnoreCase("8")) {
                        player.setWalkSpeed(0.9f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §98");
                    } else if (strings[0].equalsIgnoreCase("9")) {
                        player.setWalkSpeed(0.9f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §99");
                    } else if (strings[0].equalsIgnoreCase("10")) {
                        player.setWalkSpeed(1.0f);
                        player.sendMessage(Main.PREFIX + "§7Dein WalkSpeed beträgt §910");
                    } else {
                        commandSender.sendMessage(Main.PREFIX + " §7Benutze: §9/speed <1-10>");
                    }
                } else {
                    commandSender.sendMessage(Main.PREFIX + " §7Benutze: §9/speed <1-10>");
                }
            }else {
                commandSender.sendMessage(Main.NOPERM);
            }
        }

        return false;
    }}
