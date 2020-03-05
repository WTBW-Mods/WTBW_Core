package com.wtbw.mods.core;

import com.wtbw.mods.core.config.CoreClientConfig;
import com.wtbw.mods.core.config.CoreCommonConfig;
import com.wtbw.mods.core.item.ModItems;
import com.wtbw.mods.core.world.gen.WorldGenHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
  @author: Naxanria
*/
@SuppressWarnings("Convert2MethodRef")
@Mod(WTBWCore.MODID)
public class WTBWCore
{
  public static final String MODID = "wtbw_core";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  
  private RegistratorCore registrator;
  
  public static final ItemGroup GROUP = new ItemGroup("wtbw")
  {
    @Override
    public ItemStack createIcon()
    {
      return new ItemStack(ModItems.ENDER_CORE);
    }
  };
  
  public WTBWCore()
  {
    registrator = new RegistratorCore(GROUP, MODID);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> clientStuff());
  
    CoreCommonConfig.init();
  }
  
  private void commonSetup(final FMLCommonSetupEvent event)
  {
    WorldGenHandler.setupWorldGen();
  }
  
  private void clientStuff()
  {
    MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onTooltip);

    CoreClientConfig.init();
  }
  
  private void clientSetup(final FMLClientSetupEvent event)
  {
    ClientRegistration.init();
  }
}
