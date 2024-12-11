# CustomCommandsPlugin  
# Devloped by ✨ | Sky X Network | ✨  
-
**Overview**  

CustomCommandsPlugin is a lightweight and highly configurable Minecraft plugin designed for Spigot 1.20-1.20.1 servers. It adds essential utility commands with customizable messages and permissions. The plugin is tailored for server owners looking for a simple solution to enhance gameplay without requiring additional dependencies. However, this plugin is not actively maintained for other developers or server owners.  

**Features**  

  - Fully Customizable Messages: Modify command outputs through the configuration file (config.yml).  
  - Configurable Prefix: Personalize the plugin prefix for all messages.  
  - Utility Commands: Includes /craft, /ec, /enderchest, /smelt, and /customcommandsplugin reload.  
  - Permissions Management: Fine-grained control over who can access each command.  
  - Simple Configuration: Easy to set up and adapt for your server.  

**Commands and Permissions**  

/craft - Opens a virtual crafting table. Permssion : skyxnetwork.customcommandsplugin.craft  
/ec or /enderchest - Opens the player's EnderChest. Permssion : skyxnetwork.customcommandsplugin.enderchest  
/smelt - Smelts the item in the player's hand.	Permssion : skyxnetwork.customcommandsplugin.smelt  
/customcommandsplugin reload	Reloads the plugin's configuration.	skyxnetwork.customcommandsplugin.reload  

**Wildcard Permission**  

**skyxnetwork.customcommandsplugin.***: Grants access to all commands and permissions.  

**Installation**  

  - Download the plugin .jar file.  
  - Place it in your server's plugins directory.  
  - Start or restart your server.  
  - Edit the config.yml file to customize messages and settings.  
  - Use /customcommandsplugin reload to apply changes.  

**Compatibility**  

This plugin is exclusively designed for Paper 1.20-1.20.1. It may not function as intended on other server versions or platforms like Spigot or Bukkit. No further updates or maintenance will be provided.  

**Example Configuration (config.yml)**  

``Prefix: "§dSky X §9Network §bCOMMANDS §8●⏺ "
smeltable-items:
  IRON_ORE: IRON_INGOT
  GOLD_ORE: GOLD_INGOT
  SAND: GLASS
messages:
  smelt-success: "§aYou have melted §f%input% §aand obtained §f%output%."
  smelt-fail: "§cThis item cannot be melted."``

# Supported Permission Manager Plugins :  
- LuckPerms
- PermissionsEx
- UltraPermissions
- GroupManager
- ZPermissions
- CommandBook

# Disclaimer

This plugin is provided as-is and is intended for Paper server owners who need lightweight utility commands. It will not receive updates or extended support for broader server types or newer versions.
# Please consider giving a star, it will help a lot ♥️! ^^
