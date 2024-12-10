package skyxnetwork.customCommandsPlugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Smelt implements CommandExecutor {

    private final JavaPlugin plugin;

    public Smelt(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Cette commande est uniquement pour les joueurs !");
            return false;
        }

        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (itemInHand == null || itemInHand.getType() == Material.AIR) {
            player.sendMessage("Vous devez tenir un objet !");
            return false;
        }

        String itemName = itemInHand.getType().name();
        String smeltedItemName = plugin.getConfig().getString("smeltable-items." + itemName);

        if (smeltedItemName != null) {
            Material smeltedMaterial = Material.matchMaterial(smeltedItemName);
            if (smeltedMaterial != null) {
                itemInHand.setAmount(itemInHand.getAmount() - 1);
                player.getInventory().addItem(new ItemStack(smeltedMaterial));
                player.sendMessage(plugin.getConfig().getString("messages.smelt-success")
                        .replace("%input%", itemName)
                        .replace("%output%", smeltedItemName));
                return true;
            }
        }

        player.sendMessage(plugin.getConfig().getString("messages.smelt-fail"));
        return false;
    }
}
