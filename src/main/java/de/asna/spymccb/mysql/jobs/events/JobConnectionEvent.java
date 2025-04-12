package de.asna.spymccb.mysql.jobs.events;

import de.asna.spymccb.Main;
import de.asna.spymccb.mysql.jobs.JobPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class JobConnectionEvent implements Listener {

    @EventHandler
    public void onPlayerJobsConnection(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Main.getRepositoryjobs().query().createIfNotExists(new JobPlayer(player.getUniqueId(), "NONE", player.getName()));
    }

}
