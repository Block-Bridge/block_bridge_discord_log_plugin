package me.quickscythe.discord.plugins;

import me.quickscythe.api.BotPlugin;
import me.quickscythe.api.config.ConfigFileManager;
import me.quickscythe.utils.BlockBridgeDiscordUtils;

public class LogPlugin extends BotPlugin {


    public void enable() {
        BlockBridgeDiscordUtils.getMain().getApi().getWebApp().addListener(new LogListener());

        ConfigFileManager.getFile(this,"config").save();

    }
}