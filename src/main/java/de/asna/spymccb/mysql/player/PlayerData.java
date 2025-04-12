package de.asna.spymccb.mysql.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.bytemc.evelon.repository.annotations.Entity;
import net.bytemc.evelon.repository.annotations.PrimaryKey;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Entity(name = "playerdata")
public class PlayerData {

    @PrimaryKey
    private UUID uuid;
    private int blockswalked;
    private String name;



}
