package org.survivalcraft.painlib;

import org.bukkit.plugin.java.JavaPlugin;

public final class PainLib extends JavaPlugin {

    public static final String VERSION = "1.0.0";

    private static PainLib instance;
    private JavaPlugin plugin;

    @Override
    public void onEnable() {
        instance = this;
        this.getLogger().info("[PainLib] Starting PainLib version " + VERSION + " by Painperdu12.");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("[PainLib] Disabling PainLib version " + VERSION + " by Painperdu12. Good Bye!");
    }

    /**
     * Hooks the API targeted {@link JavaPlugin} and init the required stuff for this API.
     * @param plugin Targeted plugin
     */
    public void init(JavaPlugin plugin) {
        this.plugin = plugin;

        this.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
    }

    /**
     * @return The hooked {@link JavaPlugin}
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

    public static PainLib getInstance() {
        return instance;
    }
}