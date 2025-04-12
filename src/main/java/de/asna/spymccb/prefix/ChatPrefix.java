package de.asna.spymccb.prefix;

import de.asna.spymccb.utils.luckperms.LuckPermsUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPrefix implements Listener {

    @EventHandler
    public void onAsyncChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
        Bukkit.broadcastMessage(LuckPermsUtil.getMetaData(player).getPrefix().replaceAll("&", "§") + " §8✘ §7" + player.getName() + " §8➡ §7" + event.getMessage().replaceAll("&", "§"));
    }

}
