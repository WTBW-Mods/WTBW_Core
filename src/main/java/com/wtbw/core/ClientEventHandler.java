package com.wtbw.core;

//import com.wtbw.core.config.CoreClientConfig;
import com.wtbw.core.config.CoreClientConfig;
import com.wtbw.lib.util.Utilities;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import java.util.List;
import java.util.Set;

/*
  @author: Naxanria
*/
public class ClientEventHandler
{
  private static Style white = new Style().setColor(TextFormatting.WHITE);
  private static Style darkGrey = new Style().setColor(TextFormatting.DARK_GRAY);

  public static void onTooltip(final ItemTooltipEvent event)
  {
    CoreClientConfig config = CoreClientConfig.getConfig();
  
    ItemStack stack = event.getItemStack();
    List<ITextComponent> toolTip = event.getToolTip();

    if (event.getFlags().isAdvanced())
    {
      if (config.showBurnTime.get())
      {
        int burnTime = Utilities.getBurnTime(stack);
        if (burnTime > 0)
        {
          int index = toolTip.size() - 1;
          toolTip.add(index, new TranslationTextComponent("wtbw_core.tooltip.burntime", burnTime).setStyle(darkGrey));
        }
      }

      if (config.showFullDurabilityOfTools.get())
      {
        int max = stack.getMaxDamage();
        if (max > 0 && !stack.isDamaged())
        {
          int index = toolTip.size() - 1;
          toolTip.add(index, new TranslationTextComponent("item.durability", max, max));
        }
      }

      if (config.showTags.get())
      {
        if (!config.showTagsRequireShift.get() || Screen.hasShiftDown())
        {
          Set<ResourceLocation> tags = stack.getItem().getTags();
          for (ResourceLocation location : tags)
          {
            toolTip.add(new StringTextComponent("#" + location.toString()).setStyle(darkGrey));
          }
        }
      }
    }
  }
}
