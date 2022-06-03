package party.lemons.rustediron.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class RustingIronStairBlock extends StairBlock implements WeatheringIron {
	private final IronState weatherState;

	public RustingIronStairBlock(IronState weatherState, BlockState blockState, BlockBehaviour.Properties properties) {
		super(blockState, properties);
		this.weatherState = weatherState;
	}

	public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
		this.onRandomTick(blockState, serverLevel, blockPos, random);
	}

	@Override
	public boolean isRandomlyTicking(BlockState blockState) {
		return WeatheringIron.getNext(blockState.getBlock()).isPresent();
	}

	public IronState getAge() {
		return this.weatherState;
	}
}
