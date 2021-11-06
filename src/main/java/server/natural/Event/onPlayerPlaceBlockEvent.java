package server.natural.Event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import server.natural.Utils;

public class onPlayerPlaceBlockEvent implements Listener {
    @EventHandler
    public void onPlayerPlaceBlockEvent(BlockPlaceEvent e){

        if(e.getPlayer().getWorld().getEnvironment() == World.Environment.THE_END && (e.getBlockPlaced().getType() == Material.RED_MUSHROOM || e.getBlockPlaced().getType() == Material.BROWN_MUSHROOM)){

            e.setCancelled(true);
            e.getPlayer().sendMessage(Utils.config.getString("kickmessage"));
            Bukkit.broadcastMessage(ChatColor.GRAY + e.getPlayer().getDisplayName() + ChatColor.RED + "尝试在末地放置蘑菇卡服");
            e.getPlayer().saveData(); //防止某些玩家恶意刷物品
            e.getPlayer().kickPlayer(Utils.config.getString("kickmessage"));

        }

    }



}
