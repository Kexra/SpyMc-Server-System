package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EnderChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                player.openInventory(player.getEnderChest());
                player.sendMessage(Main.PREFIX + "§7Du hast deine §9EnderChest §7geöffnet.");
            } else if (strings.length == 1) {
                if (player.hasPermission("system.enderchest.other")) {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target != null) {
                        player.openInventory(target.getEnderChest());
                        player.sendMessage(Main.PREFIX + "§7Du hast die §9EnderChest §7von §9" + target.getName() + " §7geöffnet.");
                    } else {
                        player.sendMessage(Main.NOONLINE);
                    }
                } else {
                    player.sendMessage(Main.NOPERM);
                }
            } else {
                player.sendMessage(Main.PREFIX + "§7Benutze: §9/enderchest <spieler>");
            }
        }

        return false;
    }
}
