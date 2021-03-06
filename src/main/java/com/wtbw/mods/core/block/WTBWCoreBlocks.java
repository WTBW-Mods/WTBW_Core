package com.wtbw.mods.core.block;

import com.wtbw.mods.core.WTBWCore;

import com.wtbw.mods.core.tile.trashcan.EnergyTrashCanTileEntity;
import com.wtbw.mods.core.tile.trashcan.FluidTrashCanTileEntity;
import com.wtbw.mods.core.tile.trashcan.TrashCanTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.registries.ObjectHolder;

/*
  @author: Naxanria
*/
@ObjectHolder(WTBWCore.MODID)
public class WTBWCoreBlocks
{
  public static final Block CHARCOAL_BLOCK = Blocks.AIR;
  public static final Block BLAZE_BLOCK = Blocks.AIR;
  public static final Block GROUNDIUM = Blocks.AIR;
  public static final Block REINFORCED_GROUNDIUM = Blocks.AIR;
  public static final Block STONE_TORCH = Blocks.AIR;
  
  public static final Block COPPER_ORE = Blocks.AIR;
  public static final Block COBALT_ORE = Blocks.AIR;
  
  public static final TrashCanBlock<EnergyTrashCanTileEntity> ENERGY_TRASHCAN = null;
  public static final TrashCanBlock<FluidTrashCanTileEntity> FLUID_TRASHCAN = null;
  public static final TrashCanBlock<TrashCanTileEntity> TRASHCAN = null;
}
