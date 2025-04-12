package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.craft")) {
                player.openWorkbench(null, true);
                player.sendMessage(Main.PREFIX + "§7Du hast erfolgreich eine §9Werkbank §7geöffnet.");
            } else {
                player.sendMessage(Main.NOPERM);
            }
        }

        return false;
    }
}
