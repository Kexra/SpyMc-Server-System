package de.asna.spymccb.commands.coins;

import de.asna.spymccb.Main;
import de.asna.spymccb.mysql.coins.CoinPlayer;
import de.asna.spymccb.utils.formatting.FormattingUtil;
import net.bytemc.evelon.repository.Filter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminCoinsCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("system.coins.admin")){
                ///admincoins set yourfavasna 1
                if (strings.length == 3){
                    if (strings[0].equalsIgnoreCase("SET")) {
                        Player target = Bukkit.getPlayer(strings[1]);
                        int currentBalanceTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getCoins();
                        int currentBankTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getBank();
                        int input = Integer.parseInt(strings[2]);
                        if (!(input <= 0)) {
                            if (!(input > 1000000000)) {
                                if (target != null) {
                                    Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().update(new CoinPlayer(target.getUniqueId(), input, currentBankTarget, target.getName()));
                                    player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7besitzt nun §9" + FormattingUtil.formatNumber(input) + "€");
                                } else {
                                    player.sendMessage(Main.NOONLINE);
                                }
                            } else {
                                player.sendMessage(Main.PREFIX + "§cDu kannst den Spieler nicht mehr als 1 Mrd geben!");
                            }
                        } else {
                            player.sendMessage(Main.PREFIX + "§cDu kannst keinem Spieler weniger als 0€ setzen!");
                        }
                    } else if (strings[0].equalsIgnoreCase("ADD")){
                        Player target = Bukkit.getPlayer(strings[1]);
                        int currentBalanceTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getCoins();
                        int currentBankTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getBank();
                        int input = Integer.parseInt(strings[2]);
                        if (!(currentBalanceTarget >= 1000000000)) {
                            if (!(input > 1000000000)) {
                                if (target != null) {
                                    Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().update(new CoinPlayer(target.getUniqueId(), currentBalanceTarget + input, currentBankTarget, target.getName()));
                                    player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7besitzt nun §9" + FormattingUtil.formatNumber((currentBalanceTarget + input)) + "€");
                                } else {
                                    player.sendMessage(Main.NOONLINE);
                                }
                            } else {
                                player.sendMessage(Main.PREFIX + "§cDu kannst den Spieler nicht mehr als 1 Mrd geben!");
                            }
                        }
                    } else if (strings[0].equalsIgnoreCase("REMOVE")){
                        Player target = Bukkit.getPlayer(strings[1]);
                        int currentBalanceTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getCoins();
                        int currentBankTarget = Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().findFirst().getBank();
                        int input = Integer.parseInt(strings[2]);
                        if (currentBalanceTarget > input) {
                            if (target != null) {
                                Main.getRepositorycoins().query().filter(Filter.match("uuid", target.getUniqueId())).database().update(new CoinPlayer(target.getUniqueId(), currentBalanceTarget - input, currentBankTarget, target.getName()));
                                player.sendMessage(Main.PREFIX + "§7Der Spieler §9" + target.getName() + " §7besitzt nun §9" + FormattingUtil.formatNumber((currentBalanceTarget - input)) + "€");
                            } else {
                                player.sendMessage(Main.NOONLINE);
                            }
                        } else {
                            player.sendMessage(Main.PREFIX + "§cDer Spieler hat zuwenig Geld dafür oder du kannst ihn nicht sein gesamtes Geld wegnehmen!");
                        }
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§7Benutze: §9/admincoins <set/add/remove> <spieler> <anzahl>");
                }
            } else {
                player.sendMessage(Main.NOPERM);
            }
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equals("admincoins")) {
            if (commandSender instanceof Player) {
                if (strings.length == 1) {
                    List<String> options = new ArrayList<>();
                    options.add("set");
                    options.add("add");
                    options.add("remove");
                    return options;
                } else if (strings.length == 2) {
                    List<String> playerNames = new ArrayList<>();
                    Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                    Bukkit.getServer().getOnlinePlayers().toArray(players);
                    for (int i = 0; i < players.length; i++) {
                        playerNames.add(players[i].getName());
                    }
                    return playerNames;
                } else if (strings.length == 3) {
                    return Collections.singletonList("<ANZAHL>");
                }
            }
        }
        return null;
    }
}
