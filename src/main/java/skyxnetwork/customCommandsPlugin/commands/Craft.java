package skyxnetwork.customCommandsPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skyxnetwork.customCommandsPlugin.CustomCommandsPlugin;

public class Craft implements CommandExecutor {

    private final CustomCommandsPlugin plugin;

    public Craft(CustomCommandsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(plugin.getPluginPrefix() + "§cThis command is for players only!");
            return true;
        }

        if (!player.hasPermission("skyxnetwork.customcommandsplugin.craft") &&
                !player.hasPermission("skyxnetwork.customcommandsplugin.*")) {
            player.sendMessage(plugin.getPluginPrefix() + "§cYou do not have permission to use this command.");
            return true;
        }

        player.openWorkbench(null, true); // Ouvre une table de craft virtuelle
        return true;
    }
}
