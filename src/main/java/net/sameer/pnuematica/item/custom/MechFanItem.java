package net.sameer.pnuematica.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;


public class MechFanItem extends Item {
    public MechFanItem(Properties p_41383_) {
        super(p_41383_);
    }
    private static final int COOLDOWN_TIME = 20 * 5; // 5 seconds cooldown
    private static final int FORCE_DURATION = 20 * 7; // 7 seconds force duration
    private int cooldown;



    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide && cooldown <= 0) { // Only run this on the server side
            // Get the player's rotation angles
            float yaw = player.getYRot();
            float pitch = player.getXRot();

            // Calculate the direction vector based on yaw and pitch
            Vec3 directionVector = getDirectionVector(yaw, pitch);

            // Apply a force to nearby mobs in the calculated direction
            double forceMagnitude = 2.0; // Adjust this value as needed
            applyForceToNearbyMobs(player, directionVector, forceMagnitude);


            // Spawn arrow particles to visualize wind direction
            spawnWindParticles(level, player, directionVector);


            // Send the pitch value to the chat
            sendChatMessage("Pitch: " + pitch, player);
            cooldown = COOLDOWN_TIME;
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    private void sendChatMessage(String message, Player player) {
        Component chatMessage = Component.literal(message);
        Minecraft.getInstance().player.displayClientMessage(chatMessage, true);


    }
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player) {
            Player player = (Player) entity;
            if (cooldown > 0) {
                cooldown--;
                if (cooldown % 20 == 0) { // Update the cooldown message every second
                    sendChatMessage("Cooldown: " + cooldown / 20, player);
                }
            } else {
                // Remove the force from mobs after the duration
                removeForceFromMobs(player);
            }
        }
    }

    private void removeForceFromMobs(Player player) {
        double range = 5.0; // Adjust this value to define the range of effect
        for (Entity entity : player.level.getEntities(player, player.getBoundingBox().inflate(range))) {
            if (entity instanceof Mob) {
                Mob mob = (Mob) entity;
                mob.setDeltaMovement(mob.getDeltaMovement().x, mob.getDeltaMovement().y, mob.getDeltaMovement().z);
            }
        }
    }

    private void spawnWindParticles(Level pLevel, Player pPlayer, Vec3 directionVector) {
        int particleCount = 20; // Adjust this value to control the number of particles

        // Spawn wind particles in the calculated direction
        for (int i = 0; i < particleCount; i++) {
            double x = pPlayer.getX();
            double y = pPlayer.getY() + pPlayer.getEyeHeight() / 2.0D;
            double z = pPlayer.getZ();

            // Add a small random offset to the position to prevent all particles from spawning in the same spot
            x += pPlayer.getRandom().nextGaussian() * 1.5D;
            y += pPlayer.getRandom().nextGaussian() * 0.5D;
            z += pPlayer.getRandom().nextGaussian() * 1.5D;

            Vec3 particleVector = directionVector.normalize().scale(1.0D);
            pLevel.addParticle(ParticleTypes.SMOKE, x, y, z, particleVector.x, particleVector.y, particleVector.z);
        }
    }


    private Vec3 getDirectionVector(float yaw, float pitch) {
        // Convert yaw and pitch to radians
        double yawRad = Math.toRadians(yaw - 270.0f); // Adjust yaw to account for player's perspective
        double pitchRad = Math.toRadians(-pitch);

        // Cap the pitch at -10 degrees
        if (pitchRad < -Math.toRadians(10)) {
            pitchRad = Math.toRadians(20); // have to use positive value since they all become negative
        }

        // Calculate the direction vector
        double x = Math.cos(yawRad) * Math.cos(pitchRad);
        double y = Math.sin(pitchRad);
        double z = Math.sin(yawRad) * Math.cos(pitchRad);

        return new Vec3(x, y, z).normalize();
    }


    private void applyForceToNearbyMobs(Player player, Vec3 directionVector, double forceMagnitude) {
        double range = 7.0; // Adjust this value to define the range of effect
        for (Entity entity : player.level.getEntities(player, player.getBoundingBox().inflate(range))) {
            if (entity instanceof Mob) {
                Mob mob = (Mob) entity;
                Vec3 force = directionVector.normalize().scale(forceMagnitude);
                mob.setDeltaMovement(mob.getDeltaMovement().x + force.x, mob.getDeltaMovement().y + force.y, mob.getDeltaMovement().z + force.z);
            }
        }
    }
}