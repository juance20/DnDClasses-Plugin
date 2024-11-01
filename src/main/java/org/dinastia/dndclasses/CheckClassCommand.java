package org.dinastia.dndclasses;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CheckClassCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) return false;

        String clase;
        YamlConfiguration config = MainPlugin.getConfigYaml();
        clase = (String) config.get(sender.getName()+"_class");
        if(clase == null){ clase = "no asignada"; }
        sender.sendMessage(ChatColor.GOLD + "Clase de "+sender.getName()+": " + ChatColor.GREEN + clase);
        return false;
    }
}
