package net.sameer.pnuematica.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Mod.EventBusSubscriber
public class PocketWatchItem extends Item {
    public PocketWatchItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!world.isClientSide) {
            CompoundTag tag = player.getPersistentData();
            if (hand == InteractionHand.MAIN_HAND) {
                // Left-click: Set the player's current position, rotation, and world time
                tag.putDouble("time_turner_x", player.getX());
                tag.putDouble("time_turner_y", player.getY());
                tag.putDouble("time_turner_z", player.getZ());
                tag.putFloat("time_turner_yaw", player.getYRot());
                tag.putFloat("time_turner_pitch", player.getXRot());
                tag.putLong("time_turner_world_time", world.getGameTime());
                player.displayClientMessage(Component.literal("Position set!"), true);
            } else {
                // Right-click: Rewind the player's position and rotation
                if (tag.contains("time_turner_x")) {
                    double x = tag.getDouble("time_turner_x");
                    double y = tag.getDouble("time_turner_y");
                    double z = tag.getDouble("time_turner_z");
                    float yaw = tag.getFloat("time_turner_yaw");
                    float pitch = tag.getFloat("time_turner_pitch");
                    player.teleportTo(x, y, z);
                    player.setYRot(yaw);
                    player.setXRot(pitch);
                    tag.remove("time_turner_x");
                    tag.remove("time_turner_y");
                    tag.remove("time_turner_z");
                    tag.remove("time_turner_yaw");
                    tag.remove("time_turner_pitch");
                    tag.remove("time_turner_world_time");
                    player.displayClientMessage(Component.literal("Time rewound!"), true);
                } else {
                    player.displayClientMessage(Component.literal("No position set!"), true);
                }
            }
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }
}

