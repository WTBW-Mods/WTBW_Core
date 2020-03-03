package com.wtbw.mods.core;

import com.wtbw.mods.core.block.TrashCanBlock;
import com.wtbw.mods.core.block.WTBWCoreBlocks;
import com.wtbw.mods.core.gui.container.TrashCanContainer;
import com.wtbw.mods.core.item.EnderPouchItem;
import com.wtbw.mods.core.tile.trashcan.EnergyTrashCanTileEntity;
import com.wtbw.mods.core.tile.trashcan.FluidTrashCanTileEntity;
import com.wtbw.mods.core.tile.trashcan.TrashCanTileEntity;
import com.wtbw.mods.lib.Registrator;
import com.wtbw.mods.lib.item.BaseBlockItem;
import com.wtbw.mods.lib.item.BaseItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.common.ToolType;

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
    
    register(new Block(getBlockProperties(Material.ROCK, 1.5f, 6).harvestTool(ToolType.PICKAXE)), "copper_ore");
    register(new Block(getBlockProperties(Material.ROCK, 25f, 25).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.DIAMOND.getHarvestLevel())), "cobalt_ore");
    
    register(new Block(getBlockProperties(Material.ROCK, 2, 6).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.IRON.getHarvestLevel())), "copper_block");
    register(new Block(getBlockProperties(Material.ROCK, 2, 6).harvestTool(ToolType.PICKAXE).harvestLevel(ItemTier.DIAMOND.getHarvestLevel())), "cobalt_block");
    
    register(new TrashCanBlock<>(getBlockProperties(Material.ROCK, 4), (world, state) -> new TrashCanTileEntity()), "trashcan");
    register(new TrashCanBlock<>(getBlockProperties(Material.ROCK, 4), (world, state) -> new FluidTrashCanTileEntity()), "fluid_trashcan");
    register(new TrashCanBlock<>(getBlockProperties(Material.ROCK, 4), (world, state) -> new EnergyTrashCanTileEntity()), "energy_trashcan");
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
    
    register(new Item(getItemProperties()), "copper_ingot");
    register(new Item(getItemProperties()), "cobalt_ingot");
    
  }
  
//  @Override
//  protected void registerAllTiles()
//  {
//    register(WTBWCoreBlocks.TRASHCAN);
//    register(WTBWCoreBlocks.ENERGY_TRASHCAN);
//    register(WTBWCoreBlocks.FLUID_TRASHCAN);
//  }
  
  @Override
  protected void registerAllContainers()
  {
    registerContainer(TrashCanContainer::new, "trashcan");
  }
}
