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

        String clase = "";

        switch(args[0]){
            case "barbaro":
                clase = "barbaro";
                config.set(sender.getName()+"_adicto", true);
                break;
            case "bardo":
                clase = "bardo";
                break;
            case "clerigo":
                clase = "clerigo";
                break;
            case "picaro":
                clase = "picaro";
                break;
            case "mago":
                clase = "mago";
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Argumento incorrecto!");
                return false;
        }

        config.set(sender.getName() + "_class", clase);
        sender.sendMessage(ChatColor.GOLD + "Clase establecida: " + ChatColor.GREEN + clase);

        return false;
    }
}
