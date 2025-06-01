package net.sameer.pnuematica.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

public class AdultsasukeswordItem extends SwordItem {
    public AdultsasukeswordItem() {
        super(Tiers.DIAMOND, 3, -2.4F, new Item.Properties().stacksTo(1));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private BlockEntityWithoutLevelRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null) {
                    renderer = new net.sameer.pnuematica.client.AdultsasukeswordItemRenderer();
                }
                return renderer;
            }
        });
    }
}