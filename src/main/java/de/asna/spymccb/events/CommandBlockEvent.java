package de.asna.spymccb.events;

import de.asna.spymccb.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.jetbrains.annotations.NotNull;

public class CommandBlockEvent implements Listener {

    @EventHandler
    public void onCommandBlockEvent(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        if (message.equalsIgnoreCase("/pl")) {
            if (!player.hasPermission("system.admin")){
                event.setCancelled(true);
                player.sendMessage(Main.PREFIX + "§7Nutze /hilfe");
            }
        } else if (message.equalsIgnoreCase("/plugins")) {
            if (!player.hasPermission("system.admin")){
                event.setCancelled(true);
                player.sendMessage(Main.PREFIX + "§7Nutze /hilfe");
            }
        } else if (message.equalsIgnoreCase("/bukkit:plugins")) {
            if (!player.hasPermission("system.admin")){
                event.setCancelled(true);
                player.sendMessage(Main.PREFIX + "§7Nutze /hilfe");
            }
        } else if (message.equalsIgnoreCase("/bukkit:pl")) {
            if (!player.hasPermission("system.admin")){
                event.setCancelled(true);
                player.sendMessage(Main.PREFIX + "§7Nutze /hilfe");
            }
        } else if (message.equalsIgnoreCase("/help")) {
            if (!player.hasPermission("system.admin")){
                event.setCancelled(true);
                player.sendMessage(Main.PREFIX + "§7Nutze /hilfe");
            }
        } else if (message.equalsIgnoreCase("/bukkit:help")) {
            if (!player.hasPermission("system.admin")){
                event.setCancelled(true);
                player.sendMessage(Main.PREFIX + "§7Nutze /hilfe");
            }
        } else if (message.equalsIgnoreCase("/?")) {
            if (!player.hasPermission("system.admin")){
                event.setCancelled(true);
                player.sendMessage(Main.PREFIX + "§7Nutze /hilfe");
            }
        } else if (message.equalsIgnoreCase("/bukkit:?")) {
            if (!player.hasPermission("system.admin")){
                event.setCancelled(true);
                player.sendMessage(Main.PREFIX + "§7Nutze /hilfe");
            }
        }
    }
}
