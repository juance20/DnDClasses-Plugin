package org.dinastia.dndclasses;

import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class onPlayerConsumeEvent implements Listener {
    @EventHandler
    public void onPlayerConsumeEvent(PlayerItemConsumeEvent event){
        if(event.getItem().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(MainPlugin.getInstance(), "cerveza"), PersistentDataType.INTEGER)){
            YamlConfiguration config = MainPlugin.getConfigYaml();
            Player player = event.getPlayer();
            config.set(player.getName()+"_adicto", false);
            new BukkitRunnable(){
                @Override
                public void run() {
                    config.set(player.getName()+"_adicto", true);
                }
            }.runTaskLater(MainPlugin.getInstance(),24000);
        }
    }
}
