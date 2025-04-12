package de.asna.spymccb.utils.luckperms;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class LuckPermsUtil {

    public static @NotNull CachedMetaData getMetaData(Player player) {
        return LuckPermsProvider.get().getPlayerAdapter(Player.class).getMetaData(player);

    }
}