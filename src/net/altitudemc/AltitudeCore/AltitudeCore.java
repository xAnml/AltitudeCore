package net.altitudemc.AltitudeCore;

import com.google.common.collect.Maps;
import net.altitudemc.AltitudeCore.database.DatabaseManager;
import net.altitudemc.AltitudeCore.player.AltitudePlayer;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.Map;
import java.util.UUID;

/*******************
 * Created by Anml *
 *******************/

public class AltitudeCore extends Plugin {

    private static AltitudeCore instance;
    private DatabaseManager databaseManager;
    private Map<UUID, AltitudePlayer> players = Maps.newConcurrentMap();

    @Override
    public void onEnable() {
        instance = this;
        databaseManager = new DatabaseManager("HOST", "PORT", "DATABASE", "USERNAME", "PASSWORD");
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static AltitudeCore getInstance() { return instance; }
    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public AltitudePlayer getPlayer(UUID uuid) {
        if (players.containsKey(uuid))
            return players.get(uuid);

        if (BungeeCord.getInstance().getPlayer(uuid) != null) {
            AltitudePlayer player = new AltitudePlayer(uuid);
            players.put(uuid, player);
            return player;
        } else {
            return new AltitudePlayer(uuid);
        }
    }

    public Map<UUID, AltitudePlayer> getPlayers() {
        return players;
    }
}
