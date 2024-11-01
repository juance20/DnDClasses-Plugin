package org.dinastia.dndclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

public final class MainPlugin extends JavaPlugin implements CommandExecutor {

    private static MainPlugin plugin;
    private static YamlConfiguration config;

    public static MainPlugin getInstance() {
        return MainPlugin.plugin;
    }
    public static YamlConfiguration getConfigYaml() {return MainPlugin.config;}

    @Override
    public void onEnable() {
        MainPlugin.config = new YamlConfiguration();
        try {
            MainPlugin.config.load(new File("config.yaml"));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        MainPlugin.plugin = this;
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[" + ChatColor.BLUE + "DnDClasses" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Enabled");
        getCommand("setclass").setExecutor(new SetClassCommand());
        getCommand("checkclass").setExecutor(new CheckClassCommand());
        Bukkit.getPluginManager().registerEvents(new onEntityTargetLivingEntityEvent(), this);


        new BukkitRunnable(){

            @Override
            public void run() {
                checkPasives();
            }
        }.runTaskTimer(MainPlugin.getInstance(), 10, 100);

    }

    @Override
    public void onDisable() {
        try {
            MainPlugin.config.save("config.yaml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[" + ChatColor.BLUE + "DnDClasses" + ChatColor.GOLD + "] " + ChatColor.RED + "Disabled");
    }

    public void checkPasives(){
        YamlConfiguration config = MainPlugin.getConfigYaml();
        for(Player player : Bukkit.getOnlinePlayers()) {
            String clase = (String) config.get(player.getName()+"_class");
            if(clase == null) return;
            switch(clase){
                case "barbaro":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 140, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 140, 0));
                    break;
                case "bardo":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 140, 0));
                    break;
                case "clerigo":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 140, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 140, 0));
                    break;
                case "picaro":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 140, 0));
                    player.setMaxHealth(10);
                    break;
                case "mago":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0));
                    break;
            }
        }
    }

}
