package skyxnetwork.customCommandsPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public ReloadCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("skyxnetwork.customcommandsplugin.reload") &&
                !sender.hasPermission("skyxnetwork.customcommandsplugin.*")) {
            sender.sendMessage("§cYou do not have permission to use this command.");
            return true;
        }

        plugin.reloadConfig(); // Recharge le fichier config.yml
        sender.sendMessage("§aConfiguration reloaded successfully!");
        return true;
    }
}