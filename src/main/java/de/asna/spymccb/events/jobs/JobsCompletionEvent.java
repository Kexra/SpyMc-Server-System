package de.asna.spymccb.events.jobs;

import de.asna.spymccb.Main;
import de.asna.spymccb.mysql.coins.CoinPlayer;
import de.asna.spymccb.mysql.player.PlayerData;
import net.bytemc.evelon.repository.Filter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JobsCompletionEvent implements Listener {

    @EventHandler
    public void onBuildJobs(BlockBreakEvent event) {
        Player player = event.getPlayer();
        int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
        int currentBankPlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBank();
        String currentJob = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();

        //WOODCUTTER STUFF
        List<Material> woodcutter = new ArrayList<>();
        woodcutter.add(Material.SPRUCE_LOG);
        woodcutter.add(Material.OAK_LOG);
        woodcutter.add(Material.BIRCH_LOG);
        woodcutter.add(Material.ACACIA_LOG);
        woodcutter.add(Material.DARK_OAK_LOG);
        woodcutter.add(Material.MANGROVE_LOG);
        woodcutter.add(Material.JUNGLE_LOG);

        //MINER STUFF
        List<Material> miner = new ArrayList<>();
        miner.add(Material.COAL_ORE);
        miner.add(Material.IRON_ORE);
        miner.add(Material.GOLD_ORE);
        miner.add(Material.DIAMOND_ORE);
        miner.add(Material.REDSTONE_ORE);
        miner.add(Material.COPPER_ORE);
        miner.add(Material.LAPIS_ORE);
        miner.add(Material.DEEPSLATE_COAL_ORE);
        miner.add(Material.DEEPSLATE_IRON_ORE);
        miner.add(Material.DEEPSLATE_GOLD_ORE);
        miner.add(Material.DEEPSLATE_DIAMOND_ORE);
        miner.add(Material.DEEPSLATE_REDSTONE_ORE);
        miner.add(Material.DEEPSLATE_COPPER_ORE);
        miner.add(Material.DEEPSLATE_LAPIS_ORE);

        if (event.getBlock().getLocation().getWorld().getName().equalsIgnoreCase("FARMWELT")) {
            if (player != null) {
                switch (currentJob) {
                    case "WOODCUTTER" -> {
                        if (woodcutter.contains(event.getBlock().getType())) {
                            Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer + 2, currentBankPlayer, player.getName()));
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7+§92€"));
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0F, 1.0F);
                        }
                    }
                    case "MINER" -> {
                        if (miner.contains(event.getBlock().getType())) {
                            Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer + 3, currentBankPlayer, player.getName()));
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7+§93€"));
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0F, 1.0F);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onKillJob(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        //JÄGER STUFF
        List<EntityType> hunter = new ArrayList<>();
        hunter.add(EntityType.ZOMBIE);
        hunter.add(EntityType.CREEPER);
        hunter.add(EntityType.SKELETON);
        hunter.add(EntityType.ENDERMAN);
        hunter.add(EntityType.SLIME);
        hunter.add(EntityType.PIG);
        hunter.add(EntityType.COW);
        hunter.add(EntityType.SHEEP);
        hunter.add(EntityType.CHICKEN);

        if (event.getEntity().getWorld().getName().equalsIgnoreCase("FARMWELT")) {
            if (player != null) {
                int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
                int currentBankPlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBank();
                String currentJob = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();
                switch (currentJob) {
                    case "HUNTER" -> {
                        if (hunter.contains(event.getEntity().getType())) {
                            Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer + 2, currentBankPlayer, player.getName()));
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7+§92€"));
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0F, 1.0F);
                        }
                    }
                }
            } else {
                Bukkit.getConsoleSender().sendMessage("");
            }
        }

    }


    @EventHandler
    public void OnWalkingJob(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
        int currentBankPlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBank();
        String currentJob = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();
        int blocksWalkedBeforeReward = Main.getRepositorylpayerdata().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBlockswalked();
        int blocksNeededForReward = 500;
        if (player != null) {
            if (currentJob.equals("EXPLORER")) {
                if (player.getWorld().getName().equalsIgnoreCase("FARMWELT")) {
                    int distance = (int) event.getFrom().getBlock().getLocation().distance(event.getTo().getBlock().getLocation());
                    if (distance >= 0) {
                        Main.getRepositorylpayerdata().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new PlayerData(player.getUniqueId(), blocksWalkedBeforeReward + distance, player.getName()));
                        if (blocksWalkedBeforeReward >= blocksNeededForReward) {
                            Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer + 5, currentBankPlayer, player.getName()));
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7+§95€"));
                            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2.0F, 1.0F);
                            Main.getRepositorylpayerdata().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new PlayerData(player.getUniqueId(), 0, player.getName()));
                        }
                    }
                }
            }
        }
    }

}
