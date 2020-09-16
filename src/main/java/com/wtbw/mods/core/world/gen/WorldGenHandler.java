//package com.wtbw.mods.core.world.gen;
//
//import com.wtbw.mods.core.WTBWCore;
//import com.wtbw.mods.core.config.CoreCommonConfig;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.DefaultBiomeFeatures;
//import net.minecraft.world.gen.GenerationStage;
//import net.minecraft.world.gen.feature.ConfiguredFeature;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.OreFeatureConfig;
//
//import net.minecraft.world.gen.placement.Placement;
//import net.minecraftforge.event.world.BiomeLoadingEvent;
//import net.minecraftforge.registries.ForgeRegistries;
//
///*
//  @author: Naxanria
//*/
//public class WorldGenHandler
//{
//  private static ConfiguredFeature<?, ?> copperFeature;
//  private static ConfiguredFeature<?, ?> cobaltFeature;
//
//  public static void setupWorldGen(final BiomeLoadingEvent event)
//  {
//    if (copperFeature == null && CoreCommonConfig.COPPER.isOreEnabled())
//    {
//      copperFeature = getOreFeature(CoreCommonConfig.COPPER, Feature.ORE);
//    }
//
//    if (cobaltFeature == null && CoreCommonConfig.COBALT.isOreEnabled())
//    {
//      cobaltFeature = getOreFeature(CoreCommonConfig.COBALT, Feature.ORE);
//    }
//
//    if (isOverworld(event.getCategory()))
//    {
//      event.getGeneration().func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, copperFeature);
//    }
//    else if (isNether(event.getCategory()))
//    {
//      event.getGeneration().func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, cobaltFeature);
//    }
//  }
//
//  public static boolean isOverworld(Biome.Category category)
//  {
//    return category != Biome.Category.NETHER && category != Biome.Category.THEEND;
//  }
//
//  public static boolean isTheEnd(Biome.Category category)
//  {
//    return category == Biome.Category.THEEND;
//  }
//
//  public static boolean isNether(Biome.Category category)
//  {
//    return category == Biome.Category.NETHER;
//  }
//
//  private static ConfiguredFeature<?, ?> getOreFeature(CoreCommonConfig.OreConfig config, Feature<OreFeatureConfig> feature)
//  {
//    OreBlockProvider provider = config.getProvider();
//
//    if (config.isOreEnabled())
//    {
//      WTBWCore.LOGGER.info("Creating ore config {} max: {} bottom: {} top: {}", provider.getBlock().getRegistryName().toString(), config.getMaxHeight(), config.getBottomOffset(), config.getTopOffset());
//
//      return feature.withConfiguration(new OreFeatureConfig(provider.getFillerBlockType(), provider.getBlock().getDefaultState(), config.maxVeinSize()))
//        .func_242733_d(config.getMaxHeight()).func_242728_a().func_242731_b(config.getPerChunk());
//    }
//
//    return null;
//  }
//}
