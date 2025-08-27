package org.survivalcraft.painlib;

import org.bukkit.plugin.java.JavaPlugin;

public final class PainLibPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().info("[PainLib] Starting PainLib version " + PainLib.VERSION + " by Painperdu12.");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("[PainLib] Disabling PainLib version " + PainLib.VERSION + " by Painperdu12. Good Bye!");
    }
}