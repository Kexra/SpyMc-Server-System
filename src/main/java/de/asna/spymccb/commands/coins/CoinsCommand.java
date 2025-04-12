package de.asna.spymccb.commands.coins;

import de.asna.spymccb.Main;
import de.asna.spymccb.utils.formatting.FormattingUtil;
import net.bytemc.evelon.repository.Filter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CoinsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                int currentCoinsBalance = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
                player.sendMessage(Main.PREFIX + "§7Du hast §9" + FormattingUtil.formatNumber(currentCoinsBalance) + "€");
            } else if (strings.length == 1) { // /coins <name>
                Player target = Bukkit.getPlayer(strings[0]);
                int currentCoinsBalanceTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getCoins();
                if (target != null) {
                    player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7besitzt §9" + FormattingUtil.formatNumber(currentCoinsBalanceTarget) + "€");
                } else {
                    player.sendMessage(Main.NOONLINE);
                }
            } else {
                player.sendMessage(Main.PREFIX + "§7Benutze: §9/coins <spieler>");
            }
        }

        return false;
    }
}
