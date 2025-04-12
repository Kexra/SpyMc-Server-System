package de.asna.spymccb.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HilfeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                player.sendMessage("§7§m--------------------§8[§9HILFE§8]§7§m--------------------");
                player.sendMessage("§8");
                player.sendMessage("§8➥ §7Du willst ein Plot erstellen? §9/plot auto");
                player.sendMessage("§8➥ §7Du willst dein Plot verwalten? §9/plotgui");
                player.sendMessage("§8➥ §7Du suchst den Discord? §9/discord");
                player.sendMessage("§8➥ §7Du willst deine Bank verwalten? §9/bank");
                player.sendMessage("§8");
                player.sendMessage("§7§m--------------------§8[§9HILFE§8]§7§m--------------------");
            } else if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("1")) {
                    player.sendMessage("§7§m--------------------§8[§9HILFE§8]§7§m--------------------");
                    player.sendMessage("§8");
                    player.sendMessage("§8➥ §7Du willst ein Plot erstellen? §9/plot auto");
                    player.sendMessage("§8➥ §7Du willst dein Plot verwalten? §9/plotgui");
                    player.sendMessage("§8➥ §7Du suchst den Discord? §9/discord");
                    player.sendMessage("§8➥ §7Du willst deine Bank verwalten? §9/bank");
                    player.sendMessage("§8");
                    player.sendMessage("§7§m--------------------§8[§9HILFE§8]§7§m--------------------");
                } else if (strings[0].equalsIgnoreCase("2")) {
                    player.sendMessage("§7§m--------------------§8[§9HILFE§8]§7§m--------------------");
                    player.sendMessage("§8");
                    player.sendMessage("§8➥ §7Du suchst die Farmwelt? §9/warps");
                    player.sendMessage("§8➥ §7Du willst Geld verdienen? §9/job");
                    player.sendMessage("§8➥ §7Du willst ein Kisten Shop erstellen? §9/kistenshop");
                    player.sendMessage("§8➥ §7Du willst wissen welche Ränge es gibt? §9/ranginfo");
                    player.sendMessage("§8");
                    player.sendMessage("§7§m--------------------§8[§9HILFE§8]§7§m--------------------");
                }
            }
        }

        return false;
    }
}
