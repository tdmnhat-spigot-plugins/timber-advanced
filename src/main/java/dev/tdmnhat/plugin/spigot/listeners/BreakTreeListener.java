package dev.tdmnhat.plugin.spigot.listeners;

import dev.tdmnhat.plugin.spigot.TimberAdvanced;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakTreeListener implements Listener {

    private TimberAdvanced plugin;

    public BreakTreeListener(TimberAdvanced plugin) {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {

    }
}
