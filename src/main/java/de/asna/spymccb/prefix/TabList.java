package de.asna.spymccb.prefix;

import de.asna.spymccb.utils.luckperms.LuckPermsUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TabList {

    public void setPlayerList(Player player) {
        player.setPlayerListHeaderFooter(" \n§9§o■ §8┃ §x§0§0§8§c§f§f§lSPYMC §8● §7CityBuild §8┃ §9§o■\n \n §7Online §8§l» §9" + Bukkit.getOnlinePlayers().size() + "§8/§9" + Bukkit.getMaxPlayers() + "\n ", " \n§7Discord §8§l» §9/discord\n \n §7§oDein §9§oNext§7§o-§9§oGen §7§oCityBuild!\n ");
    }

    public void setAllPlayerTeam() {
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeam);
    }

    public void setPlayerTeam(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        Team spieler = scoreboard.getTeam("022spieler");
        if (spieler == null) {
            spieler = scoreboard.registerNewTeam("022spieler");
        }
        Team premium = scoreboard.getTeam("021premium");
        if (premium == null) {
            premium = scoreboard.registerNewTeam("021premium");
        }
        Team elite = scoreboard.getTeam("020elite");
        if (elite == null) {
            elite = scoreboard.registerNewTeam("020elite");
        }
        Team apex = scoreboard.getTeam("019apex");
        if (apex == null) {
            apex = scoreboard.registerNewTeam("019apex");
        }
        Team future = scoreboard.getTeam("018future");
        if (future == null) {
            future = scoreboard.registerNewTeam("018future");
        }
        Team vip = scoreboard.getTeam("017vip");
        if (vip == null) {
            vip = scoreboard.registerNewTeam("017vip");
        }
        Team vip2 = scoreboard.getTeam("016vip2");
        if (vip2 == null) {
            vip2 = scoreboard.registerNewTeam("016vip2");
        }
        Team freund = scoreboard.getTeam("015freund");
        if (freund == null) {
            freund = scoreboard.registerNewTeam("015freund");
        }
        Team creator = scoreboard.getTeam("014creator");
        if (creator == null) {
            creator = scoreboard.registerNewTeam("014creator");
        }
        Team content = scoreboard.getTeam("013content");
        if (content == null) {
            content = scoreboard.registerNewTeam("013content");
        }
        Team builder = scoreboard.getTeam("012builder");
        if (builder == null) {
            builder = scoreboard.registerNewTeam("012builder");
        }
        Team builder2 = scoreboard.getTeam("011builder2");
        if (builder2 == null) {
            builder2 = scoreboard.registerNewTeam("011builder2");
        }
        Team tsupporter = scoreboard.getTeam("010tsupporter");
        if (tsupporter == null) {
            tsupporter = scoreboard.registerNewTeam("010tsupporter");
        }
        Team supporter = scoreboard.getTeam("009supporter");
        if (supporter == null) {
            supporter = scoreboard.registerNewTeam("009supporter");
        }
        Team supporter2 = scoreboard.getTeam("008supporter2");
        if (supporter2 == null) {
            supporter2 = scoreboard.registerNewTeam("008supporter2");
        }
        Team moderator = scoreboard.getTeam("007moderator");
        if (moderator == null) {
            moderator = scoreboard.registerNewTeam("007moderator");
        }
        Team moderator2 = scoreboard.getTeam("006moderator2");
        if (moderator2 == null) {
            moderator2 = scoreboard.registerNewTeam("006moderator2");
        }
        Team admin = scoreboard.getTeam("005admin");
        if (admin == null) {
            admin = scoreboard.registerNewTeam("005admin");
        }
        Team developer = scoreboard.getTeam("004developer");
        if (developer == null) {
            developer = scoreboard.registerNewTeam("004developer");
        }
        Team developer2 = scoreboard.getTeam("003developer2");
        if (developer2 == null) {
            developer2 = scoreboard.registerNewTeam("003developer2");
        }
        Team leitung = scoreboard.getTeam("002leitung");
        if (leitung == null) {
            leitung = scoreboard.registerNewTeam("002leitung");
        }
        Team owner = scoreboard.getTeam("001owner");
        if (owner == null) {
            owner = scoreboard.registerNewTeam("001owner");
        }
        spieler.setPrefix("§x§f§f§f§f§f§fꜱ§x§e§d§e§d§e§dᴘ§x§d§b§d§b§d§bɪ§x§c§a§c§a§c§aᴇ§x§b§8§b§8§b§8ʟ§x§a§6§a§6§a§6ᴇ§x§9§4§9§4§9§4ʀ §8✘ ");
        spieler.setColor(ChatColor.GRAY);
        premium.setPrefix("§x§f§f§b§f§0§0ᴘ§x§f§f§c§7§0§0ʀ§x§f§f§c§e§0§0ᴇ§x§f§f§d§6§0§0ᴍ§x§f§f§d§e§0§0ɪ§x§f§f§e§5§0§0ᴜ§x§f§f§e§d§0§0ᴍ §8✘ ");
        premium.setColor(ChatColor.GRAY);
        elite.setPrefix("§x§0§0§f§f§d§9ᴇ§x§0§0§f§f§c§6ʟ§x§0§0§f§f§b§3ɪ§x§0§0§f§f§9§fᴛ§x§0§0§f§f§8§cᴇ §8✘ ");
        elite.setColor(ChatColor.GRAY);
        apex.setPrefix("§x§0§0§7§d§f§fᴀ§x§2§d§5§3§f§fᴘ§x§5§a§2§a§f§fᴇ§x§8§7§0§0§f§fx §8✘ ");
        apex.setColor(ChatColor.GRAY);
        future.setPrefix("§x§f§2§f§f§0§0ꜰ§x§c§2§f§a§3§3ᴜ§x§9§1§f§6§6§6ᴛ§x§6§1§f§1§9§9ᴜ§x§3§0§e§d§c§cʀ§x§0§0§e§8§f§fᴇ §8✘ ");
        future.setColor(ChatColor.GRAY);
        vip.setPrefix("§x§f§f§d§e§0§0ᴠ§x§d§a§6§f§8§0ɪ§x§b§5§0§0§f§fᴘ §8✘ ");
        vip.setColor(ChatColor.GRAY);
        vip2.setPrefix("§x§f§f§d§e§0§0ᴠ§x§e§6§9§4§5§5ɪ§x§c§e§4§a§a§aᴘ§x§b§5§0§0§f§f+ §8✘ ");
        vip2.setColor(ChatColor.GRAY);
        freund.setPrefix("§x§0§0§f§f§7§dꜰ§x§0§0§f§d§9§7ʀ§x§0§0§f§c§b§1ᴇ§x§0§0§f§a§c§bᴜ§x§0§0§f§9§e§5ɴ§x§0§0§f§7§f§fᴅ §8✘ ");
        freund.setColor(ChatColor.GRAY);
        creator.setPrefix("§x§f§f§0§0§e§dᴄ§x§e§6§0§0§f§0ʀ§x§c§d§0§0§f§3ᴇ§x§b§4§0§0§f§6ᴀ§x§9§b§0§0§f§9ᴛ§x§8§2§0§0§f§cᴏ§x§6§9§0§0§f§fʀ §8✘ ");
        creator.setColor(ChatColor.GRAY);
        content.setPrefix("§x§f§f§f§c§0§0ᴄ§x§d§5§f§d§1§7ᴏ§x§a§a§f§d§2§fɴ§x§8§0§f§e§4§6ᴛ§x§5§5§f§e§5§dᴇ§x§2§b§f§f§7§5ɴ§x§0§0§f§f§8§cᴛ §8✘ ");
        content.setColor(ChatColor.GRAY);
        builder.setPrefix("§x§9§6§f§f§0§0ʙ§x§9§0§f§2§0§0ᴜ§x§8§9§e§4§0§0ɪ§x§8§3§d§7§0§0ʟ§x§7§c§c§9§0§0ᴅ§x§7§6§b§c§0§0ᴇ§x§6§f§a§e§0§0ʀ §8✘ ");
        builder.setColor(ChatColor.GRAY);
        builder2.setPrefix("§x§9§6§f§f§0§0ʙ§x§9§0§f§2§0§0ᴜ§x§8§9§e§4§0§0ɪ§x§8§3§d§7§0§0ʟ§x§7§c§c§9§0§0ᴅ§x§7§6§b§c§0§0ᴇ§x§6§f§a§e§0§0ʀ§x§6§9§a§1§0§0+ §8✘ ");
        builder2.setColor(ChatColor.GRAY);
        tsupporter.setPrefix("§x§f§f§b§0§0§0ᴛ§x§f§d§b§b§0§0ᴇ§x§f§b§c§7§0§0ꜱ§x§f§9§d§2§0§0ᴛ§x§f§8§d§d§0§0-§x§f§6§e§8§0§0ꜱ§x§f§4§f§4§0§0ᴜ§x§f§2§f§f§0§0ᴘ §8✘ ");
        tsupporter.setColor(ChatColor.GRAY);
        supporter.setPrefix("§x§f§f§a§1§0§0ѕ§x§f§f§a§8§0§0ᴜ§x§f§f§b§0§0§0ᴘ§x§f§e§b§7§0§0ᴘ§x§f§e§b§f§0§0ᴏ§x§f§e§c§6§0§0ʀ§x§f§e§c§d§0§0ᴛ§x§f§d§d§5§0§0ᴇ§x§f§d§d§c§0§0ʀ §8✘ ");
        supporter.setColor(ChatColor.GRAY);
        supporter2.setPrefix("§x§f§f§a§1§0§0ѕ§x§f§f§a§8§0§0ᴜ§x§f§f§a§e§0§0ᴘ§x§f§e§b§5§0§0ᴘ§x§f§e§b§b§0§0ᴏ§x§f§e§c§2§0§0ʀ§x§f§e§c§8§0§0ᴛ§x§f§d§c§f§0§0ᴇ§x§f§d§d§5§0§0ʀ§x§f§d§d§c§0§0+ §8✘ ");
        supporter2.setColor(ChatColor.GRAY);
        moderator.setPrefix("§x§f§f§0§0§0§0ᴍ§x§f§f§0§e§0§0ᴏ§x§f§f§1§d§0§0ᴅ§x§f§e§2§b§0§0ᴇ§x§f§e§3§9§0§0ʀ§x§f§e§4§7§0§0ᴀ§x§f§e§5§6§0§0ᴛ§x§f§d§6§4§0§0ᴏ§x§f§d§7§2§0§0ʀ §8✘ ");
        moderator.setColor(ChatColor.GRAY);
        moderator2.setPrefix("§x§f§f§0§0§0§0ᴍ§x§f§f§0§d§0§0ᴏ§x§f§f§1§9§0§0ᴅ§x§f§e§2§6§0§0ᴇ§x§f§e§3§3§0§0ʀ§x§f§e§3§f§0§0ᴀ§x§f§e§4§c§0§0ᴛ§x§f§d§5§9§0§0ᴏ§x§f§d§6§5§0§0ʀ§x§f§d§7§2§0§0+ §8✘ ");
        moderator2.setColor(ChatColor.GRAY);
        admin.setPrefix("§x§f§f§1§e§1§eᴀ§x§f§f§3§9§3§9ᴅ§x§f§e§5§5§5§5ᴍ§x§f§e§7§0§7§0ɪ§x§f§d§8§b§8§bɴ §8✘ ");
        admin.setColor(ChatColor.GRAY);
        developer.setPrefix("§x§0§0§7§d§f§fᴅ§x§0§0§8§a§f§fᴇ§x§0§0§9§7§f§fᴠ§x§0§0§a§4§f§eᴇ§x§0§0§b§2§f§eʟ§x§0§0§b§f§f§eᴏ§x§0§0§c§c§f§eᴘ§x§0§0§d§9§f§dᴇ§x§0§0§e§6§f§dʀ §8✘ ");
        developer.setColor(ChatColor.GRAY);
        developer2.setPrefix("§x§0§0§f§f§b§aѕ§x§0§0§f§d§c§1ʀ §x§0§0§f§a§c§7ᴅ§x§0§0§f§8§c§eᴇ§x§0§0§f§5§d§5ᴠ§x§0§0§f§3§d§cᴇ§x§0§0§f§0§e§2ʟ§x§0§0§e§e§e§9ᴏ§x§0§0§e§b§f§0ᴘ§x§0§0§e§9§f§6ᴇ§x§0§0§e§6§f§dʀ §8✘ ");
        developer2.setColor(ChatColor.GRAY);
        leitung.setPrefix("§x§7§e§0§0§0§0ʟ§x§9§3§0§0§0§0ᴇ§x§a§8§0§0§0§0ɪ§x§b§e§0§0§0§0ᴛ§x§d§3§0§0§0§0ᴜ§x§e§8§0§0§0§0ɴ§x§f§d§0§0§0§0ɢ §8✘ ");
        leitung.setColor(ChatColor.GRAY);
        owner.setPrefix("§x§f§b§0§0§0§0§lᴏ§x§d§c§0§0§0§0§lᴡ§x§b§c§0§0§0§0§lɴ§x§9§d§0§0§0§0§lᴇ§x§7§d§0§0§0§0§lʀ §8✘ ");
        owner.setColor(ChatColor.GRAY);
        if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("owner")){
            owner.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("leitung")){
            leitung.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("sr-developer")) {
            developer2.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("developer")) {
            developer.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("admin")) {
            admin.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("moderator+")) {
            moderator2.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("moderator")) {
            moderator.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("supporter+")) {
            supporter2.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("supporter")) {
            supporter.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("test-sup")) {
            tsupporter.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("builder+")) {
            builder2.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("builder")) {
            builder.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("content")) {
            content.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("creator")) {
            creator.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("freund")) {
            freund.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("vip+")) {
            vip2.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("vip")) {
            vip.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("future")) {
            future.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("apex")) {
            apex.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("elite")) {
            elite.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("premium")) {
            premium.addEntry(player.getName());
        } else if (LuckPermsUtil.getMetaData(player).getPrimaryGroup().equals("sr-developer")) {
            developer2.addEntry(player.getName());
        } else {
            spieler.addEntry(player.getName());
        }


    }

}
