package org.dinastia.dndclasses;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class GetBirraCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        ItemStack cerveza = new ItemStack(Material.POTION);
        ItemMeta meta = cerveza.getItemMeta();
        meta.setDisplayName("Cerveza");
        meta.getPersistentDataContainer().set(new NamespacedKey(MainPlugin.getInstance(), "cerveza"), PersistentDataType.INTEGER, 1);
        cerveza.setItemMeta(meta);
        player.getInventory().addItem(cerveza);

        return false;
    }
}
