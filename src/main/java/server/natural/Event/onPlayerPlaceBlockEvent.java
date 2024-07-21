package server.natural.Event;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import server.natural.Utils;

import java.util.Objects;
import java.util.function.Consumer;

public class onPlayerPlaceBlockEvent implements Listener {
    ScheduledTask task;
    public void stop(){
        task.cancel();
    }
    @EventHandler
    public void onPlayerPlaceBlockEvent(BlockPlaceEvent e){

        if(e.getPlayer().getWorld().getEnvironment() == World.Environment.THE_END && (e.getBlockPlaced().getType() == Material.RED_MUSHROOM || e.getBlockPlaced().getType() == Material.BROWN_MUSHROOM)){

            task = Bukkit.getRegionScheduler().run(Utils.plugin, e.getPlayer().getLocation(), new Consumer<ScheduledTask>() {
                @Override
                public void accept(ScheduledTask scheduledTask) {
                    e.setCancelled(true);
                }
            });
            e.getPlayer().sendMessage(Objects.requireNonNull(Utils.config.getString("kickmessage")));
            e.getPlayer().saveData(); //防止某些玩家恶意刷物品

        }

    }



}
