package server.natural;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import server.natural.Event.onPlayerPlaceBlockEvent;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new onPlayerPlaceBlockEvent() , this);
        Utils.plugin = this;
    }

    @Override
    public void onDisable() {
        saveConfig();


    }
}
