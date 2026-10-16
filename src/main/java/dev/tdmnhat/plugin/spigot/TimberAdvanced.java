package dev.tdmnhat.plugin.spigot;

import dev.tdmnhat.plugin.spigot.commands.TimberAdvancedCommand;
import dev.tdmnhat.plugin.spigot.listeners.BreakTreeListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class TimberAdvanced extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerFiles();
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerFiles() {
        // config.yml
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new BreakTreeListener(this), this);
    }

    private void registerCommands() {
        this.getCommand("timberadvanced").setExecutor(new TimberAdvancedCommand(this));
    }
}
