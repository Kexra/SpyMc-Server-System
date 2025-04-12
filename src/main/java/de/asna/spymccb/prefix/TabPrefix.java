package de.asna.spymccb.prefix;

import de.asna.spymccb.Main;
import de.asna.spymccb.scoreboard.ScoreBoard;
import de.asna.spymccb.utils.luckperms.LuckPermsUtil;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class TabPrefix implements Listener {

    @EventHandler
    public void onPlayerConnectEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        for (Player online : Bukkit.getOnlinePlayers()){
            Main.getInstance().getTabList().setPlayerList(online);
            Main.getInstance().getTabList().setAllPlayerTeam();
        }
        player.setPlayerListName(LuckPermsUtil.getMetaData(player).getPrefix().replaceAll("&", "§") + " §8✘ §7" + player.getName());
        ScoreBoard.boardMap.put(player, new FastBoard(player));
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    Main.getInstance().getTabList().setPlayerList(online);
                    Main.getInstance().getTabList().setAllPlayerTeam();
                }
            }
        }.runTaskTimer(Main.getInstance(), 100, 50);
    }

    @EventHandler
    public void OnPlayerDisconnectEvent(PlayerQuitEvent event) {
        ScoreBoard.boardMap.remove(event.getPlayer());
    }

}