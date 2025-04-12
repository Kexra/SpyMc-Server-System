package de.asna.spymccb.mysql.jobs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.bytemc.evelon.repository.annotations.Entity;
import net.bytemc.evelon.repository.annotations.PrimaryKey;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Entity(name = "playerjobs")
public class JobPlayer {

    @PrimaryKey
    private UUID uuid;
    private String job;
    private String name;

}
