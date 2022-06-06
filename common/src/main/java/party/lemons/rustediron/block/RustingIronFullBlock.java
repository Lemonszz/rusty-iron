package party.lemons.rustediron.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class RustingIronFullBlock extends Block implements WeatheringIron
{
	private final IronState weatherState;

	public RustingIronFullBlock(IronState weatherState, Properties properties) {
		super(properties);
		this.weatherState = weatherState;
	}

	public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
		this.onRandomTick(blockState, serverLevel, blockPos, random);
	}

	public boolean isRandomlyTicking(BlockState blockState) {
		return WeatheringIron.getNext(blockState.getBlock()).isPresent();
	}

	@Override
	public IronState getAge()
	{
		return weatherState;
	}
}
