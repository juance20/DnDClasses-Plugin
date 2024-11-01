package org.dinastia.dndclasses;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainPlugin extends JavaPlugin implements CommandExecutor {

    private static MainPlugin plugin;

    public static MainPlugin getInstance() {
        return MainPlugin.plugin;
    }

    @Override
    public void onEnable() {
        MainPlugin.plugin = this;
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[" + ChatColor.BLUE + "DnDClasses" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Enabled");
        getCommand("setclass").setExecutor(new SetClassCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[" + ChatColor.BLUE + "DnDClasses" + ChatColor.GOLD + "] " + ChatColor.RED + "Disabled");
    }
}
