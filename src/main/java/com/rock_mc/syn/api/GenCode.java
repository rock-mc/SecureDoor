package com.rock_mc.syn.api;

import com.rock_mc.syn.Syn;
import com.rock_mc.syn.command.CmdManager;
import com.rock_mc.syn.log.Logger;
import com.rock_mc.syn.utlis.Utils;
import com.rock_mc.syn.config.Config;
import org.bukkit.entity.Player;

public class GenCode {

    private final static String commandName = CmdManager.GENCODE;

    public static String [] exec(Syn plugin, Logger logger, Player player, int codeNum) {
        if (plugin.cmdManager.lacksPermission(player, commandName)) {
            logger.sendMessage(player, "You don't have permission to use this command.");
            return null;
        }

        if (codeNum <= 0) {
            logger.sendMessage(player, "Invalid number of codes.");
            logger.sendMessage(player, plugin.cmdManager.getCmd(commandName).usage);
            return null;
        }
        if (codeNum > 1000) {
            logger.sendMessage(player, "The number of codes is too large.");
            logger.sendMessage(player, plugin.cmdManager.getCmd(commandName).usage);
            return null;
        }

        String available_characters = plugin.getConfig().getString(Config.AVAILABLE_CHARS);
        int code_length = plugin.getConfig().getInt(Config.CODE_LENGTH);

        // Generate a verification code
        // Check the code is unique
        String [] codes = new String[codeNum];

        for (int i = 0; i < codeNum; i++) {

            String code = Utils.generateCode(available_characters, code_length);
            while (plugin.dbManager.containsCode(code)) {
                code = Utils.generateCode(available_characters, code_length);
            }
            plugin.dbManager.addCode(code);

            codes[i] = code;
        }
        return codes;
    }
}
