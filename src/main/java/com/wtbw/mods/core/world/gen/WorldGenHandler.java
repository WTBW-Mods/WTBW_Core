package com.wtbw.mods.core.world.gen;

import com.wtbw.mods.core.WTBWCore;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/*
  @author: Naxanria
*/
public class WorldGenHandler
{
  private static ConfiguredFeature<?, ?> copperFeature;
  private static ConfiguredFeature<?, ?> cobaltFeatureLow;
  private static ConfiguredFeature<?, ?> cobaltFeatureHigh;
  
  public static void setupWorldGen()
  {
    copperFeature = getOreFeature(OreConfig.COPPER, Feature.ORE);
    cobaltFeatureLow = getOreFeature(OreConfig.COBALT_LOW, Feature.ORE);
    cobaltFeatureHigh = getOreFeature(OreConfig.COBALT_HIGH, Feature.ORE);
  
    ForgeRegistries.BIOMES.forEach(biome ->
    {
      if (isBiomeValid(biome, false))
      {
        addFeature(biome, copperFeature);
      }
      if (isBiomeValid(biome, true))
      {
        addFeature(biome, cobaltFeatureLow);
        addFeature(biome, cobaltFeatureHigh);
      }
    });
  
    System.out.println("Setup ore gen");
  }
  
  
  private static boolean isBiomeValid(Biome biome, boolean nether)
  {
    if (nether)
    {
      return biome.getCategory() == Biome.Category.NETHER;
    }
    
    return biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NETHER;
  }
  
  private static ConfiguredFeature<?, ?> getOreFeature(OreConfig config, Feature<OreFeatureConfig> feature)
  {
    OreBlockProvider provider = config.provider;
    
    if (config.isOreEnabled())
    {
      return feature.func_225566_b_(new OreFeatureConfig(provider.getFillerBlockType(), provider.getBlock().getDefaultState(), config.maxVeinSize()))
        .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(
          new CountRangeConfig(config.getPerChunk(), config.getBottomOffset(), config.getTopOffset(), config.getMaxHeight())
        ));
    }
    
    return null;
  }
  
  private static void addFeature(Biome biome, ConfiguredFeature<?, ?> feature)
  {
    if (feature != null)
    {
      biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, feature);
    }
  }
}
