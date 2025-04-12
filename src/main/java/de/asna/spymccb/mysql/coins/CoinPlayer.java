package de.asna.spymccb.mysql.coins;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.bytemc.evelon.repository.annotations.Entity;
import net.bytemc.evelon.repository.annotations.PrimaryKey;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Entity(name = "playercoins")
public class CoinPlayer {

    @PrimaryKey
    private UUID uuid;
    private int coins;
    private int bank;
    private String name;

}