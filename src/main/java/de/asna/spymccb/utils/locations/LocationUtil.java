package de.asna.spymccb.utils.locations;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LocationUtil {
    public static File folder = new File("plugins//CityBuildSys//");

    public static File file = new File("plugins//CityBuildSys//locations.yml");

    public static void setup() {
        if (!folder.exists())
            folder.mkdirs();
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException var1) {
                var1.printStackTrace();
            }
    }

    public static void setLocation(Location location, String value) {
        try {
            cfg.set(value + ".world", location.getWorld().getName());
            cfg.set(value + ".x", Double.valueOf(location.getX()));
            cfg.set(value + ".y", Double.valueOf(location.getY()));
            cfg.set(value + ".z", Double.valueOf(location.getZ()));
            cfg.set(value + ".yaw", Float.valueOf(location.getYaw()));
            cfg.set(value + ".pitch", Float.valueOf(location.getPitch()));
            cfg.save(file);
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    public static Location getLocation(String value) {
        try {
            return new Location(Bukkit.getWorld(cfg.getString(value + ".world")), cfg.getDouble(value + ".x"), cfg.getDouble(value + ".y"), cfg.getDouble(value + ".z"), (float)cfg.getDouble(value + ".yaw"), (float)cfg.getDouble(value + ".pitch"));
        } catch (Exception var2) {
            throw new NullPointerException("Location nicht vorhanden");
        }
    }

    public static FileConfiguration cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
}
