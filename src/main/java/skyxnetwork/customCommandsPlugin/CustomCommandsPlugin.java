package skyxnetwork.customCommandsPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import skyxnetwork.customCommandsPlugin.commands.Craft;
import skyxnetwork.customCommandsPlugin.commands.Enderchest;
import skyxnetwork.customCommandsPlugin.commands.ReloadCommand;
import skyxnetwork.customCommandsPlugin.commands.Smelt;

public class CustomCommandsPlugin extends JavaPlugin {
    private static final String ANSI_MAGENTA = "\u001B[35m";
    private static final String ANSI_LIGHT_GRAY = "\u001B[37m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_LIGHT_GREEN = "\u001B[92m";
    private static final String ANSI_RED = "\u001B[31m";

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ANSI_LIGHT_GRAY + "︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹");
        Bukkit.getLogger().info(ANSI_MAGENTA + " _______  ___   _  __   __    __   __    __    _  _______  _______ " + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "|       ||   | | ||  | |  |  |  |_|  |  |  |  | ||       ||       |" + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "|  _____||   |_| ||  |_|  |  |       |  |   |_| ||    ___||_     _|" + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "| |_____ |      _||       |  |       |  |       ||   |___   |   |  " + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "|_____  ||     |_ |_     _|   |     |   |  _    ||    ___|  |   |  " + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + " _____| ||    _  |  |   |    |   _   |  | | |   ||   |___   |   |  " + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "|_______||___| |_|  |___|    |__| |__|  |_|  |__||_______|  |___|  " + ANSI_RESET);
        Bukkit.getLogger().info("   ");
        Bukkit.getLogger().info(ANSI_LIGHT_GREEN + "Plugin CustomCommandsPlugin enabled !");
        Bukkit.getLogger().info(ANSI_LIGHT_GRAY + "︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺");

        saveDefaultConfig(); // Charger ou créer config.yml

        // Enregistrer les commandes
        if (getCommand("craft") != null) {
            getCommand("craft").setExecutor(new Craft());
        } else {
            getLogger().warning("/craft command is not defined in plugin.yml!");
        }

        if (getCommand("ec") != null) {
            getCommand("ec").setExecutor(new Enderchest());
        } else {
            getLogger().warning("/ec command is not defined in plugin.yml!");
        }

        if (getCommand("enderchest") != null) {
            getCommand("enderchest").setExecutor(new Enderchest());
        } else {
            getLogger().warning("/enderchest command is not defined in plugin.yml!");
        }

        if (getCommand("smelt") != null) {
            getCommand("smelt").setExecutor(new Smelt(this));
        } else {
            getLogger().warning("/smelt command is not defined in plugin.yml!");
        }
        if (getCommand("customcommandsplugin") != null) {
            getCommand("customcommandsplugin").setExecutor(new ReloadCommand(this));
        } else {
            getLogger().warning("The /CustomCommandsPlugin command is not defined in plugin.yml!");
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ANSI_LIGHT_GRAY + "︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹︹");
        Bukkit.getLogger().info(ANSI_MAGENTA + " _______  ___   _  __   __    __   __    __    _  _______  _______ " + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "|       ||   | | ||  | |  |  |  |_|  |  |  |  | ||       ||       |" + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "|  _____||   |_| ||  |_|  |  |       |  |   |_| ||    ___||_     _|" + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "| |_____ |      _||       |  |       |  |       ||   |___   |   |  " + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "|_____  ||     |_ |_     _|   |     |   |  _    ||    ___|  |   |  " + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + " _____| ||    _  |  |   |    |   _   |  | | |   ||   |___   |   |  " + ANSI_RESET);
        Bukkit.getLogger().info(ANSI_MAGENTA + "|_______||___| |_|  |___|    |__| |__|  |_|  |__||_______|  |___|  " + ANSI_RESET);
        Bukkit.getLogger().info("   ");
        Bukkit.getLogger().info(ANSI_RED + "  Plugin CustomCommandsPlugin disabled !");
        Bukkit.getLogger().info(ANSI_LIGHT_GRAY + "︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺︺");
    }
}
