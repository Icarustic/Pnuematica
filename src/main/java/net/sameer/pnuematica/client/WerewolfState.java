package net.sameer.pnuematica.client;

import net.minecraft.world.entity.player.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class WerewolfState {
    private static final Set<UUID> werewolves = new HashSet<>();

    public static boolean isWerewolf(Player player) {
        return werewolves.contains(player.getUUID());
    }

    public static void setWerewolf(Player player, boolean isWerewolf) {
        if (isWerewolf) {
            werewolves.add(player.getUUID());
        } else {
            werewolves.remove(player.getUUID());
        }
    }

    public static void toggle(Player player) {
        setWerewolf(player, !isWerewolf(player));
    }
}