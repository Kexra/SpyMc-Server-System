package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.fly")) {
                if (strings.length == 0) {
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage(Main.PREFIX + "§7Du kannst nun nicht mehr fliegen.");
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage(Main.PREFIX + "§7Du kannst nun fliegen.");
                    }
                } else if (strings.length == 1) {
                    Player opfer = Bukkit.getPlayer(strings[0]);
                    if (opfer != null) {
                        if (opfer.getAllowFlight()) {
                            opfer.setAllowFlight(false);
                            opfer.sendMessage(Main.PREFIX + "§7Du kannst nun nicht mehr fliegen.");
                            player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + opfer.getName() + " §7kann nun nicht mehr fliegen.");
                        } else {
                            opfer.setAllowFlight(true);
                            opfer.sendMessage(Main.PREFIX + "§7Du kannst nun fliegen.");
                            player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + opfer.getName() + " §7kann nun fliegen.");
                        }
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§7Benutze: §9/fly <spieler>");
                }

            } else {
                player.sendMessage(Main.NOPERM);
            }
        }
        return false;
    }
}
