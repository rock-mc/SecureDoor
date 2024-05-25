package com.rock_mc.syn;

import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Log {
    public static final String PREFIX_GAME = "[" + ChatColor.GOLD + Syn.APP_NAME + ChatColor.WHITE + "] ";
    public static final String PREFIX_SERVER = "[" + Syn.APP_NAME + "] ";


    public static void sendMessage(Player player, String message) {

        if (player != null) {
            player.sendMessage(PREFIX_GAME + message);
        }

        message = ChatColor.stripColor(message);
        logInfo(message);
    }

    public static void broadcast(String message, ChatColor color) {
        String formattedMessage = PREFIX_GAME;
        if (color != null) {
            formattedMessage += color;
        }
        formattedMessage += message;
        Bukkit.broadcastMessage(formattedMessage);
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(PREFIX_GAME + message);
    }

    public static void logInfo(String message) {
        Bukkit.getConsoleSender().sendMessage(PREFIX_SERVER + message);
    }

    public static void logWarning(String message) {
        Bukkit.getLogger().warning(PREFIX_SERVER + message);
    }

    public static void logSevere(String message) {
        Bukkit.getLogger().severe(PREFIX_SERVER + message);
    }

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}