package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FoodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                if (player.hasPermission("system.food")) {
                    int input = 20;
                    player.setFoodLevel(input);
                    player.sendMessage(Main.PREFIX + "§7Du hast nun kein Hunger mehr.");
                }
            } else if (strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                if (player.hasPermission("system.food.other")) {
                    if (target != null) {
                        int input = 20;
                        target.setFoodLevel(input);
                        target.sendMessage(Main.PREFIX + "§7Du hast nun kein Hunger mehr.");
                        player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7hat nun kein Hunger mehr.");
                    } else {
                        player.sendMessage(Main.NOONLINE);
                    }
                }
            } else {
                player.sendMessage(Main.PREFIX + "§7Benutze: §9/food <spieler>");
            }
        }
        return false;

    }
}
