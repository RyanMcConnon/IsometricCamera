package com.ryanpm96.freecamera;

import com.ryanpm96.freecamera.event.ClientEventHandler;
import com.ryanpm96.freecamera.init.InitKeyBindings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FreeCamera.MODID)
public class FreeCamera
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "freecamera";

    public FreeCamera() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::clientSetup);
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event){
        InitKeyBindings.registerKeyBindings();
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onCameraSetup);
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onRenderHand);
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::preRenderGameOverlay);
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onRenderPlayer);
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onMouseClick);
        MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onMouseScroll);
    }

}
