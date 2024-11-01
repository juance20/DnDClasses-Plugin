package org.dinastia.dndclasses;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetClassCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args){
        if(!(sender instanceof Player)) return false;
        if(args.length != 1) return false;

        YamlConfiguration config = MainPlugin.getConfigYaml();

        switch(args[0]){
            case "barbaro":
                config.set(sender.getName() + "_class", "barbaro");
                sender.sendMessage(ChatColor.GOLD + "Clase establecida: " + ChatColor.GREEN + "barbaro");
                break;
            case "bardo":
                config.set(sender.getName() + "_class", "bardo");
                sender.sendMessage(ChatColor.GOLD + "Clase establecida: " + ChatColor.GREEN + "bardo");
                break;
            case "clerigo":
                config.set(sender.getName() + "_class", "clerigo");
                sender.sendMessage(ChatColor.GOLD + "Clase establecida: " + ChatColor.GREEN + "clerigo");
                break;
            case "picaro":
                config.set(sender.getName() + "_class", "picaro");
                sender.sendMessage(ChatColor.GOLD + "Clase establecida: " + ChatColor.GREEN + "picaro");
                break;
            case "mago":
                config.set(sender.getName() + "_class", "mago");
                sender.sendMessage(ChatColor.GOLD + "Clase establecida: " + ChatColor.GREEN + "mago");
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Argumento incorrecto!");
                return false;
        }
        return false;
    }
}
