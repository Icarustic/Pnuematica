package net.sameer.pnuematica.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sameer.pnuematica.Pnuematica;
import net.sameer.pnuematica.item.custom.*;

public class Moditems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, Pnuematica.MOD_ID);
//name "zircon" must match the same as in the en_us.json(Lang File) file and the name for the zircon.json file(Model Item Fle).
//The code below sets the name of the item/block (in this example it is Zircon). Note that for the second part it must be lowercase and no spaces.
    public static final RegistryObject<Item> Zircon = Items.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab)));
//sets the minecraft tab the item is contained in, in this example it sets it to the custom made tab for the mod.
    public static final RegistryObject<Item> Wrist_Gear = Items.register("wrist_gear",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab)));

    public static final RegistryObject<Item> Smoke_Bomb = Items.register("smoke_bomb",
            () -> new SmokeBombItem(new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab)));

    public static final RegistryObject<Item> Mech_Fan = Items.register("mech_fan",
            () -> new MechFanItem(new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab).stacksTo(1)));

    public static final RegistryObject<Item> Pocket_Watch = Items.register("pocket_watch",
            () -> new PocketWatchItem(new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab).stacksTo(1)));


    public static final RegistryObject<Item> Monads_Lamp = Items.register("monad_lamp",
            () -> new MonadsLampItem(new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab).stacksTo(1)));


    public static final RegistryObject<Item> Mech_Fan_Arrow = Items.register("mech_fan-arrow",
            () -> new MechFanArrowItem(new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab).stacksTo(1)));


    public static final RegistryObject<Item> Wall_Of_Fire_Bow = Items.register("wall_of_fire_bow",
            () -> new WallOfFireBowItem(new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab).stacksTo(1)));

    public static final RegistryObject<Item> AdultSasukeSword = Items.register("adult_sasuke_sword",
            () -> new SwordItem(Tiers.DIAMOND,6,-2.8F,new Item.Properties().tab(ModCreativeModTab.Pnuematica_Tab)));
// 6 = dmg diamond=3 and the +3 , -2.8 is speed



    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}
