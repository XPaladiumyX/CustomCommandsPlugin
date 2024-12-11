package skyxnetwork.customCommandsPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import skyxnetwork.customCommandsPlugin.CustomCommandsPlugin;

public class ReloadCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public ReloadCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("skyxnetwork.customcommandsplugin.reload") &&
                !sender.hasPermission("skyxnetwork.customcommandsplugin.*")) {
            sender.sendMessage(getPluginPrefix() + "§cYou do not have permission to use this command.");
            return true;
        }

        // Recharge la configuration et le préfixe
        plugin.reloadConfig();
        ((CustomCommandsPlugin) plugin).loadPrefix();
        sender.sendMessage(getPluginPrefix() + "§aConfiguration reloaded successfully!");
        return true;
    }

    private String getPluginPrefix() {
        // Caster le plugin pour accéder à CustomCommandsPlugin et récupérer le préfixe
        return ((CustomCommandsPlugin) plugin).getPluginPrefix();
    }
}