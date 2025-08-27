package org.survivalcraft.painlib.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatHelper {

    public static String PREFIX = "";
    public static final String ERROR_PREFIX = "&4[&cErreur&4]&c ";

    /**
     * Returns a formatted message with {@link ChatColor#translateAlternateColorCodes}
     * @return A formatted message
     */
    public static String getFormattedMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

     /**
      * Send a message to a given player with the defined prefix.
      * @param message Message to send.
      * @param player Targeted player.
      */
    public static void sendMessage(String message, Player player) {
        player.sendMessage(getFormattedMessage(PREFIX + message));
    }

    /**
     * Send a message <b>without</b> the defined prefix.
     * @param message Message to send without the prefix
     * @param player Targeted player
     */
    public static void sendRawMessage(String message, Player player) {
        player.sendMessage(getFormattedMessage(message));
    }

    /**
     * Send an error message to a given player. The message is pre-formatted with an error prefix.
     * @param error The error message
     * @param player Targeted player
     */
    public static void sendError(String error, Player player) {
        player.sendMessage(getFormattedMessage(ERROR_PREFIX + error));
    }

    /**
     * Broadcast a message with the defined prefix.
     * @param message Message to broadcast
     */
    public static void broadcast(String message) {
        Bukkit.broadcastMessage(getFormattedMessage(PREFIX + message));
    }

    /**
     * Broadcast a message <b>without</b> the defined prefix
     * @param message Message to broadcast
     */
    public static void broadcastRaw(String message) {
        Bukkit.broadcastMessage(getFormattedMessage(message));
    }

    /**
     * Sets the ChatHelper prefix. The prefix is used in sendMessage and broadcast methods.
     * @param prefix Prefix to set
     */
    public static void setPREFIX(String prefix) {
        ChatHelper.PREFIX = prefix;
    }
}