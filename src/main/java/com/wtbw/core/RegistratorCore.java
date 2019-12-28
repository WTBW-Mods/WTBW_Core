package com.wtbw.core;

import com.wtbw.core.block.WTBWCoreBlocks;
import com.wtbw.core.item.EnderPouchItem;
import com.wtbw.lib.Registrator;
import com.wtbw.lib.item.BaseBlockItem;
import com.wtbw.lib.item.BaseItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

/*
  @author: Naxanria
*/
public class RegistratorCore extends Registrator
{
  public RegistratorCore(ItemGroup group, String modid)
  {
    super(group, modid);
  }
  
  @Override
  protected void registerAllBlocks()
  {
    register(new Block(getBlockProperties(Material.ROCK, 5, 6)), "charcoal_block", false);
    register(new Block(getBlockProperties(Material.ROCK, 5, 6)), "blaze_block", false);
    register(new Block(getBlockProperties(Material.ROCK, 10)), "groundium");
  }
  
  @Override
  protected void registerAllItems()
  {
    register(new BaseItem(getItemProperties().setBurnTime(200)), "tiny_coal");
    register(new BaseItem(getItemProperties().setBurnTime(200)), "tiny_charcoal");
    register(new BaseBlockItem(WTBWCoreBlocks.CHARCOAL_BLOCK, getItemProperties().setBurnTime(14400)), "charcoal_block");
    register(new BaseBlockItem(WTBWCoreBlocks.BLAZE_BLOCK, getItemProperties().setBurnTime(21600)), "blaze_block");
  
    register(new Item(getItemProperties().maxStackSize(8)), "ender_core");
    
    register(new EnderPouchItem(getItemProperties().maxStackSize(1)), "ender_pouch");
  }
  
  @Override
  protected void registerAllTiles()
  { }
  
  @Override
  protected void registerAllContainers()
  { }
}
