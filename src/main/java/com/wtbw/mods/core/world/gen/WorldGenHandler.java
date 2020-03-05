package com.wtbw.mods.core.world.gen;

import com.wtbw.mods.core.WTBWCore;
import com.wtbw.mods.core.config.CoreCommonConfig;
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
  private static ConfiguredFeature<?, ?> cobaltFeature;
  
  
  public static void setupWorldGen()
  {
    copperFeature = getOreFeature(CoreCommonConfig.COPPER, Feature.ORE);
    cobaltFeature = getOreFeature(CoreCommonConfig.COBALT, Feature.ORE);

  
    ForgeRegistries.BIOMES.forEach(biome ->
    {
      if (CoreCommonConfig.COPPER.isOreEnabled())
      {
        if (isBiomeValid(biome, false))
        {
          addFeature(biome, copperFeature);
        }
      }
      if (CoreCommonConfig.COBALT.isOreEnabled())
      {
        if (isBiomeValid(biome, true))
        {
          addFeature(biome, cobaltFeature);
        }
      }
    });
  }
  
  
  private static boolean isBiomeValid(Biome biome, boolean nether)
  {
    if (nether)
    {
      return biome.getCategory() == Biome.Category.NETHER;
    }
    
    return biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NETHER;
  }
  
  private static ConfiguredFeature<?, ?> getOreFeature(CoreCommonConfig.OreConfig config, Feature<OreFeatureConfig> feature)
  {
    OreBlockProvider provider = config.getProvider();
    
    if (config.isOreEnabled())
    {
      WTBWCore.LOGGER.info("Creating ore config {} max: {} bottom: {} top: {}", provider.getBlock().getRegistryName().toString(), config.getMaxHeight(), config.getBottomOffset(), config.getTopOffset());
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
