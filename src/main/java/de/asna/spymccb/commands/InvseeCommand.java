package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (strings.length == 1) {
                if (player.hasPermission("system.invsee")) {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target != null) {
                        player.openInventory(target.getInventory());
                        player.sendMessage(Main.PREFIX + "§7Du hast das Inventar von §9" + target.getName() + " §7geöffnet.");
                    } else {
                        player.sendMessage(Main.NOPERM);
                    }
                } else {
                    player.sendMessage(Main.NOPERM);
                }
            }
        }

        return false;
    }
}
