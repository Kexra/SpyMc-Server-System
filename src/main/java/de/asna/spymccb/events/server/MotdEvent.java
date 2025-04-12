package de.asna.spymccb.events.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdEvent implements Listener {

    @EventHandler
    public void onServerPingEvent(ServerListPingEvent event) {
        event.setMotd("          §9§o■ §8┃ §x§0§0§8§c§f§f§lSPYMC §8● §7CityBuild §8» §9§o1.20.§9§o§k0 §8┃ §9§o■ \n           §7Discord §8» §9discord.spymc.de");

    }

}
