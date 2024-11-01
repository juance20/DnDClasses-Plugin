package org.dinastia.dndclasses;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import java.util.Objects;

public class onEntityTargetLivingEntityEvent implements Listener {

    @EventHandler
    public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event){
        if(!(event.getTarget() instanceof Player) || event.getReason() != EntityTargetEvent.TargetReason.CLOSEST_PLAYER)  return;
        Player player = (Player) event.getTarget();
        YamlConfiguration config = MainPlugin.getConfigYaml();
        if(Objects.equals((String) config.get(player.getName() + "_class"), "bardo")){
            event.setCancelled(true);
        }

    }
}
