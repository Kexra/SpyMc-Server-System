package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class SkullCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.skull")) {
                if (strings.length == 1) {
                    ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                    skullMeta.setDisplayName("§7Kopf von §9" + strings[0]);
                    skullMeta.setOwner(strings[0]);
                    skull.setItemMeta(skullMeta);
                    player.getInventory().addItem(skull);

                    player.sendMessage(Main.PREFIX + "§7Du hast den Kopf von §9" + strings[0] + " §7bekommen");
                } else {
                    player.sendMessage(Main.PREFIX + "§7Benutze: §9/kopf <spieler>");
                }
            } else {
                player.sendMessage(Main.NOPERM);
            }
        }

        return false;
    }
}
