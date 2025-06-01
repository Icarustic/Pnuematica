package net.sameer.pnuematica.item.custom;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class MonadsLampItem extends Item {
    private int healingAmount;
    private int hitsToHeal;
    private int maxDurability; // Custom maximum durability
    private int maxHealingAmount; // Maximum healing amount

    public MonadsLampItem(Properties properties, int healingAmount, int hitsToHeal, int maxDurability, int maxHealingAmount) {
        super(properties.stacksTo(1));
        this.healingAmount = healingAmount;
        this.hitsToHeal = hitsToHeal;
        this.maxDurability = maxDurability;
        this.maxHealingAmount = maxHealingAmount;
    }

    public MonadsLampItem(Properties properties) {
        this(properties, 4, 5, 100, 20); // Default max durability of 100, heal 4 hearts every 5 hits, with a maximum healing amount of 20 hearts
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        if (attacker instanceof Player) {
            Player player = (Player) attacker;
            if (!player.level.isClientSide) {
                int hits = player.getPersistentData().getInt("monads_hits") + 1;
                player.getPersistentData().putInt("monads_hits", hits);
            }
        }
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, net.minecraft.world.entity.Entity entity, int itemSlot, boolean isSelected) {
        if (isSelected && entity instanceof net.minecraft.world.entity.player.Player) {
            // Apply night vision effect when the item is held
            net.minecraft.world.entity.player.Player player = (net.minecraft.world.entity.player.Player) entity;
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0, true, false));
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player user, @NotNull InteractionHand hand) {
        ItemStack stack = user.getItemInHand(hand);
        if (!world.isClientSide) {
            int hits = user.getPersistentData().getInt("monads_hits");
            int healing = (hits / hitsToHeal) * healingAmount;
            user.heal(Math.min(healing, maxHealingAmount - user.getHealth()));
            user.getPersistentData().putInt("monads_hits", 0);
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return maxDurability; // Set the custom maximum durability
    }

}