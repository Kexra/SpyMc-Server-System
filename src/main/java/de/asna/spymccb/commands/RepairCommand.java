package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){
            if (commandSender.hasPermission("system.repair")) {
                player.getItemInHand().setDurability((short) 0);
            }else {
                player.sendMessage(Main.NOPERM);
            }
        }
        return false;
    }
}
