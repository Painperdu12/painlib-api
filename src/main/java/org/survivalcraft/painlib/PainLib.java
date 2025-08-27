package org.survivalcraft.painlib;

import org.bukkit.plugin.java.JavaPlugin;

public class PainLib {

    public static final String VERSION = "1.5.1";

    private static PainLib instance;
    private JavaPlugin plugin;

    public void init(JavaPlugin plugin) {
        this.plugin = plugin;

        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public static PainLib getInstance() {
        if(instance == null) instance = new PainLib();

        return instance;
    }
}