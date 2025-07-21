package dev.bebebea_loste.panda_plushies.types;

import com.mojang.serialization.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.*;
import net.minecraft.util.shape.*;
import net.minecraft.world.*;
import java.util.Objects;

public class PlushBlock extends HorizontalFacingBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);
    public static final MapCodec<PlushBlock> CODEC = createCodec(PlushBlock::new);

    public static final BooleanProperty SITTING = BooleanProperty.of("sitting");

    public PlushBlock(Settings settings) {
        super(settings.noCollision().breakInstantly().noBlockBreakParticles().nonOpaque());
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(SITTING, true));
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        BlockState belowstate = world.getBlockState(pos.down());
        if (belowstate.isAir()) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (world.getBlockState(pos.down()).isAir()) {
            return false;
        }
        return super.canPlaceAt(state, world, pos);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(SITTING, Objects.requireNonNull(ctx.getPlayer()).isSneaking());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(SITTING);
    }

}