package net.alphaplace.mm;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class PlayerHandler extends PlayerListener
{
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if (event.getClickedBlock() == null)
            return;
        if (event.getItem() == null)
            return;

        if (event.getClickedBlock().getType() == Material.RAILS || event.getClickedBlock().getType() == Material.POWERED_RAIL)
        {
            if (event.getItem().getType() == Material.MINECART && MinecartManager.instance.getConfiguration().getBoolean("normal-disabled", false))
            {
                event.getPlayer().sendMessage(ChatColor.RED + "Normal minecarts are disabled on this server!");
                event.setCancelled(true);
            }

            if (event.getItem().getType() == Material.STORAGE_MINECART && MinecartManager.instance.getConfiguration().getBoolean("chest-disabled", false))
            {
                event.getPlayer().sendMessage(ChatColor.RED + "Chest minecarts are disabled on this server!");
                event.setCancelled(true);
            }

            if (event.getItem().getType() == Material.POWERED_MINECART && MinecartManager.instance.getConfiguration().getBoolean("furnace-disabled", false))
            {
                event.getPlayer().sendMessage(ChatColor.RED + "Furnace minecarts are disabled on this server!");
                event.setCancelled(true);
            }
        }
    }
}
