package de.asna.spymccb.mysql.clans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.bytemc.evelon.repository.annotations.Entity;
import net.bytemc.evelon.repository.annotations.PrimaryKey;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Entity(name = "clanplayers")
public class ClanPlayer {

    @PrimaryKey
    private UUID uuid;
    private String name;
    private int clanId;
    private int clanRankId;

}
