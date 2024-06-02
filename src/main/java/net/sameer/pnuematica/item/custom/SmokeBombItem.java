package net.sameer.pnuematica.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SmokeBombItem extends Item {
    public SmokeBombItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (level.isClientSide) {
            // Spawn smoke particles around the player
            spawnSmokeParticles(level, player);

            sendChatMessage();
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    private void sendChatMessage() {
        Component chatMessage = Component.literal("Smoke bomb activated!");
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.displayClientMessage(chatMessage, true);
    }

    private void spawnSmokeParticles(Level pLevel, Player pPlayer) {
        int particleCount = 50; // Adjust this value to control the number of particles

        // Spawn smoke particles around the player
        for (int i = 0; i < particleCount; i++) {
            double x = pPlayer.getRandomX(1.0D);
            double y = pPlayer.getRandomY() + 0.5D;
            double z = pPlayer.getRandomZ(1.0D);
            pLevel.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0, 0);
        }
    }
}