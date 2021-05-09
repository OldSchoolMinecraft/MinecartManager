package net.alphaplace.mm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecartManager extends JavaPlugin
{
    public static MinecartManager instance;

    public void onEnable()
    {
        instance = this;

        getConfiguration().load();

        getConfiguration().getBoolean("normal-disabled", false);
        getConfiguration().getBoolean("chest-disabled", false);
        getConfiguration().getBoolean("furnace-disabled", false);

        getConfiguration().save();

        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_INTERACT, new PlayerHandler(), Event.Priority.Normal, this);

        System.out.println("MinecartManager enabled");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (label.equalsIgnoreCase("mm"))
        {
            if (!sender.hasPermission("mm.admin") && !sender.isOp())
            {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
                return true;
            }

            if (args.length >= 1 && args[0].equalsIgnoreCase("reload"))
            {
                getConfiguration().load();
                getConfiguration().save();

                sender.sendMessage(ChatColor.GREEN + "Config reloaded");
                return true;
            }

            sender.sendMessage(ChatColor.GRAY + "MinecartManager for " + ChatColor.GREEN + "AlphaPlace");
            return true;
        }

        return false;
    }

    public void onDisable()
    {
        System.out.println("MinecartManager disabled");
    }
}
