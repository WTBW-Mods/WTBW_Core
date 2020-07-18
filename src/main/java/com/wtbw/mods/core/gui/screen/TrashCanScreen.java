package com.wtbw.mods.core.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.wtbw.mods.core.WTBWCore;
import com.wtbw.mods.core.gui.container.TrashCanContainer;
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
  protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_)
  {
    GuiUtil.renderTexture(guiLeft, guiTop, xSize, ySize, 0, 0, 256, 256, GUI);
  }
}
