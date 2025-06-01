package net.sameer.pnuematica.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class KeybindWerewolf {
    public static final String CATEGORY = "key.categories.pnuematica";
    public static final KeyMapping TOGGLE_WEREWOLF = new KeyMapping(
            "key.pnuematica.toggle_werewolf",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            CATEGORY
    );

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        net.minecraft.client.Minecraft.getInstance().options.keyMappings =
                java.util.Arrays.copyOf(Minecraft.getInstance().options.keyMappings,
                        Minecraft.getInstance().options.keyMappings.length + 1);
        Minecraft.getInstance().options.keyMappings[Minecraft.getInstance().options.keyMappings.length - 1] = TOGGLE_WEREWOLF;
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (TOGGLE_WEREWOLF.isDown() && Minecraft.getInstance().player != null) {
            WerewolfState.toggle(Minecraft.getInstance().player);
        }
    }
}