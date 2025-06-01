package net.sameer.pnuematica.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class RenderWerewolfHandler {
    @SubscribeEvent
    public static void onRenderPlayer(RenderPlayerEvent.Pre event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (WerewolfState.isWerewolf(player)) {
            event.setCanceled(true);

            Level level = player.level;
            DummyWerewolfEntity dummy = new DummyWerewolfEntity(level);

            // Position
            dummy.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());

            // Get player's head yaw (where camera is facing)
            float yaw = player.getYHeadRot();

            // Set ALL yaw fields to match for the Ravager
            dummy.setYRot(yaw);
            dummy.yRotO = yaw;
            dummy.setYHeadRot(yaw);
            dummy.yHeadRotO = yaw;
            dummy.yBodyRot = yaw;     // THIS makes the body turn!
            dummy.yBodyRotO = yaw;

            // Set XRot for pitch (up/down look)
            dummy.setXRot(player.getXRot());
            dummy.xRotO = player.xRotO;

            Minecraft mc = Minecraft.getInstance();
            PoseStack poseStack = event.getPoseStack();
            MultiBufferSource buffer = event.getMultiBufferSource();

            mc.getEntityRenderDispatcher().render(
                    dummy,
                    player.getX() - mc.cameraEntity.getX(),
                    player.getY() - mc.cameraEntity.getY(),
                    player.getZ() - mc.cameraEntity.getZ(),
                    yaw, // Yaw for rendering
                    event.getPartialTick(),
                    poseStack,
                    buffer,
                    15728880 // full brightness
            );
        }
    }
}