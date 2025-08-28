package org.survivalcraft.painlib.gui;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class GuiManager {

    private static HashMap<String, Class> openGuis = new HashMap<>();

    public static Gui openGui(Gui gui) {
        openForPlayer(gui.getPlayer(), gui.getClass());
        gui.open();

        return gui;
    }

    public static void openForPlayer(Player player, Class clazz) {
        if(openGuis.containsKey(player.getName())) {
            openGuis.remove(player.getName());
        }

        openGuis.put(player.getName(), clazz);
    }

    public static void closeForPlayer(Player player) {
        player.getOpenInventory().close();

        if(openGuis.containsKey(player.getName())) {
            openGuis.remove(player.getName());
        }
    }

    public static boolean isPlayerManaged(Player player) {
        return openGuis.containsKey(player.getName());
    }

    public static boolean isGuiManaged(Class clazz) {
        for(Class c : openGuis.values()) {
            if(c.equals(clazz)) return true;
        }

        return false;
    }

}