package blockbreak.blockbreak;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public final class BlockBreak extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("<Block Break> I HAVE STARTED");
        getServer().getPluginManager().registerEvents(this, this);
    }

    //Block Break
    @EventHandler
    public void blockBreak(BlockBreakEvent event) {
        Material block = event.getBlock().getType();
        Player player = event.getPlayer();
        if (block != Material.WOOL) {
            player.sendMessage(ChatColor.RED + "You cannot break the block");
            event.setCancelled(true);
        }
    }

    //Block Place
    @EventHandler
    public void Place(BlockPlaceEvent event) {
        Material blockPlace = event.getBlockPlaced().getType();
        Player playerPlace = event.getPlayer();
        if (blockPlace != Material.WOOL) {
            playerPlace.sendMessage(ChatColor.RED + "You cannot break the block");
            event.setCancelled(true);
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("<Block Break> So long");
    }
}
