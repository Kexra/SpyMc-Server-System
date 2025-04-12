package de.asna.spymccb.commands;

import de.asna.spymccb.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MsgCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player opfer = Bukkit.getPlayer(strings[0]);
        if (commandSender instanceof Player player) {
            if (!player.getName().equals(strings[0])) {
                if (strings.length >= 2) {
                    if (opfer != null) {
                        String msg = "";
                        for (int i = 1; i < strings.length; i++)
                            msg = msg + strings[i] + " ";
                        player.sendMessage(Main.PREFIX + "§9Ich §8→ §9" + opfer.getName() + " §8→ §7" + msg);
                        opfer.sendMessage(Main.PREFIX + "§9" + player.getName() + " §8→ §9Mir §8→ §7" + msg);
                    } else {
                        player.sendMessage(Main.NOONLINE);
                    }
                }

            } else {
                player.sendMessage(Main.PREFIX + "§cDu kannst dir selber keine MSG schicken.");
            }
        }
        return false;
    }
}
