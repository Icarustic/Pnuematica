package net.sameer.pnuematica.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sameer.pnuematica.Pnuematica;
import net.sameer.pnuematica.item.ModCreativeModTab;
import net.sameer.pnuematica.item.Moditems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Pnuematica.MOD_ID);
//input blocks here (Below)
    public static final RegistryObject<Block> Zircon_Blocks = registerBlocks("zircon_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.Pnuematica_Tab);

    public static final RegistryObject<Block> Deepslate_Cobblestone_Blocks = registerBlocks("deepslate_cobblestone_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.Pnuematica_Tab);

    public static final RegistryObject<Block> BejeweledRecord_Block = registerBlocks("bejeweledrecord_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.PISTON)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.Pnuematica_Tab);

    public static final RegistryObject<Block> DecoratedBricks = registerBlocks("decoratedbricks_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.Pnuematica_Tab);

    public static final RegistryObject<Block> Green_TicketSiding = registerBlocks("greenticketsiding_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModTab.Pnuematica_Tab);





    //strength is how long it takes to break
    private static <T extends Block> RegistryObject<T> registerBlocks(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = Blocks.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return Moditems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        Blocks.register(eventBus);
    }
}
