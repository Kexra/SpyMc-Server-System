package de.asna.spymccb.gui;

import de.asna.spymccb.Main;
import de.asna.spymccb.mysql.coins.CoinPlayer;
import de.asna.spymccb.mysql.jobs.JobPlayer;
import net.bytemc.evelon.repository.Filter;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class JobGUI implements InventoryHolder {
    private final Inventory inventory;
    private final Player player;

    public JobGUI(Player player) {
        this.inventory = Bukkit.createInventory(this, 3 * 9, "§8| §9Job Menü §8✘ §x§0§0§8§c§f§f§lSPYMC");
        this.player = player;

        int i = 3 * 9;
        ItemStack i6 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta i6meta = i6.getItemMeta();
        i6meta.setDisplayName("§8");
        i6.setItemMeta(i6meta);
        for (int j = 0; j < i; j++) {
            inventory.setItem(j, i6);
        }

        ItemStack Holzfaeller = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta HolzfaellerMeta = Holzfaeller.getItemMeta();
        HolzfaellerMeta.setDisplayName("§7■ §8| §9Holzfäller §8| §7■");
        HolzfaellerMeta.setLore(Arrays.asList("§7Gehalt: §92€", "§7Gebühren: §950€"));
        Holzfaeller.setItemMeta(HolzfaellerMeta);

        ItemStack Miner = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta MinerMeta = Miner.getItemMeta();
        MinerMeta.setDisplayName("§7■ §8| §9Miner §8| §7■");
        MinerMeta.setLore(Arrays.asList("§7Gehalt: §93€", "§7Gebühren: §950€"));
        Miner.setItemMeta(MinerMeta);

        ItemStack Hunter = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta HunterMeta = Hunter.getItemMeta();
        HunterMeta.setDisplayName("§7■ §8| §9Jäger §8| §7■");
        HunterMeta.setLore(Arrays.asList("§7Gehalt: §92€", "§7Gebühren: §950€"));
        Hunter.setItemMeta(HunterMeta);

        ItemStack Explorer = new ItemStack(Material.SPYGLASS);
        ItemMeta ExplorerMeta = Explorer.getItemMeta();
        ExplorerMeta.setDisplayName("§7■ §8| §9Entdecker §8| §7■");
        ExplorerMeta.setLore(Arrays.asList("§7Gehalt: §95€", "§7Gebühren: §950€"));
        Explorer.setItemMeta(ExplorerMeta);

        ItemStack Arbeitslos = new ItemStack(Material.BARRIER);
        ItemMeta ArbeitslosMeta = Arbeitslos.getItemMeta();
        ArbeitslosMeta.setDisplayName("§7■ §8| §9Kündigen §8| §7■");
        Arbeitslos.setItemMeta(ArbeitslosMeta);

        inventory.setItem(10, Holzfaeller);
        inventory.setItem(12, Miner);
        inventory.setItem(14, Hunter);
        inventory.setItem(16, Explorer);
        inventory.setItem(22, Arbeitslos);

        ItemStack blueGlass = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta blueGlassMeta = blueGlass.getItemMeta();
        blueGlassMeta.setDisplayName("§7");
        blueGlass.setItemMeta(blueGlassMeta);

        inventory.setItem(0, blueGlass);
        inventory.setItem(1, blueGlass);
        inventory.setItem(7, blueGlass);
        inventory.setItem(8, blueGlass);
        inventory.setItem(9, blueGlass);
        inventory.setItem(17, blueGlass);
        inventory.setItem(18, blueGlass);
        inventory.setItem(19, blueGlass);
        inventory.setItem(25, blueGlass);
        inventory.setItem(26, blueGlass);

        player.openInventory(inventory);
    }

    public void onClick(ItemStack item, int slot) {
        switch (slot) {
            case 10: {
                int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
                int currentBankPlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBank();
                String currentJob = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();
                if (currentBalancePlayer >= 50) {
                    if (!currentJob.equals("WOODCUTTER")) {
                        Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer - 50, currentBankPlayer, player.getName()));
                        Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new JobPlayer(player.getUniqueId(), "WOODCUTTER", player.getName()));
                        player.sendMessage(Main.PREFIX + "§7Du hast erfolgreich den Job §9Holzfäller §7angenommen.");
                    } else {
                        player.sendMessage(Main.PREFIX + "§cDu bist bereits ein Holzfäller.");
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§cDu besitzt nicht genügend Geld.");
                }
                break;
            }
            case 12: {
                int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
                int currentBankPlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBank();
                String currentJob = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();
                if (currentBalancePlayer >= 50) {
                    if (!currentJob.equals("MINER")) {
                        Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer - 50, currentBankPlayer, player.getName()));
                        Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new JobPlayer(player.getUniqueId(), "MINER", player.getName()));
                        player.sendMessage(Main.PREFIX + "§7Du hast erfolgreich den Job §9Miner §7angenommen.");
                    } else {
                        player.sendMessage(Main.PREFIX + "§cDu bist bereits ein Miner.");
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§cDu besitzt nicht genügend Geld.");
                }
                break;
            }
            case 14: {
                int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
                int currentBankPlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBank();
                String currentJob = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();
                if (currentBalancePlayer >= 50) {
                    if (!currentJob.equals("HUNTER")) {
                        Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer - 50, currentBankPlayer, player.getName()));
                        Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new JobPlayer(player.getUniqueId(), "HUNTER", player.getName()));
                        player.sendMessage(Main.PREFIX + "§7Du hast erfolgreich den Job §9Jäger §7angenommen.");
                    } else {
                        player.sendMessage(Main.PREFIX + "§cDu bist bereits ein Jäger.");
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§cDu besitzt nicht genügend Geld.");
                }
                break;
            }
            case 16: {
                int currentBalancePlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getCoins();
                int currentBankPlayer = Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getBank();
                String currentJob = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();
                if (currentBalancePlayer >= 50) {
                    if (!currentJob.equals("EXPLORER")) {
                        Main.getRepositorycoins().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new CoinPlayer(player.getUniqueId(), currentBalancePlayer - 50, currentBankPlayer, player.getName()));
                        Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new JobPlayer(player.getUniqueId(), "EXPLORER", player.getName()));
                        player.sendMessage(Main.PREFIX + "§7Du hast erfolgreich den Job §9Entdecker §7angenommen.");
                    } else {
                        player.sendMessage(Main.PREFIX + "§cDu bist bereits ein Entdecker.");
                    }
                } else {
                    player.sendMessage(Main.PREFIX + "§cDu besitzt nicht genügend Geld.");
                }
                break;
            }
            case 22: {
                String currentJob = Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().findFirst().getJob();
                if (!currentJob.equals("NONE")) {
                    Main.getRepositoryjobs().query().filter(Filter.match("uuid", player.getUniqueId())).database().update(new JobPlayer(player.getUniqueId(), "NONE", player.getName()));
                    player.sendMessage(Main.PREFIX + "§7Du bist nun Arbeitslos.");
                } else {
                    player.sendMessage(Main.PREFIX + "§cDu bist bereits Arbeitslos.");
                }
                break;
            }
        }
    }


    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
