package com.wtbw.core.block;

import com.wtbw.core.WTBWCore;

import com.wtbw.core.tile.trashcan.EnergyTrashCanTileEntity;
import com.wtbw.core.tile.trashcan.FluidTrashCanTileEntity;
import com.wtbw.core.tile.trashcan.TrashCanTileEntity;
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
  
  public static final TrashCanBlock<EnergyTrashCanTileEntity> ENERGY_TRASHCAN = null;
  public static final TrashCanBlock<FluidTrashCanTileEntity> FLUID_TRASHCAN = null;
  public static final TrashCanBlock<TrashCanTileEntity> TRASHCAN = null;
}
