package de.asna.spymccb.commands.locations;

import de.asna.spymccb.Main;
import de.asna.spymccb.utils.locations.LocationUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.setspawn")) {
                String warp = "SPAWN";
                LocationUtil.setLocation(player.getLocation(), warp);
                player.sendMessage(Main.PREFIX + "§7Du hast erfolgreich den Spawn gesetzt!");
            } else {
                player.sendMessage(Main.NOPERM);
            }
        }

        return false;
    }
}
