package com.wtbw.mods.core.world.gen;

import com.wtbw.mods.core.block.WTBWCoreBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.function.Supplier;

/*
  @author: Naxanria
*/
public class OreBlockProvider
{
  Supplier<Block> block;
  OreFeatureConfig.FillerBlockType fillerBlockType;
  
  public OreBlockProvider(Supplier<Block> block, OreFeatureConfig.FillerBlockType fillerBlockType)
  {
    this.block = block;
    this.fillerBlockType = fillerBlockType;
  }
  
  public Block getBlock()
  {
    return block.get();
  }
  
  public OreFeatureConfig.FillerBlockType getFillerBlockType()
  {
    return fillerBlockType;
  }
}
