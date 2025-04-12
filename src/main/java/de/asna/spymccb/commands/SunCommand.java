package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SunCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player){
            if (commandSender.hasPermission("system.sun")){
                player.getWorld().setClearWeatherDuration(10000);
                player.sendMessage(Main.PREFIX + " §aEs scheint Nun die Sonne auf" + " §f" + player.getWorld() );
            }else {
                player.sendMessage(Main.PREFIX + " §4Dazu hast du Keine Berechtigung!");
            }
        }else {
            commandSender.sendMessage("§4Dazu musst du Ein spieler Sein!");
        }
        return false;
    }
}
