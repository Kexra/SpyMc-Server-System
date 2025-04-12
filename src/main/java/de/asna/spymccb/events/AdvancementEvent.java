package de.asna.spymccb.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class AdvancementEvent implements Listener {

    @EventHandler
    public void onCompleteAdvancement(PlayerAdvancementDoneEvent event) {
        event.message(null);
    }

}
