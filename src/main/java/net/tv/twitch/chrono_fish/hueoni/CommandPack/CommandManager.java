package net.tv.twitch.chrono_fish.hueoni.CommandPack;

import net.kyori.adventure.text.format.NamedTextColor;
import net.tv.twitch.chrono_fish.hueoni.GamePack.HueOniGame;
import net.tv.twitch.chrono_fish.hueoni.GamePack.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CommandManager {
    static HueOniGame hueOniGame = new HueOniGame();

    public static void hueOni(Player sender, String[] args){
        switch(args[0]){
            case "start":
                sender.sendMessage("ゲームを開始します");
                if(hueOniGame.getNumberOfChasers() < 2){
                    sender.sendMessage(ChatColor.RED+"鬼の数が足りません(あと?人)");
                }
                break;

            case "check":
                break;

            case "oni":
                if(args.length<2){
                    sender.sendMessage(ChatColor.RED+"/hueOni oni {playerName}");
                    return;
                }
                Player oniTarget = Bukkit.getPlayerExact(args[1]);
                if(oniTarget == null){
                    sender.sendMessage(ChatColor.RED+"プレイヤーが見つかりません!");
                    return;
                }
                sender.sendMessage(oniTarget.getName()+"を鬼にしました。");
                hueOniGame.putToMap(oniTarget, PlayerState.Chaser);
                break;

            case "nige":
                if(args.length<2){
                    sender.sendMessage(ChatColor.RED+"/hueOni nige {playerName}");
                    return;
                }
                Player nigeTarget = Bukkit.getPlayerExact(args[1]);
                if(nigeTarget == null){
                    sender.sendMessage(ChatColor.RED+"プレイヤーが見つかりません!");
                    return;
                }
                sender.sendMessage(nigeTarget.getName()+"を逃げにしました。");
                hueOniGame.putToMap(nigeTarget, PlayerState.Runner);
                break;
        }
    }
}
