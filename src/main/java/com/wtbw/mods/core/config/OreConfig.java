//package com.wtbw.mods.core.config;
//
//import com.wtbw.mods.core.block.WTBWCoreBlocks;
//import com.wtbw.mods.core.world.gen.OreBlockProvider;
//import net.minecraft.world.gen.feature.OreFeatureConfig;
//import net.minecraftforge.common.ForgeConfigSpec;
//
///*
//  @author: Naxanria
//*/
//public class OreConfig
//{
//  private static final OreBlockProvider copper_provider = new OreBlockProvider(WTBWCoreBlocks.COPPER_ORE, OreFeatureConfig.FillerBlockType.NATURAL_STONE);
//  private static final OreBlockProvider cobalt_provider = new OreBlockProvider(WTBWCoreBlocks.COBALT_ORE, OreFeatureConfig.FillerBlockType.NETHERRACK);
//
//  public static final OreConfig COBALT_LOW = new OreConfig(cobalt_provider, 5, 1, 0, 0, 40);
//  public static final OreConfig COBALT_HIGH = new OreConfig(cobalt_provider, 4, 2, 87, 0, 40);
//  public static final OreConfig COPPER = new OreConfig(copper_provider, 6, 3, 24, 24, 40);
//
//  private final OreBlockProvider provider;
////  private boolean enabled = true;
//
//  private ForgeConfigSpec.BooleanValue enabled;
//  private ForgeConfigSpec.IntValue maxVein;
//  private ForgeConfigSpec.IntValue perChunk;
//  private ForgeConfigSpec.IntValue start;
//  private ForgeConfigSpec.IntValue end;
////  private int maxVein;
////  private int perChunk;
////  private int bottomOffset;
////  private int topOffset;
////  private int maxHeight;
//
//  public OreConfig(OreBlockProvider provider, int maxVein, int perChunk, int bottomOffset, int topOffset, int maxHeight)
//  {
//    this.provider = provider;
//    this.maxVein = maxVein;
//    this.perChunk = perChunk;
//    this.bottomOffset = bottomOffset;
//    this.topOffset = topOffset;
//    this.maxHeight = maxHeight;
//  }
//
//  public boolean isOreEnabled()
//  {
//    return enabled;
//  }
//
//  public int maxVeinSize()
//  {
//    return maxVein;
//  }
//
//  public int getPerChunk()
//  {
//    return perChunk;
//  }
//
//  public int getBottomOffset()
//  {
//    return bottomOffset;
//  }
//
//  public int getTopOffset()
//  {
//    return topOffset;
//  }
//
//  public int getMaxHeight()
//  {
//    return maxHeight;
//  }
//
//  public OreBlockProvider getProvider()
//  {
//    return provider;
//  }
//}
