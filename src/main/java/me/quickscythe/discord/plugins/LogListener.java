package me.quickscythe.discord.plugins;

import me.quickscythe.utils.BlockBridgeDiscordUtils;
import me.quickscythe.utils.listeners.Listener;

public class LogListener implements Listener.StatusListener,Listener.LeaveListener,Listener.JoinListener {
    @Override
    public void onJoin(String s, String s1, String s2) {
        BlockBridgeDiscordUtils.getLogger().log("User " + s + " joined the server");
    }

    @Override
    public void onLeave(String s, String s1, String s2) {

    }

    @Override
    public void onStatusChange(String s, String s1, String s2) {

    }
}
