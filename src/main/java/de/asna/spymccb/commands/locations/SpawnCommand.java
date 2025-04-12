package de.asna.spymccb.commands.locations;

import de.asna.spymccb.utils.locations.LocationUtil;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            player.teleport(LocationUtil.getLocation("SPAWN"));
            player.sendTitle("§7■ §8| §9§lSPAWN §8| §7■", "§7Teleportation erfolgreich.");
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0F, 1.0F);
        }

        return false;
    }
}
