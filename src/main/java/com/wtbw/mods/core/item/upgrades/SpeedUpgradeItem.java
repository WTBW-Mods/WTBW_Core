package com.wtbw.mods.core.item.upgrades;

import com.wtbw.mods.lib.upgrade.ModifierType;
import net.minecraft.util.Util;

import java.util.HashMap;
import java.util.Map;

/*
  @author: Naxanria
*/
public class SpeedUpgradeItem extends BaseUpgradeItem
{
  public SpeedUpgradeItem(Properties properties)
  {
    super(properties, 2, Util.make(new HashMap<>(), map ->
    {
      map.put(ModifierType.SPEED, 1.1f);
      map.put(ModifierType.POWER_USAGE, 1.05f);
    }));
  }
}
