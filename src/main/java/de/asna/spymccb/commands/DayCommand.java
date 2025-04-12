package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.day")) {
                player.getWorld().setTime(1000);
                player.sendMessage(Main.PREFIX + " §aEs ist Nun Tag auf" + " §f" + player.getWorld());
            }else {
                commandSender.sendMessage(Main.PREFIX + " §4Dazu hast du Keine Berechtigung!");
            }
        }else {
            commandSender.sendMessage("§4Du musst Ein Spieler sein um Diesen Befehl auszuführen!");
        }
        return false;
    }
}
