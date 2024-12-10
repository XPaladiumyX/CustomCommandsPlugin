package skyxnetwork.customCommandsPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import skyxnetwork.customCommandsPlugin.commands.Craft;
import skyxnetwork.customCommandsPlugin.commands.Enderchest;
import skyxnetwork.customCommandsPlugin.commands.Smelt;

public class CustomCommandsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig(); // Charger ou créer config.yml

        // Enregistrer les commandes
        if (getCommand("craft") != null) {
            getCommand("craft").setExecutor(new Craft());
        } else {
            getLogger().warning("La commande /craft n'est pas définie dans plugin.yml !");
        }

        if (getCommand("ec") != null) {
            getCommand("ec").setExecutor(new Enderchest());
        } else {
            getLogger().warning("La commande /ec n'est pas définie dans plugin.yml !");
        }

        if (getCommand("enderchest") != null) {
            getCommand("enderchest").setExecutor(new Enderchest());
        } else {
            getLogger().warning("La commande /enderchest n'est pas définie dans plugin.yml !");
        }

        if (getCommand("smelt") != null) {
            getCommand("smelt").setExecutor(new Smelt(this));
        } else {
            getLogger().warning("La commande /smelt n'est pas définie dans plugin.yml !");
        }

        getLogger().info("CustomCommandsPlugin activé !");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomCommandsPlugin désactivé !");
    }
}
