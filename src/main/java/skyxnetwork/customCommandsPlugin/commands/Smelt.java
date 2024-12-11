package skyxnetwork.customCommandsPlugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import skyxnetwork.customCommandsPlugin.CustomCommandsPlugin;

public class Smelt implements CommandExecutor {

    private final JavaPlugin plugin;

    public Smelt(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(getPluginPrefix() + "§cThis command is for players only!");
            return true;
        }

        if (!player.hasPermission("skyxnetwork.customcommandsplugin.smelt") &&
                !player.hasPermission("skyxnetwork.customcommandsplugin.*")) {
            player.sendMessage(getPluginPrefix() + "§cYou do not have permission to use this command.");
            return true;
        }

        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (itemInHand == null || itemInHand.getType() == Material.AIR) {
            player.sendMessage(getPluginPrefix() + "§cYou must hold an item!");
            return true;
        }

        String itemName = itemInHand.getType().name();
        String smeltedItemName = plugin.getConfig().getString("smeltable-items." + itemName);

        if (smeltedItemName != null) {
            Material smeltedMaterial = Material.matchMaterial(smeltedItemName);
            if (smeltedMaterial != null) {
                int amount = itemInHand.getAmount();
                itemInHand.setAmount(0); // Retire tous les items fondus de la main
                player.getInventory().addItem(new ItemStack(smeltedMaterial, amount)); // Ajoute les items fondus

                // Message de succès
                String successMessage = plugin.getConfig().getString("messages.smelt-success",
                        "§aYou have melted §f%input% §aand obtained §f%output%.");
                successMessage = successMessage.replace("%input%", amount + " " + itemName)
                        .replace("%output%", amount + " " + smeltedItemName);
                player.sendMessage(getPluginPrefix() + successMessage);
                return true;
            }
        }

        // Message d'échec
        String failMessage = plugin.getConfig().getString("messages.smelt-fail", "§cThis item cannot be melted.");
        player.sendMessage(getPluginPrefix() + failMessage);
        return true;
    }

    private String getPluginPrefix() {
        // Caster le plugin pour accéder à CustomCommandsPlugin et récupérer le préfixe
        return ((CustomCommandsPlugin) plugin).getPluginPrefix();
    }
}