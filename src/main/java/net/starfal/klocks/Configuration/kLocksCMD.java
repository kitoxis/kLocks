package net.starfal.klocks.Configuration;

import net.kyori.adventure.text.Component;
import net.starfal.klocks.Functions.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class kLocksCMD implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("klocks")){
            if (sender.hasPermission("klocks.use")){
                if (args.length == 0) {
                    String message = (String) Settings.getInstance().getMSG("General.kLocks-Usage");
                    message = message.replace("%prefix%", (String) Settings.getInstance().getMSG("General.Prefix"));
                    sender.sendMessage(Color.format(message));
                    if (Settings.getInstance().getBoolean("General.Action-Bars")){
                        Component bar = Component.text(Color.format(message));
                        sender.sendActionBar(bar);
                    }
                }else if (args.length >= 2){
                    String message = (String) Settings.getInstance().getMSG("General.kLocks-Usage");
                    message = message.replace("%prefix%", (String) Settings.getInstance().getMSG("General.Prefix"));
                    sender.sendMessage(Color.format(message));
                    if (Settings.getInstance().getBoolean("General.Action-Bars")){
                        Component bar = Component.text(Color.format(message));
                        sender.sendActionBar(bar);
                    }
                }else {
                    String message = (String) Settings.getInstance().getMSG("General.Reloaded");
                    message = message.replace("%prefix%", (String) Settings.getInstance().getMSG("General.Prefix"));
                    sender.sendMessage(Color.format(message));
                    if (Settings.getInstance().getBoolean("General.Action-Bars")){
                        Component bar = Component.text(Color.format(message));
                        sender.sendActionBar(bar);
                    }
                }
            }else {
                String message = (String) Settings.getInstance().getMSG("General.No-Permission");
                message = message.replace("%prefix%", (String) Settings.getInstance().getMSG("General.Prefix"));
                sender.sendMessage(Color.format(message));
                if (Settings.getInstance().getBoolean("General.Action-Bars")){
                    Component bar = Component.text(Color.format(message));
                    sender.sendActionBar(bar);
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return List.of("reload");
    }
}
