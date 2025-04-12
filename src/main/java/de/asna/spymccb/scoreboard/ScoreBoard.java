package de.asna.spymccb.scoreboard;

import de.asna.spymccb.Main;
import de.asna.spymccb.utils.formatting.FormattingUtil;
import de.asna.spymccb.utils.luckperms.LuckPermsUtil;
import fr.mrmicky.fastboard.FastBoard;
import net.bytemc.evelon.repository.Filter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreBoard {

    public static Map<Player, FastBoard> boardMap = new HashMap<>();



    public static void updateBoard(FastBoard board) {
        Player player = board.getPlayer();

        if (!player.isOnline()) {
            boardMap.remove(player);
            return;
        }

            int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
            String job = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();
            String finaljob = job.substring(0, 1).toUpperCase() + job.substring(1).toLowerCase();
            board.updateTitle("§x§0§0§8§c§f§f§lSPYMC");
            board.updateLines(
                    "",
                    "§9⚐ §8| §7Rang",
                    "§8➥ §9" + LuckPermsUtil.getMetaData(player).getPrefix().replaceAll("&", "§"),
                    "",
                    "§9⛏ §8| §7Job",
                    "§8➥ §9" + ((finaljob.equalsIgnoreCase("NONE")) ? "Arbeitslos" : (finaljob.equalsIgnoreCase("WOODCUTTER")) ? "Holzfäller" : (finaljob.equalsIgnoreCase("MINER")) ? "Miner" : (finaljob.equalsIgnoreCase("EXPLORER")) ? "Entdecker" : (finaljob.equalsIgnoreCase("HUNTER")) ? "Jäger" : finaljob),
                    "",
                    "§9ⓞ §8| §7Guthaben",
                    "§8➥ §9" + FormattingUtil.formatNumber(currentBalancePlayer) + "€",
                    "",
                    "§9❤ §8| §7Clan",
                    "§8➥ §9In Arbeit!",
                    ""
            );

    }



    public static void initRefresh() {
            Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), () -> boardMap.forEach((player, board) -> {
                updateBoard(board);
                player.setPlayerListName(LuckPermsUtil.getMetaData(player).getPrefix().replaceAll("&", "§") + " §8✘ §7" + player.getName());
            }), 0, 20);
    }

}
