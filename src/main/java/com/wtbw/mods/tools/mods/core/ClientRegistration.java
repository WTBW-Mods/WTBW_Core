package com.wtbw.mods.tools.mods.core;

import com.wtbw.mods.tools.mods.core.gui.container.ModContainers;
import net.minecraft.client.gui.ScreenManager;
import com.wtbw.mods.tools.mods.core.gui.screen.TrashCanScreen;

/*
  @author: Naxanria
*/
public class ClientRegistration
{
  public static void init()
  {
    ScreenManager.registerFactory(ModContainers.TRASHCAN, TrashCanScreen::new);
  }
}
