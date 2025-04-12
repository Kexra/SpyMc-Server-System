package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.tp")) {
                if (strings.length == 1) {
                    Player opfer = Bukkit.getPlayer(strings[0]);
                    if (opfer != null) {
                        player.teleport(opfer.getLocation());
                        player.sendMessage(Main.PREFIX + "§7Du hast dich zu §9" + opfer.getName() + " §7teleportiert.");
                    } else {
                        player.sendMessage(Main.NOONLINE);
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§7Benutze: §9/tp <spieler>");
                }
            }else {
                player.sendMessage(Main.NOPERM);
            }
        }
        return false;
    }
}

