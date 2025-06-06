package net.sameer.pnuematica;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sameer.pnuematica.block.ModBlocks;
import net.sameer.pnuematica.item.Moditems;
import org.slf4j.Logger;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file

@Mod(Pnuematica.MOD_ID)
public class Pnuematica {
    public static final String MOD_ID = "pnuematica";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Pnuematica() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Moditems.register(modEventBus);

        ModBlocks.register(modEventBus);


        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents  {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)  {

        }
    }
}
