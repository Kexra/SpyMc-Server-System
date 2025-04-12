package de.asna.spymccb.commands.coins;

import de.asna.spymccb.Main;
import de.asna.spymccb.mysql.coins.CoinPlayer;
import de.asna.spymccb.utils.formatting.FormattingUtil;
import net.bytemc.evelon.repository.Filter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (strings.length == 2) {
                Player target = Bukkit.getPlayer(strings[0]);
                int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
                int currentBankPlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBank();
                int currentBalanceTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getCoins();
                int currentBankTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getBank();
                int input = Integer.parseInt(strings[1]);
                if (input > 0) {
                    if (input < currentBalancePlayer) {
                        if (!(target.getName() == player.getName())) {
                            if (!(currentBalancePlayer >= 1000000000)) {
                                if (target != null) {
                                    Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer - input, currentBankPlayer, player.getName()));
                                    Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().update(new CoinPlayer(target.getUniqueId(), currentBalanceTarget + input, currentBankTarget, target.getName()));
                                    player.sendMessage(Main.PREFIX + "§7Du hast dem Spieler §9" + target.getName() + " §7einen Betrag von §9" + FormattingUtil.formatNumber(input) + "€ §7überwiesen.");
                                    target.sendMessage(Main.PREFIX + "§7Der Spieler §9" + player.getName() + " §7hat dir einen Betrag von §9" + FormattingUtil.formatNumber(input) + "€ §7überwiesen.");
                                } else {
                                    player.sendMessage(Main.NOONLINE);
                                }
                            } else {
                                player.sendMessage(Main.PREFIX + "§cDer Spieler hat bereits zuviel Geld!");
                            }
                        } else {
                            player.sendMessage(Main.PREFIX + "§cKannst dir selber nichts geben!");
                        }
                    } else {
                        player.sendMessage(Main.PREFIX + "§cDu hast zu wenig Geld!");
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§cDu kannst nicht weniger als 1€ überweisen!");
                }
            }
        }

        return false;
    }
}
