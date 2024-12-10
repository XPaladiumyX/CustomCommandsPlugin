package skyxnetwork.customCommandsPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Craft implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cThis command is for players only!");
            return true;
        }

        if (!player.hasPermission("skyxnetwork.customcommandsplugin.craft") &&
                !player.hasPermission("skyxnetwork.customcommandsplugin.*")) {
            player.sendMessage("§cYou do not have permission to use this command.");
            return true;
        }

        player.openWorkbench(null, true); // Ouvre une table de craft virtuelle
        return true;
    }
}
