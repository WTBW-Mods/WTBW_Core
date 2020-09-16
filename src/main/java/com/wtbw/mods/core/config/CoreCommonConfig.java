package com.wtbw.mods.core.config;

import com.wtbw.mods.core.WTBWCore;
import com.wtbw.mods.core.block.WTBWCoreBlocks;

import com.wtbw.mods.lib.config.BaseConfig;
import com.wtbw.mods.lib.world.generation.OreBlockProvider;
import com.wtbw.mods.lib.world.generation.OreConfig;
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
    COPPER = new OreConfig(builder, "copper", OreConfig.copper_provider, 12, 12, 24, 64);
    COBALT = new OreConfig(builder, "cobalt", OreConfig.cobalt_provider, 8, 6, 12, 127);
  
    WorldGenManager.registerOregen(() -> COPPER);
    WorldGenManager.registerOregen(() -> COBALT);
    
    pop();
  }
  
  public static class OreConfig extends com.wtbw.mods.lib.world.generation.OreConfig
  {
    static final OreBlockProvider copper_provider = new OreBlockProvider(() -> WTBWCoreBlocks.COPPER_ORE, OreFeatureConfig.FillerBlockType.field_241882_a, OreBlockProvider.Validators.OVERWORLD);
    static final OreBlockProvider cobalt_provider = new OreBlockProvider(() -> WTBWCoreBlocks.COBALT_ORE, OreFeatureConfig.FillerBlockType.field_241883_b, OreBlockProvider.Validators.NETHER);
  
    public OreConfig(ForgeConfigSpec.Builder builder, String name, com.wtbw.mods.lib.world.generation.OreBlockProvider provider, int maxVein, int perChunk, int start, int end)
    {
      super(builder, name, provider, maxVein, perChunk, start, end, "oregen");
    }

//    private final OreBlockProvider provider;
//
//    private final String name;
//    private ForgeConfigSpec.BooleanValue enabled;
//    private ForgeConfigSpec.IntValue maxVein;
//    private ForgeConfigSpec.IntValue perChunk;
//    private ForgeConfigSpec.IntValue start;
//    private ForgeConfigSpec.IntValue end;
//
//    public OreConfig(String name, OreBlockProvider provider, int maxVein, int perChunk, int start, int end)
//    {
//      this.name = name;
//
//      this.provider = provider;
//      ForgeConfigSpec.Builder builder = instance.builder;
//      instance.push(name);
//
//      this.maxVein = builder
//        .comment("Max size of vein", "Default: " + maxVein)
//        .translation(key("max_vein"))
//        .defineInRange("maxVein", maxVein, 1, 256);
//
//      this.perChunk = builder
//        .comment("Veins per chunk", "Default: " + perChunk)
//        .translation(key("per_chunk"))
//        .defineInRange("perChunk", perChunk, 1, 256);
//
//      this.start = builder
//        .comment("Start height of veins", "Default: " + start)
//        .translation(key("start"))
//        .defineInRange("start", start, 0, 256);
//
//      this.end = builder
//        .comment("End height of veins", "Default: " + end)
//        .translation(key("end"))
//        .defineInRange("end", end, 0, 256);
//
//      this.enabled = builder
//        .comment("Is this oregen option enabled")
//        .translation(key("enabled"))
//        .define("enabled", true);
//
//      instance.pop();
//    }
//
//    private String key(String key)
//    {
//      return instance.key("oregen." + name + "." + key);
//    }
//
//    public boolean isOreEnabled()
//    {
//      return enabled.get();
//    }
//
//    public int maxVeinSize()
//    {
//      return maxVein.get();
//    }
//
//    public int getPerChunk()
//    {
//      return perChunk.get();
//    }
//
//    public int getBottomOffset()
//    {
//      return start.get();
//    }
//
//    public int getTopOffset()
//    {
//      return start.get();
//    }
//
//    public int getMaxHeight()
//    {
//      return end.get() + 1;
//    }
//
//    public OreBlockProvider getProvider()
//    {
//      return provider;
//    }
  }
}
