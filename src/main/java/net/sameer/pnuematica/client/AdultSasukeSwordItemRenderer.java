package net.sameer.pnuematica.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;

public class AdultSasukeSwordItemRenderer extends BlockEntityWithoutLevelRenderer {
    private final AdultSasukeSword model;
    private static final ResourceLocation TEXTURE = new ResourceLocation("pnuematica", "textures/item/adult_sasuke_sword.png");

    public AdultSasukeSwordItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        this.model = new AdultSasukeSword(Minecraft.getInstance().getEntityModels().bakeLayer(AdultSasukeSword.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType,
                             PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        poseStack.pushPose();

        // Adjust scale/rotation/translation if needed
        poseStack.scale(1.0F, 1.0F, 1.0F);

        var vertexConsumer = buffer.getBuffer(model.renderType(TEXTURE));
        model.renderToBuffer(poseStack, vertexConsumer, light, overlay, 1, 1, 1, 1);

        poseStack.popPose();
    }
}