package com.wtbw.mods.core.item.upgrades;

import com.wtbw.mods.core.WTBWCore;
import com.wtbw.mods.lib.upgrade.IUpgradeProvider;
import com.wtbw.mods.lib.upgrade.IUpgradeable;
import com.wtbw.mods.lib.upgrade.ModifierType;
import com.wtbw.mods.lib.upgrade.UpgradeManager;
import com.wtbw.mods.lib.util.TextComponentBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

/*
  @author: Naxanria
*/
public class BaseUpgradeItem extends Item implements IUpgradeProvider
{
  protected final Map<ModifierType, Float> modifiers;
  protected final int upgradeCost;
  
  public BaseUpgradeItem(Properties properties,int upgradeCost, Map<ModifierType, Float> modifiers)
  {
    super(properties);
  
    this.modifiers = modifiers;
    this.upgradeCost = upgradeCost;
  }
  
  @Override
  public Map<ModifierType, Float> modifierMap()
  {
    return modifiers;
  }
  
  @Override
  public int upgradeCost()
  {
    return upgradeCost;
  }
  
//  @Override
//  public ActionResultType onItemUse(ItemUseContext context)
//  {
//    World world = context.getWorld();
//
//
//    BlockPos pos = new BlockPos(context.getHitVec());
//    WTBWCore.LOGGER.info("POS: {} HIT POS: {}", context.getPos(), pos);
//
//    TileEntity te = world.getTileEntity(pos);
//    if (te instanceof IUpgradeable)
//    {
//      ItemStack stack = context.getPlayer().getHeldItem(context.getHand());
//
//      UpgradeManager manager = ((IUpgradeable) te).getUpgradeManager();
//      if (stack.getItem() == this)
//      {
//        boolean success = manager.addUpgrade(stack);
//        if (success)
//        {
//          stack.shrink(1);
//          // todo: play sound?
//
//          return ActionResultType.SUCCESS;
//        }
//        else
//        {
//          context.getPlayer().sendMessage(TextComponentBuilder.create("Failed to insert upgrade :(").build());
//        }
//      }
//    }
//
//    return super.onItemUse(context);
//  }
}
