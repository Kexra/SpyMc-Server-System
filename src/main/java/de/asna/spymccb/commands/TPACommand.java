package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TPACommand implements CommandExecutor {

    Map<Player, Player> requests = new ConcurrentHashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            switch (label) {
                case "tpa": {
                    if (strings.length == 1) {
                        if (!player.getName().equals(strings[0])) {
                            if (Bukkit.getPlayer(strings[0]) != null) {
                                Player target = Bukkit.getPlayer(strings[0]);
                                player.sendMessage(Main.PREFIX + "§7Du hast §9" + target.getName() + " §7eine Anfrage geschickt. §8(§7Teleportation§8)");
                                target.sendMessage(Main.PREFIX + "§7Der Spieler §9" + player.getName() + " §7hat dir eine Anfrage geschickt. §8(§7Teleportation§8)");
                                target.sendMessage(Main.PREFIX + "§7Nehme sie mit §9/tpaaccept §7an.");

                                requests.put(player, target);
                            } else {
                                player.sendMessage(Main.NOONLINE);
                            }
                        } else {
                            player.sendMessage(Main.PREFIX + "§cDu kannst dir selber keine Anfrage schicken.");
                        }
                    }
                    break;
                }
                case "tpaaccept": {
                    if (requests.containsValue(player)) {
                        player.sendMessage(Main.PREFIX + "§7Du hast die Anfrage angenommen.");
                        for (Map.Entry<Player, Player> entry : requests.entrySet()) {
                            if (entry.getValue().equals(player)) {
                                entry.getKey().teleportAsync(entry.getValue().getLocation());
                                requests.remove(entry.getKey());
                                break;
                            }
                        }
                    }
                    break;
                }
            }

        }

        return true;
    }
}
