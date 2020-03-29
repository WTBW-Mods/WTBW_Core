package com.wtbw.mods.core.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Random;

/*
  @author: Naxanria
*/
public class StoneTorchBlock extends Block
{
  public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
  public static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap
  (
    ImmutableMap.of
    (
      Direction.SOUTH, Block.makeCuboidShape(5, 4, 0, 11, 12, 3),
      Direction.EAST, Block.makeCuboidShape(0, 4, 5, 3, 12, 11),
      Direction.NORTH, Block.makeCuboidShape(5, 4, 13, 11, 12, 16),
      Direction.WEST, Block.makeCuboidShape(13, 4, 5, 16, 12, 11)
    )
  );
  
  public StoneTorchBlock(Properties properties)
  {
    super(properties);
    setDefaultState(getStateContainer().getBaseState().with(FACING, Direction.NORTH));
  }
  
  @Override
  public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos)
  {
    Direction direction = state.get(FACING);
    BlockPos blockpos = pos.offset(direction.getOpposite());
    BlockState blockstate = world.getBlockState(blockpos);
    return blockstate.isSolidSide(world, blockpos, direction);
  }
  
  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context)
  {
    BlockState blockstate = this.getDefaultState();
    IWorldReader worldReader = context.getWorld();
    BlockPos blockpos = context.getPos();
    Direction[] directions = context.getNearestLookingDirections();
  
    for (Direction direction : directions)
    {
      if (direction.getAxis().isHorizontal())
      {
//        Direction direction1 = direction.getOpposite();
        blockstate = blockstate.with(FACING, direction);
        if (blockstate.isValidPosition(worldReader, blockpos))
        {
          return blockstate;
        }
      }
    }
  
    return null;
  }
  
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
  {
    return func_220289_j(state);
  }
  
  public static VoxelShape func_220289_j(BlockState state)
  {
    return SHAPES.get(state.get(FACING));
  }
  
  public BlockState rotate(BlockState state, Rotation rot)
  {
    return state.with(FACING, rot.rotate(state.get(FACING)));
  }
  
  public BlockState mirror(BlockState state, Mirror mirrorIn)
  {
    return state.rotate(mirrorIn.toRotation(state.get(FACING)));
  }
  
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
  {
    builder.add(FACING);
  }
  
  public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
    return facing.getOpposite() == stateIn.get(FACING) && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : stateIn;
  }
  
  @OnlyIn(Dist.CLIENT)
  public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
  {
    Direction direction = stateIn.get(FACING);
    double x = (double) pos.getX() + 0.5D;
    double y = (double) pos.getY() + 0.7D;
    double z = (double) pos.getZ() + 0.5D;
    double vOff = 0.18D;
    double hOff = 0.4D;
    Direction direction1 = direction.getOpposite();
    if (rand.nextBoolean() && rand.nextBoolean())
    {
      worldIn.addParticle(ParticleTypes.SMOKE, x + hOff * (double) direction1.getXOffset(), y + vOff, z + hOff * (double) direction1.getZOffset(), 0.0D, 0.0D, 0.0D);
    }
    
    worldIn.addParticle(ParticleTypes.FLAME, x + hOff * (double) direction1.getXOffset(), y + vOff, z + hOff * (double) direction1.getZOffset(), 0.0D, 0.0D, 0.0D);
  }
}
