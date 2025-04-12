package de.asna.spymccb.mysql.player.events;

import de.asna.spymccb.Main;
import de.asna.spymccb.mysql.player.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerDataConnectionEvent implements Listener {

    @EventHandler
    public void onPlayerDataConnectionEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Main.getRepositorylpayerdata().query().createIfNotExists(new PlayerData(player.getUniqueId(), 0, player.getName()));
    }


}
