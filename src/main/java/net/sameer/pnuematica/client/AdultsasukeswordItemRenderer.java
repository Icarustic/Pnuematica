package net.sameer.pnuematica.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sameer.pnuematica.PnuematicaMod;

public class AdultsasukeswordItemRenderer extends BlockEntityWithoutLevelRenderer {
    private final Adultsasukesword model;
    private static final ResourceLocation TEXTURE = new ResourceLocation(PnuematicaMod.MODID, "textures/item/adultsasukesword.png");

    public AdultsasukeswordItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        this.model = new Adultsasukesword(Minecraft.getInstance().getEntityModels().bakeLayer(Adultsasukesword.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType,
                             PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        poseStack.pushPose();

        // Adjust scale/rotation/translation as needed for proper hand/inventory alignment
        poseStack.scale(1.0F, 1.0F, 1.0F);

        var vertexConsumer = buffer.getBuffer(model.renderType(TEXTURE));
        model.renderToBuffer(poseStack, vertexConsumer, light, overlay, 1, 1, 1, 1);

        poseStack.popPose();
    }
}