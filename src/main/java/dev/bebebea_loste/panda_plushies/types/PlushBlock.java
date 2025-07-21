package dev.bebebea_loste.panda_plushies.types;

import com.mojang.serialization.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import net.minecraft.util.shape.*;
import net.minecraft.world.*;
import net.minecraft.util.math.Direction;
import java.util.Objects;
import net.minecraft.block.SideShapeType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;

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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(SITTING, Objects.requireNonNull(ctx.getPlayer()).isSneaking());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(SITTING);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);

        // Break if block below is now air
        BlockState belowBlockState = world.getBlockState(pos.down());
        if (belowBlockState.isAir()) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        // Block below isn't air
        if (world.getBlockState(pos.down()).isAir()) {
            return false;
        }
        // Block below is solid on its upper side
        else if (!(world.getBlockState(pos.down()).isSideSolid(world, pos.down(), Direction.UP, SideShapeType.FULL))) {
            return false;
        }
        // --> allow placement
        return super.canPlaceAt(state, world, pos);
    }

    // Make plushie change between sitting/laying when interacted
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        boolean currentState = state.get(SITTING);
        currentState = !currentState;

        world.setBlockState(pos, state.with(SITTING, currentState));

        world.playSound(
                pos.getX(),
                pos.getY(),
                pos.getZ(),
                SoundEvent.of(Identifier.of("minecraft", "block.wool.place")),
                SoundCategory.BLOCKS,
                1,
                1,
                true
        );

        //return super.onUse(state, world, pos, player, hit);
        return ActionResult.SUCCESS;
    }
}