package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                player.sendMessage(Main.PREFIX + "§7Dein Ping beträgt §9" + player.getPing() + "ms");
            } else if (strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                if (target != null) {
                    player.sendMessage(Main.PREFIX + "§7Der Ping von dem Spieler §9" + target.getName() + " §7beträgt §9" + target.getPing() + "ms");
                } else {
                    player.sendMessage(Main.NOONLINE);
                }
            } else {
                player.sendMessage(Main.PREFIX + "§7Benutze: §9/ping <spieler>");
            }
        }

        return false;
    }
}
