package com.wtbw.mods.core;

//import com.wtbw.mods.core.config.CoreClientConfig;
import com.wtbw.mods.core.config.CoreClientConfig;
import com.wtbw.mods.lib.util.Utilities;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
          TranslationTextComponent component = new TranslationTextComponent("wtbw_core.tooltip.burntime", burnTime);
          component.func_230530_a_(component.getStyle().func_240712_a_(TextFormatting.WHITE));
          toolTip.add(index, component);
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
        if (!config.showTagsRequireShift.get() || Screen.func_231173_s_())
        {
          Style style = Style.field_240709_b_.func_240712_a_(TextFormatting.DARK_GRAY);
  
          Item item = stack.getItem();
          Set<ResourceLocation> itemTags = item.getTags();
          if (itemTags.size() > 0)
          {
            toolTip.add(new StringTextComponent("ItemTags").func_230530_a_(style));
            for (ResourceLocation location : itemTags)
            {
              toolTip.add(new StringTextComponent("#" + location.toString()).func_230530_a_(style));
            }
          }
          if (item instanceof BlockItem)
          {
            Set<ResourceLocation> blockTags = ((BlockItem) item).getBlock().getTags();
            if (blockTags.size() > 0)
            {
              toolTip.add(new StringTextComponent("BlockTags:").func_230530_a_(style));
              for (ResourceLocation location : blockTags)
              {
                toolTip.add(new StringTextComponent("#" + location.toString()).func_230530_a_(style));
              }
            }
          }
        }
      }
    }
  }
}
