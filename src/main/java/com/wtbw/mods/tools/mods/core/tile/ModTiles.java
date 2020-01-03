package com.wtbw.mods.tools.mods.core.tile;

import com.wtbw.mods.tools.mods.core.WTBWCore;
import com.wtbw.mods.tools.mods.core.tile.trashcan.EnergyTrashCanTileEntity;
import com.wtbw.mods.tools.mods.core.tile.trashcan.FluidTrashCanTileEntity;
import com.wtbw.mods.tools.mods.core.tile.trashcan.TrashCanTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

/*
  @author: Naxanria
*/
@ObjectHolder(WTBWCore.MODID)
public class ModTiles
{
  public static final TileEntityType<TrashCanTileEntity> TRASHCAN = null;
  public static final TileEntityType<FluidTrashCanTileEntity> FLUID_TRASHCAN = null;
  public static final TileEntityType<EnergyTrashCanTileEntity> ENERGY_TRASHCAN = null;
}
