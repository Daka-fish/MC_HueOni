package net.tv.twitch.chrono_fish.hueoni;

import org.bukkit.ChatColor;

public enum PlayerState {
    Runner(ChatColor.AQUA),
    Killer(ChatColor.RED);

    private ChatColor color;

    PlayerState(ChatColor color){
        this.color = color;
    }
}