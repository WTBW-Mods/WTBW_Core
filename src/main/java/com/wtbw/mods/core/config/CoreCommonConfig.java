package com.wtbw.mods.core.config;

import com.wtbw.mods.core.WTBWCore;
import com.wtbw.mods.core.block.WTBWCoreBlocks;
import com.wtbw.mods.lib.config.BaseConfig;
import com.wtbw.mods.lib.world.generation.OreBlockProvider;
import com.wtbw.mods.lib.world.generation.WorldGenManager;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

/*
  @author: Naxanria
*/
public class CoreCommonConfig extends BaseConfig
{
  private static CoreCommonConfig instance;
  
  public static CoreCommonConfig getConfig()
  {
    return instance;
  }
  
  public static OreConfig COBALT;
  public static OreConfig GROUNDIUM;
  public static OreConfig COPPER;
  
  public static void init()
  {
    final Pair<CoreCommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CoreCommonConfig::new);
    instance = specPair.getLeft();
    
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, specPair.getRight());
  }
  
  public CoreCommonConfig(ForgeConfigSpec.Builder builder)
  {
    super(WTBWCore.MODID, builder);
    instance = this;
    
    push("oreGen");
    COPPER = new OreConfig(builder, "copper", OreConfig.copper_provider, 12, 10, 24, 64);
    GROUNDIUM = new OreConfig(builder, "groundium", OreConfig.groundium_provider, 32, 3, 8, 32);
    COBALT = new OreConfig(builder, "cobalt", OreConfig.cobalt_provider, 8, 6, 12, 127);
  
    WorldGenManager.registerOregen(() -> COPPER);
    WorldGenManager.registerOregen(() -> GROUNDIUM);
    WorldGenManager.registerOregen(() -> COBALT);
    
    pop();
  }
  
  public static class OreConfig extends com.wtbw.mods.lib.world.generation.OreConfig
  {
    static final OreBlockProvider copper_provider = new OreBlockProvider(() -> WTBWCoreBlocks.COPPER_ORE, OreFeatureConfig.FillerBlockType.field_241882_a, OreBlockProvider.Validators.OVERWORLD);
    static final OreBlockProvider groundium_provider = new OreBlockProvider(() -> WTBWCoreBlocks.GROUNDIUM, OreFeatureConfig.FillerBlockType.field_241882_a, OreBlockProvider.Validators.OVERWORLD);
    static final OreBlockProvider cobalt_provider = new OreBlockProvider(() -> WTBWCoreBlocks.COBALT_ORE, OreFeatureConfig.FillerBlockType.field_241883_b, OreBlockProvider.Validators.NETHER);
  
    public OreConfig(ForgeConfigSpec.Builder builder, String name, com.wtbw.mods.lib.world.generation.OreBlockProvider provider, int maxVein, int perChunk, int start, int end)
    {
      super(builder, name, provider, maxVein, perChunk, start, end, "oregen");
    }

  }
}
