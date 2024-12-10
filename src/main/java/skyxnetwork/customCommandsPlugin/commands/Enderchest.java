package skyxnetwork.customCommandsPlugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Enderchest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player.openInventory(player.getEnderChest()); // Ouvre l'enderchest
            return true;
        }
        sender.sendMessage("Cette commande est uniquement pour les joueurs !");
        return false;
    }
}
