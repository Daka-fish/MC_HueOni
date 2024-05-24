package net.tv.twitch.chrono_fish.hueoni;

import net.tv.twitch.chrono_fish.hueoni.CommandPack.HueOniCommands;
import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import org.bukkit.plugin.java.JavaPlugin;

public final class HueOni extends JavaPlugin {

    private static HueOniGame hueOniGame;

    @Override
    public void onEnable() {
        hueOniGame = new HueOniGame();
        getCommand("hueOni").setExecutor(new HueOniCommands());
        getServer().getPluginManager().registerEvents(new HueOniEvent(),this);
    }

    public static HueOniGame getGame(){
        return hueOniGame;
    }
}
