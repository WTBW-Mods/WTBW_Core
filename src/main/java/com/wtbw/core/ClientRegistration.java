package com.wtbw.core;

import com.wtbw.core.gui.container.ModContainers;
import net.minecraft.client.gui.ScreenManager;
import com.wtbw.core.gui.screen.TrashCanScreen;

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
