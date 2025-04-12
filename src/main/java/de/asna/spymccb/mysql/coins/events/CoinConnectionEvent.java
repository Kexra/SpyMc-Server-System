package de.asna.spymccb.mysql.coins.events;

import de.asna.spymccb.Main;
import de.asna.spymccb.mysql.coins.CoinPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CoinConnectionEvent implements Listener {

    @EventHandler
    public void onPlayerCoinsConnection(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Main.getRepositorycoins().query().createIfNotExists(new CoinPlayer(player.getUniqueId(), 1000, 0, player.getName()));
    }

}
