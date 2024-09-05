package me.quickscythe.discord.plugins;

import me.quickscythe.api.BotPlugin;
import me.quickscythe.api.config.ConfigFile;
import me.quickscythe.api.config.ConfigFileManager;

public class LogPlugin extends BotPlugin {


    public void enable() {
        new LogListener(this);

        ConfigFile config = ConfigFileManager.getFile(this, "config");
        if (!config.getData().has("join_log")) config.getData().put("join_log", true);
        if (!config.getData().has("leave_log")) config.getData().put("leave_log", true);
        if (!config.getData().has("status_log")) config.getData().put("status_log", true);

        if (!config.getData().has("join_message")) config.getData().put("join_message", "User [0] joined the server");
        if (!config.getData().has("leave_message")) config.getData().put("leave_message", "User [0] left the server");
        if (!config.getData().has("status_message")) config.getData().put("status_message", "Server Status: [0]");
        config.save();

    }
}