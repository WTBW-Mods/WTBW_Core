package com.wtbw.core;

import com.wtbw.core.config.CoreClientConfig;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

/*
  @author: Naxanria
*/
@SuppressWarnings("Convert2MethodRef")
@Mod(WTBWCore.MODID)
public class WTBWCore
{
  public static final String MODID = "wtbw_core";
  
  private RegistratorCore registrator;
  
  public static final ItemGroup GROUP = new ItemGroup("wtbw")
  {
    @Override
    public ItemStack createIcon()
    {
      return new ItemStack(Items.IRON_INGOT);
    }
  };
  
  public WTBWCore()
  {
    registrator = new RegistratorCore(GROUP, MODID);
    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> clientSetup());
  }
  
  private void clientSetup()
  {
    MinecraftForge.EVENT_BUS.addListener(ClientEventHandler::onTooltip);
    CoreClientConfig.init();
    ClientRegistration.init();
  }
}
