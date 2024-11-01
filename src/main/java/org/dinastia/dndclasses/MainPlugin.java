package org.dinastia.dndclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

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
}
