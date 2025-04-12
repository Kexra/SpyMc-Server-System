package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        int input = 20;
        if (commandSender instanceof Player player) {

            if (strings.length == 0) {
                if (player.hasPermission("system.heal")) {
                    player.setHealth(input);
                    player.sendMessage(Main.PREFIX + "§7Du wurdest geheilt.");
                } else {
                    player.sendMessage(Main.NOPERM);
                }
            } else if (strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                if (player.hasPermission("system.heal.other")) {
                    if (target != null) {
                        target.setHealth(input);
                    } else {
                        player.sendMessage(Main.NOONLINE);
                    }
                } else {
                    player.sendMessage(Main.NOPERM);
                }
            } else {
                player.sendMessage(Main.PREFIX + "§7Benutze: §9/heal <spieler>");
            }

        }
        return false;
    }
}
