package de.asna.spymccb;

import de.asna.spymccb.commands.*;
import de.asna.spymccb.commands.TphereCommand;
import de.asna.spymccb.commands.coins.AdminCoinsCommand;
import de.asna.spymccb.commands.coins.CoinsCommand;
import de.asna.spymccb.commands.coins.PayCommand;
import de.asna.spymccb.commands.jobs.JobCommand;
import de.asna.spymccb.commands.locations.SetSpawnCommand;
import de.asna.spymccb.commands.locations.SpawnCommand;
import de.asna.spymccb.events.AdvancementEvent;
import de.asna.spymccb.events.CommandBlockEvent;
import de.asna.spymccb.events.PlayerConnectionEvent;
import de.asna.spymccb.events.jobs.JobsCompletionEvent;
import de.asna.spymccb.events.jobs.JobsEvent;
import de.asna.spymccb.events.server.MotdEvent;
import de.asna.spymccb.mysql.clans.ClanPlayer;
import de.asna.spymccb.mysql.clans.ClansID;
import de.asna.spymccb.mysql.coins.CoinPlayer;
import de.asna.spymccb.mysql.coins.events.CoinConnectionEvent;
import de.asna.spymccb.mysql.jobs.JobPlayer;
import de.asna.spymccb.mysql.jobs.events.JobConnectionEvent;
import de.asna.spymccb.mysql.player.PlayerData;
import de.asna.spymccb.prefix.ChatPrefix;
import de.asna.spymccb.prefix.TabList;
import de.asna.spymccb.prefix.TabPrefix;
import de.asna.spymccb.scoreboard.ScoreBoard;
import de.asna.spymccb.utils.locations.LocationUtil;
import lombok.Getter;
import net.bytemc.evelon.DatabaseProtocol;
import net.bytemc.evelon.Evelon;
import net.bytemc.evelon.repository.Repository;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

public final class Main extends JavaPlugin {

    public static String PREFIX = "§x§0§0§8§c§f§f§lSYSTEM §8| ";
    public static String NOPERM = PREFIX + "§cDafür hast du keine Berechtigung!";
    public static String NOONLINE = PREFIX + "§cDieser Spieler ist nicht online!";
    @Getter
    static TabList tabList;
    @Getter
    static Main instance;
    @Getter
    static Repository<CoinPlayer> repositorycoins;
    @Getter
    static Repository<JobPlayer> repositoryjobs;
    @Getter
    static Repository<PlayerData> repositorylpayerdata;
    @Getter
    static Repository<ClansID> repositoryclans;
    @Getter
    static Repository<ClanPlayer> repositoryclanplayers;

    @Override
    public void onEnable() {
        //STANDARD
        instance = this;
        tabList = new TabList();
        ScoreBoard.initRefresh();
        LocationUtil.setup();
        //CONFIG
        if (!(new File(getDataFolder(), "config.yml")).exists())
            saveResource("config.yml", false);
        //MYSQL CONNECTION
        Evelon.setCradinates(DatabaseProtocol.MARIADB, getConfig().getString("hostname"), getConfig().getString("password"), getConfig().getString("username"), getConfig().getString("database"), getConfig().getInt("port"));
        Bukkit.getConsoleSender().sendMessage("§a✔ §8| §7Es wurde erfolgreich eine Verbindung zur Datenbank aufgebaut.");
        repositorycoins = Repository.create(CoinPlayer.class);
        repositoryjobs = Repository.create(JobPlayer.class);
        repositorylpayerdata = Repository.create(PlayerData.class);
        repositoryclans = Repository.create(ClansID.class);
        repositoryclanplayers = Repository.create(ClanPlayer.class);
        //EVENTS REGISTER
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatPrefix(), this);
        pm.registerEvents(new TabPrefix(), this);
        pm.registerEvents(new CoinConnectionEvent(), this);
        pm.registerEvents(new JobConnectionEvent(), this);
        pm.registerEvents(new PlayerConnectionEvent(), this);
        pm.registerEvents(new AdvancementEvent(), this);
        pm.registerEvents(new JobsEvent(), this);
        pm.registerEvents(new JobsCompletionEvent(), this);
        pm.registerEvents(new MotdEvent(), this);
        pm.registerEvents(new CommandBlockEvent(), this);
        //COMMANDS
        getCommand("coins").setExecutor(new CoinsCommand());
        getCommand("admincoins").setExecutor(new AdminCoinsCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("job").setExecutor(new JobCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("flyspeed").setExecutor(new FlySpeedCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("werkbank").setExecutor(new CraftCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("food").setExecutor(new FoodCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("repair").setExecutor(new RepairCommand());
        getCommand("tp").setExecutor(new TpCommand());
        getCommand("tphere").setExecutor(new TphereCommand());
        getCommand("tpa").setExecutor(new TPACommand());
        getCommand("msg").setExecutor(new MsgCommand());
        getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("skull").setExecutor(new SkullCommand());
        getCommand("msg").setExecutor(new MsgCommand());
        getCommand("hilfe").setExecutor(new HilfeCommand());
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("randomtp").setExecutor(new RandomTPCommand());
        getCommand("rename").setExecutor(new RenameCommand());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}

