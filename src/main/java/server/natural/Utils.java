package server.natural;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Utils {
    public static FileConfiguration config = Bukkit.getPluginManager().getPlugin("EndSpawnFix").getConfig();
    public static JavaPlugin plugin;
}
