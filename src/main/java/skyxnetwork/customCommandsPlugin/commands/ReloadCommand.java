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
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig(); // Recharge le fichier config.yml
            sender.sendMessage("§aLe fichier config.yml a été rechargé avec succès !");
            return true;
        }

        sender.sendMessage("§cUsage: /CustomCommandsPlugin reload");
        return false;
    }
}