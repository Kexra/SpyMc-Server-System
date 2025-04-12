package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GamemodeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.gamemode")) {
                if (strings.length == 1) {
                    if (strings[0].equalsIgnoreCase("1") || strings[0].equalsIgnoreCase("CREATIVE")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Main.PREFIX + "§7Du bist nun im §9Kreativ §7Modus.");
                    } else if (strings[0].equalsIgnoreCase("0") || strings[0].equalsIgnoreCase("SURVIVAL")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Main.PREFIX + "§7Du bist nun im §9Überlebens §7Modus.");
                    } else if (strings[0].equalsIgnoreCase("2") || strings[0].equalsIgnoreCase("ADVENTURE")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(Main.PREFIX + "§7Du bist nun im §9Abenteuer §7Modus.");
                    } else if (strings[0].equalsIgnoreCase("3") || strings[0].equalsIgnoreCase("SPECTATOR")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(Main.PREFIX + "§7Du bist nun im §9Zuschauer §7Modus.");
                    } else {
                        player.sendMessage(Main.PREFIX + "§7Benutze: §9/gamemode <0/1/2/3>");
                    }
                } else if (strings.length == 2) {
                    if (player.hasPermission("system.gamemode.other")) {
                        Player target = Bukkit.getPlayer(strings[1]);

                        if (target != null) {
                            if (strings[0].equalsIgnoreCase("1") || strings[0].equalsIgnoreCase("CREATIVE")) {
                                target.setGameMode(GameMode.CREATIVE);
                                target.sendMessage(Main.PREFIX + "§7Du bist nun im §9Kreativ §7Modus.");
                                player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7ist nun im §9Kreativ §7Modus.");
                            } else if (strings[0].equalsIgnoreCase("0") || strings[0].equalsIgnoreCase("SURVIVAL")) {
                                target.setGameMode(GameMode.SURVIVAL);
                                target.sendMessage(Main.PREFIX + "§7Du bist nun im §9Überlebens §7Modus.");
                                player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7ist nun im §9Überlebens §7Modus.");
                            } else if (strings[0].equalsIgnoreCase("2") || strings[0].equalsIgnoreCase("ADVENTURE")) {
                                target.setGameMode(GameMode.ADVENTURE);
                                target.sendMessage(Main.PREFIX + "§7Du bist nun im §9Abenteuer §7Modus.");
                                player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7ist nun im §9Abenteuer §7Modus.");
                            } else if (strings[0].equalsIgnoreCase("3") || strings[0].equalsIgnoreCase("SPECTATOR")) {
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage(Main.PREFIX + "§7Du bist nun im §9Zuschauer §7Modus.");
                                player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7ist nun im §9Zuschauer §7Modus.");
                            }
                        } else {
                            player.sendMessage(Main.NOONLINE);
                        }
                    } else {
                        player.sendMessage(Main.NOPERM);
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§7Benutze: §9/gamemode <0/1/2/3> <spieler>");
                }
            } else {
                player.sendMessage(Main.NOPERM);
            }
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (command.getName().equals("gamemode") || command.getName().equals("gm")) {
            if (strings.length == 1) {
                if (commandSender instanceof Player) {
                    List<String> l = new ArrayList<>();
                    l.add("creative");
                    l.add("survival");
                    l.add("spectator");
                    l.add("adventure");
                    return l;
                }
            } else if (strings.length == 2) {
                if (commandSender instanceof Player) {
                    if (commandSender instanceof Player player) {
                        List<String> playerNames = new ArrayList<>();
                        Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                        Bukkit.getServer().getOnlinePlayers().toArray(players);
                        for (int i = 0; i < players.length; i++) {
                            playerNames.add(players[i].getName());
                        }
                        return playerNames;
                    }
                }
            }
        }

        return null;
    }
}
