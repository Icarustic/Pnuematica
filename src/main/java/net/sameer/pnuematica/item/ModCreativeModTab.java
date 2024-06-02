package net.sameer.pnuematica.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab Pnuematica_Tab = new CreativeModeTab("pnuematicatab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Moditems.Wrist_Gear.get());
        }
    };
}
// duplicatable for another item tab.