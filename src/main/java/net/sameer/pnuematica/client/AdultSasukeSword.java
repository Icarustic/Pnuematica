package net.sameer.pnuematica.client;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class AdultSasukeSword<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "adultsasukesword"), "main");
	private final ModelPart bone;
	private final ModelPart bb_main;

	public AdultSasukeSword(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-0.3952F, 3.0F, 2.4396F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(46, 21).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1585F, 5.9077F, -5.4856F, 1.0394F, 0.5844F, 1.2572F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(40, 4).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0721F, 5.9077F, -4.0681F, 0.2095F, 0.1582F, 0.933F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(40, 8).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0721F, 5.9077F, -1.8111F, -0.2095F, -0.1582F, 0.933F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(46, 24).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1585F, 5.9077F, -0.3935F, -1.0394F, -0.5844F, 1.2572F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(26, 46).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3682F, 5.9077F, -5.4856F, 1.0394F, -0.5844F, -1.2572F));

		PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(20, 42).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2818F, 5.9077F, -1.8111F, -0.2095F, 0.1582F, -0.933F));

		PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(46, 27).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3682F, 5.9077F, -0.3935F, -1.0394F, 0.5844F, -1.2572F));

		PartDefinition cube_r8 = bone.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(28, 42).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2818F, 5.9077F, -4.0681F, 0.2095F, -0.1582F, -0.933F));

		PartDefinition cube_r9 = bone.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(38, 38).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0721F, 6.9077F, -4.0681F, 0.2095F, 0.1582F, 0.933F));

		PartDefinition cube_r10 = bone.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(46, 18).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1585F, 6.9077F, -0.3935F, -1.0394F, -0.5844F, 1.2572F));

		PartDefinition cube_r11 = bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(40, 0).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0721F, 6.9077F, -1.8111F, -0.2095F, -0.1582F, 0.933F));

		PartDefinition cube_r12 = bone.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(20, 46).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1585F, 6.9077F, -5.4856F, 1.0394F, 0.5844F, 1.2572F));

		PartDefinition cube_r13 = bone.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(38, 34).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2818F, 6.9077F, -1.8111F, -0.2095F, 0.1582F, -0.933F));

		PartDefinition cube_r14 = bone.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(46, 15).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3682F, 6.9077F, -0.3935F, -1.0394F, 0.5844F, -1.2572F));

		PartDefinition cube_r15 = bone.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(46, 12).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3682F, 6.9077F, -5.4856F, 1.0394F, -0.5844F, -1.2572F));

		PartDefinition cube_r16 = bone.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(38, 30).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2818F, 6.9077F, -4.0681F, 0.2095F, -0.1582F, -0.933F));

		PartDefinition cube_r17 = bone.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(36, 45).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 1.1345F, 0.0F));

		PartDefinition cube_r18 = bone.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(42, 45).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7903F, 7.0F, 0.0F, 0.0F, -1.1345F, 0.0F));

		PartDefinition cube_r19 = bone.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(38, 26).addBox(1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1704F, 8.0F, -6.1467F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r20 = bone.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(38, 18).addBox(-2.0F, -2.0F, -4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6199F, 8.0F, 0.2675F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r21 = bone.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(38, 22).addBox(-2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6199F, 8.0F, -6.1467F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r22 = bone.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(36, 42).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4531F, 6.5F, -5.6679F, 0.0F, -1.1345F, 0.0F));

		PartDefinition cube_r23 = bone.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(42, 42).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7903F, 7.0F, -5.8792F, 0.0F, 1.1345F, 0.0F));

		PartDefinition cube_r24 = bone.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(38, 14).addBox(1.0F, -2.0F, -4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1704F, 8.0F, 0.2675F, 0.0F, -0.2618F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, -15.0F, -3.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-0.5F, -91.0F, 1.0F, 1.0F, 74.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(20, 8).addBox(-1.0F, -18.0F, -3.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 29).addBox(0.0F, -12.0F, -1.5F, 1.0F, 21.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 29).addBox(-1.0F, -12.0F, -1.5F, 1.0F, 21.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -91.0F, -2.0F, 0.0F, 74.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r25 = bb_main.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(34, 7).addBox(0.0F, -1.5F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0809F, -89.4786F, -0.4207F, -0.023F, 0.173F, -0.1329F));

		PartDefinition cube_r26 = bb_main.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(34, 0).addBox(0.0F, -1.5F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0409F, -89.4786F, -0.4207F, -0.023F, -0.173F, 0.1329F));

		PartDefinition cube_r27 = bb_main.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(12, 0).addBox(0.0F, -21.5F, -0.5F, 0.0F, 70.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0649F, -65.5F, -1.4619F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r28 = bb_main.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(6, 0).addBox(0.0F, -21.5F, -0.5F, 0.0F, 70.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0669F, -65.5F, -1.4622F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r29 = bb_main.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(48, 3).addBox(-1.0F, -0.5F, -1.3F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6804F, 9.4769F, 0.8507F, -0.0945F, -0.2909F, 0.3193F));

		PartDefinition cube_r30 = bb_main.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -0.5F, -0.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6804F, 9.4769F, -1.8507F, 0.0945F, 0.2909F, 0.3193F));

		PartDefinition cube_r31 = bb_main.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(46, 39).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.517F, 8.8706F, -0.5F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cube_r32 = bb_main.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(46, 36).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.517F, 8.8706F, -0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r33 = bb_main.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(46, 33).addBox(0.0F, -0.5F, -0.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6804F, 9.4769F, -1.8507F, 0.0945F, -0.2909F, -0.3193F));

		PartDefinition cube_r34 = bb_main.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(46, 30).addBox(0.0F, -0.5F, -1.3F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6804F, 9.4769F, 0.8507F, -0.0945F, 0.2909F, -0.3193F));

		PartDefinition cube_r35 = bb_main.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(32, 29).addBox(0.0F, -11.5F, -0.7F, 1.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8238F, -0.5F, -1.8959F, 0.0F, -0.3054F, 0.0F));

		PartDefinition cube_r36 = bb_main.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(32, 16).addBox(0.0F, -11.5F, -1.3F, 1.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8238F, -0.5F, 0.8959F, 0.0F, 0.3054F, 0.0F));

		PartDefinition cube_r37 = bb_main.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(26, 16).addBox(-1.0F, -11.5F, -1.3F, 1.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8238F, -0.5F, 0.8959F, 0.0F, -0.3054F, 0.0F));

		PartDefinition cube_r38 = bb_main.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(20, 16).addBox(-1.0F, -11.5F, -0.7F, 1.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8238F, -0.5F, -1.8959F, 0.0F, 0.3054F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}