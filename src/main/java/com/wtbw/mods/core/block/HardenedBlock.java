package com.wtbw.mods.core.block;

import com.wtbw.mods.core.WTBWCore;
import com.wtbw.mods.lib.block.util.IExplosionResistant;
import com.wtbw.mods.lib.util.TextComponentBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/*
  @author: Naxanria
*/
public class HardenedBlock extends Block implements IExplosionResistant
{
  public HardenedBlock(Properties properties)
  {
    super(properties);
  }
  
  @Override
  public boolean ticksRandomly(BlockState state)
  {
    return true;
  }
  
  @Override
  public void animateTick(BlockState state, World world, BlockPos pos, Random rand)
  {
    double x = .5;
    double y = .5;
    double z = .5;
    for (int i = 0; i < 6; i++)
    {
      if (rand.nextBoolean())
      {
        world.addParticle(ParticleTypes.SMOKE, x + (double)(rand.nextFloat() / 5.0F), (double)pos.getY() + (y - (double)rand.nextFloat()), z + (double)(rand.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
      }
    }
  }
  
  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
  {
    tooltip.add(TextComponentBuilder.createTranslated(WTBWCore.MODID + ".tooltip.wither_proof").gold().build());
    super.addInformation(stack, worldIn, tooltip, flagIn);
  }
}
