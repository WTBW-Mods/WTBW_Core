package com.wtbw.mods.tools.mods.core.gui.screen;

import com.wtbw.mods.tools.mods.core.WTBWCore;
import com.wtbw.mods.tools.mods.core.gui.container.TrashCanContainer;
import com.wtbw.mods.lib.gui.screen.BaseContainerScreen;
import com.wtbw.mods.lib.gui.util.GuiUtil;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

/*
  @author: Naxanria
*/
public class TrashCanScreen extends BaseContainerScreen<TrashCanContainer>
{
  public static final ResourceLocation GUI = new ResourceLocation(WTBWCore.MODID, "textures/gui/trashcan.png");
  
  public TrashCanScreen(TrashCanContainer container, PlayerInventory inventory, ITextComponent title)
  {
    super(container, inventory, title);
  }
  
  @Override
  protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
  {
    GuiUtil.renderTexture(guiLeft, guiTop, xSize, ySize, 0, 0, 256, 256, GUI);
  }
}
