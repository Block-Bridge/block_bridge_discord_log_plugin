package me.quickscythe.discord.plugins;

import me.quickscythe.api.BotPlugin;
import me.quickscythe.api.config.ConfigFileManager;
import me.quickscythe.api.event.minecraft.PlayerChatEvent;
import me.quickscythe.api.event.minecraft.PlayerJoinEvent;
import me.quickscythe.api.event.minecraft.PlayerLeaveEvent;
import me.quickscythe.api.event.minecraft.ServerStatusChangeEvent;
import me.quickscythe.api.listener.Listener;
import me.quickscythe.utils.BlockBridgeDiscordUtils;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class LogListener implements Listener.StatusListener,Listener.LeaveListener,Listener.JoinListener, Listener.ChatListener {

    private final BotPlugin plugin;

    public LogListener(BotPlugin plugin){
        this.plugin = plugin;
        BlockBridgeDiscordUtils.getMain().getApi().getWebApp().addListener(plugin, this);
    }
    @Override
    public void onJoin(PlayerJoinEvent e) {
        BlockBridgeDiscordUtils.getLogger().log(ConfigFileManager.getFile(plugin, "config").getData().getString("join_message"), e.getPlayer().getName());
    }

    @Override
    public void onLeave(PlayerLeaveEvent e) {
        BlockBridgeDiscordUtils.getLogger().log(ConfigFileManager.getFile(plugin, "config").getData().getString("leave_message"), e.getPlayer().getName());
    }

    @Override
    public void onStatusChange(ServerStatusChangeEvent e) {
        BlockBridgeDiscordUtils.getLogger().log("Server Status: " + e.getStatus());
    }

    @Override
    public void onPlayerChat(PlayerChatEvent playerChatEvent) {
        String message = "Chat: " + playerChatEvent.getPlayer().getName() + " - " + playerChatEvent.getMessage();
        BlockBridgeDiscordUtils.getMain().getBot().getLogsChannel().sendMessageEmbeds(
                new EmbedBuilder()
                        .setColor(Color.GREEN)
                        .setTitle("INFO")
                        .setDescription(message).build())
                .queue();
    }
}
