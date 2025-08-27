package org.survivalcraft.painlib.utils;

import org.bukkit.entity.Player;
import org.survivalcraft.painlib.PainLib;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConnectionHelper {

    /**
     * Connects a given {@link Player} to a given server. <b>Only works with BungeeCord</b>
     * @param player Targeted player.
     * @param serverName The targeted serverName.
     */
    public static void connect(Player player, String serverName) {
        connectPlayerToServer(player, serverName);
    }

    /**
     * Kicks a given {@link Player}.
     * @param target Targeted player.
     * @param reason Reason of the kick.
     */
    public static void kick(Player target, String reason) {
        target.kickPlayer(reason);
    }

    private static void connectPlayerToServer(Player player, String serverName) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF(PainLib.getInstance().getPlugin().getName());
            out.writeUTF(serverName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        player.sendPluginMessage(PainLib.getInstance().getPlugin(), "BungeeCord", b.toByteArray());
    }

}