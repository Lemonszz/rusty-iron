package party.lemons.rusted_iron.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import party.lemons.rusted_iron.RustedIron;

import java.util.Random;

@Mixin(Block.class)
public abstract class BlockMixin extends AbstractBlock
{
	public BlockMixin(Settings settings)
	{
		super(settings);
	}

	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
	{
		if((Object)this == Blocks.IRON_BLOCK)
		{
			this.oxidize(world, world.getBlockState(pos), pos);
		}
	}

	@Override
	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
		super.onBlockAdded(state, world, pos, oldState, notify);
		this.scheduleOxidation(world, (Block)(Object)this, pos);
	}

	//public int getOxidationTime(Random random) {
	//	return 1200000 + random.nextInt(768000);
	//}
	public int getOxidationTime(Random random) {
		return 100;
	}

	public BlockState getOxidationResult(BlockState state)
	{
		return RustedIron.LIGHTLY_WEATHERED_IRON_BLOCK.getDefaultState();
	}

	public void scheduleOxidation(World world, Block block, BlockPos pos) {
		world.getBlockTickScheduler().schedule(pos, block, this.getOxidationTime(world.getRandom()));
	}

	public void oxidize(World world, BlockState state, BlockPos pos) {
		world.setBlockState(pos, this.getOxidationResult(state));
	}
}
