package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.clearchat")) {
                if (player.hasPermission("system.clearchat.admin")){
                    Bukkit.broadcastMessage(Main.PREFIX + "§7Der Spieler §9" + player.getName() + "§7hat den Chat geleert.");
                }
                for (int i = 0; i < 500; i++) {
                    Bukkit.broadcastMessage("§8 ");
                }
                Bukkit.broadcastMessage(Main.PREFIX + "§7Der Spieler §9" + player.getName() + " §7hat den Chat geleert.");
            } else {
                player.sendMessage(Main.NOPERM);
            }
        }

        return false;
    }
}
