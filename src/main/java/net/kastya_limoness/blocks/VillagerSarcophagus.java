package net.kastya_limoness.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;

public class VillagerSarcophagus extends FacingBlock {
	public static final BooleanProperty FULL = BooleanProperty.of("full");
	public static final DirectionProperty FACING = DirectionProperty.of("facing");
	public VillagerSarcophagus() {
		super(FabricBlockSettings.copyOf(Blocks.DISPENSER));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(FACING);
		builder.add(FULL);
	}

	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return (BlockState)this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
	}
}
