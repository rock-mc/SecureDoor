package com.rock_mc.securedoors.utils;

import com.rock_mc.securedoors.SecureDoors;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Log {
    public static final String PREFIX_GAME = "[" + ChatColor.GOLD + SecureDoors.APP_NAME + ChatColor.WHITE + "] ";
    public static final String PREFIX_SERVER = "[" + SecureDoors.APP_NAME + "] ";


    public static void sendMessage(Player player, String message) {
        player.sendMessage(PREFIX_GAME + message);
    }

    public static void broadcast(String message) {
        broadcast(message, null);
    }

    public static void broadcast(String message, ChatColor color) {
        String formattedMessage = PREFIX_GAME;
        if (color != null) {
            formattedMessage += color;
        }
        formattedMessage += message;
        Bukkit.broadcastMessage(formattedMessage);
    }

    public static void logInfo(String message) {
        Bukkit.getLogger().info(PREFIX_SERVER + message);
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