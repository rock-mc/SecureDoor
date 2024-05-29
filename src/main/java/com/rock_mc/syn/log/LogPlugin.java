package com.rock_mc.syn.log;

import com.rock_mc.syn.Syn;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class LogPlugin implements Log {
    public static final String PREFIX_GAME = "[" + ChatColor.GOLD + Syn.APP_NAME + ChatColor.WHITE + "] ";
    public static final String PREFIX_SERVER = "[" + Syn.APP_NAME + "] ";


    public void sendMessage(Player player, List<String> messages) {
        for (String message : messages) {
            sendMessage(player, message);
        }
    }

    @Override
    public void sendMessage(Player player, String message) {

        if (player != null) {
            player.sendMessage(PREFIX_GAME + message);
        }

        message = ChatColor.stripColor(message);
        logInfo(message);
    }

    public void broadcast(String message, ChatColor color) {
        String formattedMessage = PREFIX_GAME;
        if (color != null) {
            formattedMessage += color;
        }
        formattedMessage += message;
        Bukkit.broadcastMessage(formattedMessage);
    }

    public void broadcast(String message) {
        Bukkit.broadcastMessage(PREFIX_GAME + message);
    }

    public void logInfo(String message) {
        Bukkit.getConsoleSender().sendMessage(PREFIX_SERVER + message);
    }

    public void logWarning(String message) {
        Bukkit.getLogger().warning(PREFIX_SERVER + message);
    }

    public void logSevere(String message) {
        Bukkit.getLogger().severe(PREFIX_SERVER + message);
    }

    public String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}