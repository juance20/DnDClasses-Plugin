package org.dinastia.dndclasses;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class onEntityDamageEvent implements Listener {
    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event){
        if(!(event.getEntity() instanceof Player)) return;
        if(event.getCause() != EntityDamageEvent.DamageCause.FALL) return;
        Player player = (Player) event.getEntity();
        YamlConfiguration config = MainPlugin.getConfigYaml();
        if(config.get(player.getName()+"_class").equals("clerigo")){
            event.setDamage(event.getDamage()*0.5);

        }
    }
}
