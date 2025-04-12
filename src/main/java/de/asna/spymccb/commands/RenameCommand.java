package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class RenameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.rename")) {
                if (strings.length >= 1) {
                    if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                        ItemStack itemnew = player.getInventory().getItemInMainHand();
                        ItemMeta itemnewmeta = itemnew.getItemMeta();
                        try {
                            String message = "";
                            for (int i = 0; i < strings.length; i++)
                                message = String.valueOf(message) + strings[i] + " ";
                            player.sendMessage(Main.PREFIX + "§7Du hast das Item umbennant.");
                            itemnewmeta.setDisplayName(message.replaceAll("&", "§"));
                            itemnew.setItemMeta(itemnewmeta);

                        } catch (Exception e1) {

                        }
                    } else {
                        player.sendMessage(Main.PREFIX + "§7Du musst ein Item in der Hand halten.");
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§7Benutze: §9/rename <text>");
                }
            }
        }

        return false;
    }
}
