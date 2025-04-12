package de.asna.spymccb.events;

import de.asna.spymccb.Main;
import de.asna.spymccb.utils.locations.LocationUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerConnectionEvent implements Listener {

    @EventHandler
    public void onPlayerConnectionEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.teleport(LocationUtil.getLocation("SPAWN"));
                }
            }.runTaskLater(Main.getInstance(), 3L);
        } else {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.teleport(LocationUtil.getLocation("SPAWN"));
                }
            }.runTaskLater(Main.getInstance(), 3L);
        }
        event.setJoinMessage("§8[§a+§8] §a" + player.getName());
        player.sendMessage("§7§m--------------------§8[§9INFORMATION§8]§7§m--------------------");
        player.sendMessage("§8");
        player.sendMessage("§8➥ §7Du brauchst Hilfe? §9/hilfe");
        player.sendMessage("§8➥ §7Du willst dein Plot verwalten? §9/plotgui");
        player.sendMessage("§8➥ §7Du suchst den Discord? §9/discord");
        player.sendMessage("§8");
        player.sendMessage("§7§m--------------------§8[§9INFORMATION§8]§7§m--------------------");
    }

    @EventHandler
    public void onPlayerDisconnectEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§8[§c-§8] §c" + player.getName());
    }


}
