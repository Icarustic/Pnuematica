package net.sameer.pnuematica.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class RenderWerewolfHandler {
    private static final float BODY_FOLLOW_HEAD_THRESHOLD = 75.0F;
    private static final float BODY_LERP_SPEED = 0.15F;

    // Persistent per-player body yaw
    private static final Map<UUID, Float> playerBodyYaws = new HashMap<>();

    @SubscribeEvent
    public static void onRenderPlayer(RenderPlayerEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (WerewolfState.isWerewolf(player)) {
            event.setCanceled(true);

            Level level = player.level;
            DummyWerewolfEntity dummy = new DummyWerewolfEntity(level);

            dummy.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());

            float prevBodyYaw = playerBodyYaws.getOrDefault(player.getUUID(), player.getYRot());
            float headYaw = player.getYHeadRot();
            float yawDiff = Mth.wrapDegrees(headYaw - prevBodyYaw);

            // Only lerp body if head turns too far
            if (yawDiff < -BODY_FOLLOW_HEAD_THRESHOLD) {
                prevBodyYaw = headYaw + BODY_FOLLOW_HEAD_THRESHOLD;
            } else if (yawDiff > BODY_FOLLOW_HEAD_THRESHOLD) {
                prevBodyYaw = headYaw - BODY_FOLLOW_HEAD_THRESHOLD;
            } else {
                prevBodyYaw = prevBodyYaw + yawDiff * BODY_LERP_SPEED;
            }

            // Save for next tick
            playerBodyYaws.put(player.getUUID(), prevBodyYaw);

            // Set dummy body to bodyYaw, head to headYaw
            dummy.setYRot(prevBodyYaw);
            dummy.yRotO = prevBodyYaw;
            dummy.yBodyRot = prevBodyYaw;
            dummy.yBodyRotO = prevBodyYaw;

            dummy.setYHeadRot(headYaw);
            dummy.yHeadRotO = headYaw;

            dummy.setXRot(player.getXRot());
            dummy.xRotO = player.xRotO;

            // This is crucial: the Ravager model's head rotation is controlled by the difference between headYaw and bodyYaw
            // If you make a custom model, you'd pass (headYaw - bodyYaw) as netHeadYaw in setupAnim

            Minecraft mc = Minecraft.getInstance();
            PoseStack poseStack = event.getPoseStack();
            MultiBufferSource buffer = event.getMultiBufferSource();

            // Use the body yaw for entity render orientation (not head yaw)
            mc.getEntityRenderDispatcher().render(
                    dummy,
                    player.getX() - mc.cameraEntity.getX(),
                    player.getY() - mc.cameraEntity.getY(),
                    player.getZ() - mc.cameraEntity.getZ(),
                    prevBodyYaw,
                    event.getPartialTick(),
                    poseStack,
                    buffer,
                    15728880
            );
        }
    }
}