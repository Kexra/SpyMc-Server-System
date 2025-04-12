package de.asna.spymccb.mysql.clans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.bytemc.evelon.repository.annotations.Entity;
import net.bytemc.evelon.repository.annotations.PrimaryKey;

@Getter
@AllArgsConstructor
@Entity(name = "clans")
public class ClansID {

    @PrimaryKey
    private int clanId;
    private String name;

}
