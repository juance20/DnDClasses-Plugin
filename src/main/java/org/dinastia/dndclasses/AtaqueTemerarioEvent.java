package org.dinastia.dndclasses;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AtaqueTemerarioEvent implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event){
        if(!event.hasItem()) return;
        if(event.getAction() != Action.RIGHT_CLICK_AIR) return;

        Player player = event.getPlayer();
        List<Material> items = Arrays.asList(Material.DIAMOND_AXE, Material.IRON_AXE, Material.STONE_AXE, Material.WOODEN_AXE, Material.GOLDEN_AXE, Material.NETHERITE_AXE, Material.DIAMOND_SWORD, Material.IRON_SWORD, Material.STONE_SWORD, Material.WOODEN_SWORD, Material.GOLDEN_SWORD, Material.NETHERITE_SWORD);
        YamlConfiguration config = MainPlugin.getConfigYaml();
        if(!(items.contains(event.getItem().getType()))) return;

        if(config.get(player.getName()+"_class").equals("barbaro")){
            if(config.getBoolean(player.getName()+"_ataque_temerario_deshabilitado")) return;
            config.set(player.getName()+"_desactivar_pasivas", true);
            config.set(player.getName()+"_ataque_temerario_desactivado", true);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 1, false,false,false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 1, false,false,false));

            new BukkitRunnable(){

                @Override
                public void run() {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 1, false,false,false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 2, false,false,false));
                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            config.set(player.getName()+"_desactivar_pasivas", false);
                            config.set(player.getName()+"_ataque_temerario_desactivado", false);
                        }
                    }.runTaskLater(MainPlugin.getInstance(),600);
                }
            }.runTaskLater(MainPlugin.getInstance(), 1200);
        }

    }
}
