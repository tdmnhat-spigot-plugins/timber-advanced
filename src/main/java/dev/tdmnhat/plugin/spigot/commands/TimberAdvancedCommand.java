package dev.tdmnhat.plugin.spigot.commands;

import dev.tdmnhat.plugin.spigot.TimberAdvanced;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jspecify.annotations.NonNull;

public class TimberAdvancedCommand implements CommandExecutor {

    private TimberAdvanced plugin;

    public TimberAdvancedCommand(TimberAdvanced plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String[] args) {
        FileConfiguration configuration = plugin.getConfig();
        String getPrefixPlugin = configuration.getString("prefix-plugin");
        if (args.length == 0) {
            sendMessageCommandHelp(sender);
        } else if (args.length == 1) {
            switch (args[0]) {
                case "toggle": {
                    if(!sender.hasPermission("timberadvanced.command.toggle") && !sender.isOp()) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getPrefixPlugin + " " + configuration.getString("no-permission")));
                        return false;
                    }

                    boolean toggleEnable = configuration.getBoolean("timber-enable");
                    configuration.set("timber-toggle.enable", !toggleEnable);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getPrefixPlugin + configuration.getString("timber-toggle.message").replace("%timber_advanced_toggle%", String.valueOf(toggleEnable))));
                    break;
                }
                case "help": {
                    sendMessageCommandHelp(sender);
                }
            }
        }
        return true;
    }

    public static void sendMessageCommandHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f-----------------------------------------------------------"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2/furnaceadvanced help:&e List commands"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2/furnaceadvanced toggle:&e Turn on/off fast destroying tree"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f-----------------------------------------------------------"));
    }
}
