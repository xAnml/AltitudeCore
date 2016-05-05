package net.altitudemc.AltitudeCore.player;

import net.altitudemc.AltitudeCore.AltitudeCore;
import net.altitudemc.AltitudeCore.ranks.Rank;
import net.md_5.bungee.BungeeCord;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.UUID;

/*******************
 * Created by Anml *
 *******************/

public class AltitudePlayer {

    private UUID uuid;
    private Rank rank;
    private AltitudeCore instance;

    public AltitudePlayer(UUID uuid) {
        this.uuid = uuid;
        this.instance = AltitudeCore.getInstance();

        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UUID getUUID() {
        return uuid;
    }

    public void save() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("Rank", rank.name() == null ? Rank.MEMBER.name() : rank.name());

        instance.getDatabaseManager().set("PlayerInfo", data, "UUID", uuid.toString());
    }

    private void load() throws Exception {
        if (instance.getDatabaseManager().exists("PlayerInfo", "UUID", uuid.toString())) {
            ResultSet set = instance.getDatabaseManager().getResultSetByUUID("PlayerInfo", uuid.toString());
            this.rank = Rank.valueOf(set.getString("Rank"));
        } else {
            rank = Rank.MEMBER;
        }
    }

    public Rank getRank() {
        return this.rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getTag() {
        return getRank().getTag().replace("%s", BungeeCord.getInstance().getPlayerByOfflineUUID(uuid).getName());
    }
}
