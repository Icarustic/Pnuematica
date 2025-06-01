package net.sameer.pnuematica.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

import java.util.function.Consumer;

public class AdultSasukeSwordItem extends SwordItem {
    public AdultSasukeSwordItem(Item.Properties properties) {
        super(Tiers.DIAMOND, 3, -2.4F, properties);
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            private BlockEntityWithoutLevelRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                if (renderer == null) {
                    renderer = new net.sameer.pnuematica.client.AdultSasukeSwordItemRenderer();
                }
                return renderer;
            }
        });
    }
}