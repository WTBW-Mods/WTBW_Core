package com.wtbw.mods.core.config;

import com.wtbw.mods.core.WTBWCore;
import com.wtbw.mods.lib.config.BaseConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

/*
  @author: Naxanria
*/
public class CoreClientConfig extends BaseConfig
{
  private static CoreClientConfig instance;
  
  public static CoreClientConfig getConfig()
  {
    return instance;
  }
  
  public ForgeConfigSpec.BooleanValue showFullDurabilityOfTools;
  public ForgeConfigSpec.BooleanValue showTags;
  public ForgeConfigSpec.BooleanValue showTagsRequireShift;
  public ForgeConfigSpec.BooleanValue showBurnTime;
  
  public static void init()
  {
    final Pair<CoreClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CoreClientConfig::new);
    instance = specPair.getLeft();
  
    ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, specPair.getRight());
  }
  
  public CoreClientConfig(ForgeConfigSpec.Builder builder)
  {
    super(WTBWCore.MODID, builder);
    
    push("qol").push("tooltip").comment("Quality of life options");
  
    showFullDurabilityOfTools = builder
      .comment("Shows durability in the tooltip even if tools have full durability")
      .translation(key("qol.show_full_durability"))
      .define("show_full_durability", true);
  
    showTags = builder
      .comment("Show the tags of an item")
      .translation(key("qol.show_tags"))
      .define("show_tags", true);
  
    showTagsRequireShift = builder
      .comment("Require shift to show tags")
      .translation(key("qol.show_tags_shift"))
      .define("show_tags_shift", true);
  
    showBurnTime = builder
      .comment("Shows the burn time of the item, in ticks")
      .translation(key("qol.show_burn_time"))
      .define("burn_time", true);
  
    pop();
  }

}
